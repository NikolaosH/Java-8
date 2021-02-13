package pattern.behavioral.strategy;

import pattern.behavioral.strategy.model.Animal;
import pattern.behavioral.strategy.model.CannotFly;
import pattern.behavioral.strategy.model.Cat;
import pattern.behavioral.strategy.model.Eagle;
import pattern.behavioral.strategy.model.ItFlys;

public class Main {

	public static void main(String[] args) {

		Animal cat = new Cat("Tiger Cat", new CannotFly());
		Animal eagle = new Eagle("Sea Eagle", new ItFlys());
		Animal flyingCat = new Cat("Amazing Cat", () -> "I am a special cat and I CAN FLY!");
		
		System.out.println(cat.getName() + " says: "+ cat.getFlyingType().fly());
		System.out.println(eagle.getName() +" says: "+  eagle.getFlyingType().fly());
		System.out.println(flyingCat.getName() + " says: "+ flyingCat.getFlyingType().fly());
	}

}
