package org.mcgill.ecse321.designpatterns.decorator;

import java.util.ArrayList;
import java.util.List;

// The "ConcreteComponent" class
public class BlackTea implements HotBeverage {
	@Override
	public double getCost() {
		return 1.80;
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = new ArrayList<String>();
		ingredients.add("Tea");
		
		return ingredients;
	}
}