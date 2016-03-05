package assignment05;

public class LargeCheesePizza implements Pizza
{
	public String getDescription()
	{
		return "Large cheese pizza";
	}
	
	public double getCost()
	{
		return 12.50;
	}
	
	public int compareTo(Pizza p)
	{
		return 0;
	}
}