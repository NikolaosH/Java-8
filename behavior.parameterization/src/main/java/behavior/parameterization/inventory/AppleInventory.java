package behavior.parameterization.inventory;

import java.util.Arrays;
import java.util.List;

import model.Apple;

public class AppleInventory implements Inventory {

    private static final List<Apple> APPLE_INVENTORY = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"),
	    new Apple(120, "red"));

    /**
     * Returns an in memory apple inventory.
     */
    @Override
    public List<Apple> getAppleInventory() {
	return APPLE_INVENTORY;
    }

}
