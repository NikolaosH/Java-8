package pattern.behavioral.strategy.model;

public class Eagle extends Animal {

	public Eagle(final String animalName) {

		super(animalName, new ItFlys());
	}

	public Eagle(final String animalName, final IFlyBehavior IFlyBehavior) {

		super(animalName, IFlyBehavior);
	}
	
}
