package model;

import java.util.Objects;

public class Apple {

    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {

	setWeight(weight);
	setColor(color);
    }

    public Integer getWeight() {
	return weight;
    }

    public String getColor() {
	return color;
    }

    public void setWeight(Integer weight) {
	if (weight < 0) {
	    throw new IllegalArgumentException("Apple weight cannot be negative!");
	}
  	this.weight = weight;
      }

    public void setColor(String color) {
	this.color = Objects.requireNonNull(color, "Apple color cannot be null!");
    }

    public String toString() {
	return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }

}
