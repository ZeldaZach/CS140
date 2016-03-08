package assignment05;

import java.util.ArrayList;
import java.util.Collections;

public class Driver
{
	public static void main(String[] args)
	{
		Pizza order = new MediumCheesePizza();
		System.out.println(order.getDescription() + " " + order.getCost());
		order = new Mushroom(order);
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new ExtraCheese(order); // Extra1
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new Mushroom(order); // Mush2
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new ExtraCheese(order); // Extra1
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new Pepperoni(order);
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new ExtraCheese(order); // Extra1
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new GlutenFree(order); // Gluten1
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = new Mushroom(order); // Mush2
		System.out.println(order.getDescription() + " " + order.getCost());
		
		order = sortToppings(order);
		System.out.println(order.getDescription() + " " + order.getCost());
	}

	public static Pizza sortToppings(Pizza p)
	{
		ArrayList<Pizza> list = new ArrayList<>();

		while (p instanceof PizzaTopping)
		{
			list.add(p);
			p = ((PizzaTopping) p).getOn();
		}

		list.add(p);

		Collections.sort(list);

		p = list.get(list.size() - 1);

		for (int i = list.size() - 2; i >= 0; --i)
		{
			((PizzaTopping) list.get(i)).setOn(p);
			p = list.get(i);
		}

		return p;	
	}
}