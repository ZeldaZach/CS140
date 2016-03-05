package assignment05;

public class SmallCheesePizza implements Pizza
{
	public String getDescription()
	{
		return "Small cheese pizza";
	}
	
	public double getCost()
	{
		return 7.50;
	}
	
	public int compareTo(Pizza p)
	{
		return 0;
	}
}