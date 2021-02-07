package model.selection.criteria;

import model.Apple;

public class AppleWeightGreaterThan150 implements IApplePredicate {

    @Override
    public boolean test(Apple apple) {
	
	return apple.getWeight() > 150;
    }

}
