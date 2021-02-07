package model;

import java.util.Objects;

public class AppleImmutable {

    private final int weight;
    private final String color;

    public AppleImmutable(final int weight, final String color) {

	if (weight < 0) {
	    throw new IllegalArgumentException("Apple weight cannot be negative!");
	}

	this.weight = weight;
	this.color = Objects.requireNonNull(color, "Apple color cannot be null!");
    }

    public Integer getWeight() {
	return weight;
    }

    public String getColor() {
	return color;
    }

    public String toString() {
	return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }

}
