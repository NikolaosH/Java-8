package model.selection.criteria;

import model.Apple;

public class GreenApple implements IApplePredicate {

    private static final String GREEN_COLOR = "Green";
    
    @Override
    public boolean test(Apple apple) {
	
            return apple.getColor().equalsIgnoreCase(GREEN_COLOR);
    }
    
}
