package behavior.parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import behavior.parameterization.inventory.AppleInventory;
import model.Apple;
import model.selection.criteria.AppleWeightGreaterThan150;
import model.selection.criteria.GreenApple;
import model.selection.criteria.IApplePredicate;

/**
 * 
 * Behavior parameterization is taking a block of code and making it available without executing it.
 * For example it can be passed to a method which it will be used internally to accomplish the task.
 * 
 * @author Nikolaos Hadjitheofanous
 */
public class Main {

    private static IApplePredicate applePredicateAsClassField = (apple) -> apple.getColor().equalsIgnoreCase("red");
    
    public static void main(String[] args) {

	AppleInventory appleInventory = new AppleInventory();
	List<Apple> inventory = appleInventory.getAppleInventory();

	List<Apple> greenApples = filterApplesByColor(inventory, "green");
	System.out.println(greenApples);

	List<Apple> redApples = filterApplesByColor(inventory, "red");
	System.out.println(redApples);

	List<Apple> greenApples2 = filterStream(inventory, new GreenApple());
	List<Apple> heavyApples = filterStream(inventory, new AppleWeightGreaterThan150());
	List<Apple> redApples2 = filterStream(inventory, new IApplePredicate() {

	    public boolean test(Apple apple) {
		return apple.getColor().equals("red");
	    }
	});
	List<Apple> redApplesLambda = filterStream(inventory, (apple) -> apple.getColor().equalsIgnoreCase("red"));
	List<Apple> redApplesLambdaAsClassField = filterStream(inventory, applePredicateAsClassField);

	System.out.println(greenApples2);
	System.out.println(heavyApples);
	System.out.println(redApples2);
	System.out.println(redApplesLambda);
	System.out.println(redApplesLambdaAsClassField);
    }
    
    /**
     * 
     * What if we want to filter "red" apples?
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {

	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
	    if ("green".equals(apple.getColor())) {
		result.add(apple);
	    }
	}
	return result;
    }


    /**
     * 
     * What if we want to filer based on the apple weight?
     * Probably someone will duplicate this method in order to pass a given weight value.
     * This breaks the DRY principle. Why should we care?
     * What will do if we had lots of similar methods (instead of color we had weight) 
     * and we want to use Java 8 Streams instead of For statements (or to enhance performance)?
     * Then ALL methods needs to be modified instead of a single one!
     * 
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {

	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
	    if (apple.getColor().equals(color)) {
		result.add(apple);
	    }
	}
	return result;
    }

    /**
     * 
     * This is good Implementation before Java 8 Streams API and Lambda Expressions.
     */
    public static List<Apple> filter(List<Apple> inventory, IApplePredicate applePredicate) {

	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
	    if (applePredicate.test(apple)) {
		result.add(apple);
	    }
	}
	
	return result;
    }

    /**
     * 
     * The selection criteria can be seen as different behaviors for the filter method. 
     * How this is related to the Strategy Design Pattern? 
     * We defined a family of algorithms (classes implementing the IApplePredicate) 
     * and select an algorithm at run-time.
     * 
     * @param inventory      The inventory which contains all apples
     * @param applePredicate Make use of different selection criteria
     *                       implementations
     * @return
     */
    public static List<Apple> filterStream(List<Apple> inventory, IApplePredicate applePredicate) {

	return inventory.stream().filter((apple) -> applePredicate.test(apple)).collect(Collectors.toList());
    }
}
