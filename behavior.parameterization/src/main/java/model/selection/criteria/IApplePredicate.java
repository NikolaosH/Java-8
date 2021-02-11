package model.selection.criteria;

import model.Apple;

/**
 * This interface acts as a predicate
 */
@FunctionalInterface
public interface IApplePredicate {

    boolean test(Apple apple);
}
