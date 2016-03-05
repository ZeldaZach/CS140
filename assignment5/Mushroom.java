package assignment05;

public class Mushroom extends PizzaTopping
{
	public Mushroom(Pizza p)
	{
		super(p);
	}
	
	public double getCost()
	{
		return 0.25 + getOn().getCost();
	}
}