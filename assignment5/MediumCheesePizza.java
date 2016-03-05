package assignment05;

public class MediumCheesePizza implements Pizza
{
	public String getDescription()
	{
		return "Medium cheese pizza";
	}
	
	public double getCost()
	{
		return 10.0;
	}
	
	public int compareTo(Pizza p)
	{
		return 0;
	}
}