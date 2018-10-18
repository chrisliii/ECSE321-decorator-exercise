package org.mcgill.ecse321.designpatterns.decorator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DecoratorTest {
	private HotBeverage black;
	private HotBeverage tea;
	private HotBeverage tMilk;
	private HotBeverage tSugar;
	private HotBeverage tMilkAndSugar;
	private HotBeverage wMilk;
	private HotBeverage wSugar;
	private HotBeverage wMilkAndSugar;
	
	@Before
	public void setUp() throws Exception {
		black = new BlackCoffee();
		wMilk = new AddMilk(black);
		wSugar = new AddSugar(black);
		wMilkAndSugar = new AddMilk(wSugar);
		tea = new BlackTea();
		tMilk = new AddMilk(tea);
		tSugar = new AddSugar(tea);
		tMilkAndSugar = new AddMilk(tSugar);
	}

	@Test
	public void test() {
		// Check costs
		assertEquals(black.getCost(), 2.0, 0.001);
		assertEquals(wMilk.getCost(), 2.5, 0.001);
		assertEquals(wSugar.getCost(), 2.25, 0.001);
		assertEquals(wMilkAndSugar.getCost(), 2.75, 0.001);
		
		//Check costs for tea
		assertEquals(tea.getCost(), 1.8, 0.001);
		assertEquals(tMilk.getCost(), 2.3, 0.001);
		assertEquals(tSugar.getCost(), 2.05, 0.001);
		assertEquals(tMilkAndSugar.getCost(), 2.55, 0.001);
		
		// Check ingredients
		List<String> blackIngredients = new ArrayList<String>();
		blackIngredients.add("Coffee");
		checkIngredientsMatch(blackIngredients, black.getIngredients());
		
		List<String> wMilkIngredients = new ArrayList<String>(blackIngredients);
		wMilkIngredients.add("Milk");
		checkIngredientsMatch(wMilkIngredients, wMilk.getIngredients());
		
		List<String> wSugarIngredients = new ArrayList<String>(blackIngredients);
		wSugarIngredients.add("Sugar");
		checkIngredientsMatch(wSugarIngredients, wSugar.getIngredients());
		
		List<String> wMilkAndSugarIngredients = new ArrayList<String>(wSugarIngredients);
		wMilkAndSugarIngredients.add("Milk");
		checkIngredientsMatch(wMilkAndSugarIngredients, wMilkAndSugar.getIngredients());
		
		// Check ingredients
		List<String> teaIngredients = new ArrayList<String>();
		teaIngredients.add("Tea");
		checkIngredientsMatch(teaIngredients, tea.getIngredients());
		
		List<String> tMilkIngredients = new ArrayList<String>(teaIngredients);
		tMilkIngredients.add("Milk");
		checkIngredientsMatch(tMilkIngredients, tMilk.getIngredients());
		
		List<String> tSugarIngredients = new ArrayList<String>(teaIngredients);
		tSugarIngredients.add("Sugar");
		checkIngredientsMatch(tSugarIngredients, tSugar.getIngredients());
		
		List<String> tMilkAndSugarIngredients = new ArrayList<String>(tSugarIngredients);
		tMilkAndSugarIngredients.add("Milk");
		checkIngredientsMatch(tMilkAndSugarIngredients, tMilkAndSugar.getIngredients());
	}
	
	private void checkIngredientsMatch(List<String> ing1, List<String> ing2) {
		assertEquals(ing1.size(), ing2.size());
		
		for(String ingredient : ing1) {
			assertTrue(ing2.contains(ingredient));
		}
	}
}