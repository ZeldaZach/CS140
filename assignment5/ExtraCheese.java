package assignment05;

public class ExtraCheese extends PizzaTopping
{
	public ExtraCheese(Pizza p)
	{
		super(p);
	}
	
	public double getCost()
	{
		return 1.00 + getOn().getCost();
	}
}