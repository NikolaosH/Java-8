package strategy.pattern;

import strategy.pattern.model.Animal;
import strategy.pattern.model.Cat;
import strategy.pattern.model.Eagle;

public class Main {

	public static void main(String[] args) {

		Animal cat = new Cat("Tiger Cat");
		Animal eagle = new Eagle("Sea Eagle");
		Animal flyingCat = new Cat("Amazing Cat", () -> "I am a special cat and I CAN FLY!");
		
		System.out.println(cat.getName() + " says: "+ cat.getFlyingType().fly());
		System.out.println(eagle.getName() +" says: "+  eagle.getFlyingType().fly());
		System.out.println(flyingCat.getName() + " says: "+ flyingCat.getFlyingType().fly());
	}

}
