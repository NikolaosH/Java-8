package behavior.parameterization.inventory;

import java.util.List;

import model.Apple;
import model.AppleImmutable;

public interface Inventory {

	/**
	 * 
	 * @return A mutable list of apples.
	 */
    List<Apple> getAppleInventory();
    
    /**
     * 
     * @return A immutable list of apples.
     */
    List<AppleImmutable> getImmutableAppleInventory();
}
