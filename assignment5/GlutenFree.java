package assignment05;

public class GlutenFree extends PizzaTopping
{
	public GlutenFree(Pizza p)
	{
		super(p);
	}
	
	public double getCost()
	{
		return 2.50 + getOn().getCost();
	}
}