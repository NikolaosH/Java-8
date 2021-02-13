package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static strategy.Discounter.christmas;
import static strategy.Discounter.easter;
import static strategy.Discounter.newYear;

import org.junit.jupiter.api.Test;

public class StrategyDesignPatternUnitTest {

	@Test
	public void shouldDivideByTwo_WhenApplyingStaffDiscounter() {

		// Given
		final BigDecimal initialProductValue = BigDecimal.valueOf(100);
		final BigDecimal productValueAfterDiscount = BigDecimal.valueOf(50.0);
		final Discounter staffDiscounter = new EasterDiscounter();

		// When
		final BigDecimal discountedValue = staffDiscounter.apply(initialProductValue);

		// Then
		assertEquals(productValueAfterDiscount, discountedValue);
	}

	@Test
	public void shouldDivideByTwo_WhenApplyingStaffDiscounterWithAnonyousTypes() {

		// Given
		final BigDecimal initialProductValue = BigDecimal.valueOf(100);
		final BigDecimal productValueAfterDiscount = BigDecimal.valueOf(50.0);
		Discounter staffDiscounter = new Discounter() {
			@Override
			public BigDecimal apply(BigDecimal amount) {
				return amount.multiply(BigDecimal.valueOf(0.5));
			}
		};

		// When
		final BigDecimal discountedValue = staffDiscounter.apply(initialProductValue);

		// Then
		assertEquals(productValueAfterDiscount, discountedValue);
	}

	@Test
	public void shouldDivideByTwo_WhenApplyingStaffDiscounterWithLamda() {
		
		//Given
		final BigDecimal initialProductValue = BigDecimal.valueOf(100);
		final BigDecimal productValueAfterDiscount = BigDecimal.valueOf(50.0);
		Discounter staffDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));

		//When
		final BigDecimal discountedValue = staffDiscounter.apply(initialProductValue);

		//Then
		assertEquals(productValueAfterDiscount, discountedValue);
	}

	@Test
	public void shouldApplyAllDiscounts() {

		// Given
		final BigDecimal initialProductValue = BigDecimal.valueOf(100);
		List<Discounter> discounters = Arrays.asList(christmas(), newYear(), easter());
		final Discounter combinedDiscounter = discounters.stream().reduce(v -> v, Discounter::combine);
		final BigDecimal productValueAfterDiscount = BigDecimal.valueOf(36);

		// When
		final BigDecimal result = combinedDiscounter.apply(initialProductValue);
		
		//Then
		assertEquals(productValueAfterDiscount.doubleValue(), result.doubleValue());
	}

	@Test
	public void shouldChainDiscounters() {
		
		// Given
		final BigDecimal initialProductValue = BigDecimal.valueOf(100);
		final Function<BigDecimal, BigDecimal> combinedDiscounters = Discounter.christmas().andThen(newYear());
		final BigDecimal productValueAfterDiscount = BigDecimal.valueOf(72);

		// When
		BigDecimal result = combinedDiscounters.apply(initialProductValue);
		
		//Then
		assertEquals(productValueAfterDiscount.doubleValue(), result.doubleValue());
	}

}
