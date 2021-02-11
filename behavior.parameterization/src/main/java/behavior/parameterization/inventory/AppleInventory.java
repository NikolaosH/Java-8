package behavior.parameterization.inventory;

import java.util.Arrays;
import java.util.List;

import model.Apple;
import model.AppleImmutable;

/**
 * In-memory inventory of apples.
 */
public class AppleInventory implements Inventory {

	private static final List<Apple> APPLE_INVENTORY = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"),
			new Apple(120, "red"));

	private static final List<AppleImmutable> IMMUTABLE_APPLE_INVENTORY = Arrays.asList(new AppleImmutable(80, "green"),
			new AppleImmutable(155, "green"), new AppleImmutable(120, "red"));

	@Override
	public List<Apple> getAppleInventory() {

		return APPLE_INVENTORY;
	}

	@Override
	public List<AppleImmutable> getImmutableAppleInventory() {
		return IMMUTABLE_APPLE_INVENTORY;
	}

}
