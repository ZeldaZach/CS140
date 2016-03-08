package assignment05;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class PizzaTester
{
	@Test
	public void test1()
	{
		Pizza pie = new MediumCheesePizza();
		pie = new GlutenFree(pie);
		pie = new ExtraCheese(pie);
		pie = new Pepperoni(pie);
		
		assertEquals(14.0, pie.getCost(), 0.001);
	}
	
	@Test
	public void test2()
	{
		Pizza pie = new SmallCheesePizza();
		pie = new ExtraCheese(pie);
		pie = new ExtraCheese(pie);
		pie = new Mushroom(pie);
		pie = new Pepperoni(pie);
		
		assertEquals(10.25, pie.getCost(), 0.001);
	}
}