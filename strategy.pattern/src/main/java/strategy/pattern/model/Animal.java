package strategy.pattern.model;

import java.util.Objects;

public abstract class Animal {

	private final String animalName;

	private int animalAge;

	/**
	 * The class is composed with objects with the right ability build-in. Behavior
	 * can change without side effects (loosely couple)
	 */
	private final IFlyBehavior flyingType;

	public Animal(final String animalName, final IFlyBehavior flyingType) {
		
		this.animalName = Objects.requireNonNull(animalName);
		this.flyingType = Objects.requireNonNull(flyingType);
	}
	
	public String getName() {
		return animalName;
	}

	public int getAge() {
		return animalAge;
	}

	public void setAge(int age) {
		
		if(age<0) {
			throw new IllegalArgumentException("Animal age cannot be less than zero.");
		}
		
		this.animalAge = age;
	}

	public IFlyBehavior getFlyingType() {
		return flyingType;
	}
	
}
