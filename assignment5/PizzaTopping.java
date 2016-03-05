package assignment05;

public abstract class PizzaTopping implements Pizza
{
	Pizza on;
	
	public String getDescription()
	{
		if (on instanceof PizzaTopping)
		{
			return ", " + on.getDescription();
		}
		else
		{
			return " on " + on.getDescription();
		}
	}
	
	public void setOn(Pizza p)
	{
		on = p;
	}
	
	public Pizza getOn()
	{
		return on;
	}
	
	public PizzaTopping(Pizza p)
	{
		on = p;
	}
	
	public int compareTo(Pizza p)
	{
		int retVal = 0;
		
		if (on instanceof PizzaTopping)
		{
			retVal = this.getClass().getSimpleName().compareTo(p.getClass().getSimpleName());
		}
		else
		{
			retVal = -1;
		}
		
		return retVal;
	}
}