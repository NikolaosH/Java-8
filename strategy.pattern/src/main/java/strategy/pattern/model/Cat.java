package strategy.pattern.model;

public class Cat extends Animal {

	public Cat(final String animalName) {
	
		super(animalName, new CannotFly());
	}
	
	
	public Cat(final String animalName, final IFlyBehavior flyBehavior) {
		
		super(animalName, flyBehavior);
	}
}
