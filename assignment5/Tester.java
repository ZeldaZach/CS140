package assignment05;

public class Tester
{
	public static void main(String[] args)
	{
		Pizza order = new MediumCheesePizza();
		System.out.println(order.getDescription() + " " + order.getCost());
		order = new Mushroom(order);
		System.out.println(order.getDescription() + " " + order.getCost());
		order = new Pepperoni(order);
		System.out.println(order.getDescription() + " " + order.getCost());
	}
}