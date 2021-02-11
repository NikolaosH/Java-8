package strategy.pattern.model;

public class Eagle extends Animal{

	public Eagle(final String animalName) {
		
		super(animalName, new ItFlys());
	}

}
