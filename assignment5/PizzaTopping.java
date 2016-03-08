package assignment05;

public abstract class PizzaTopping implements Pizza
{
	Pizza on;
	
	public String getDescription()
	{
		String retStr = getClass().getSimpleName();
		
		if (on instanceof PizzaTopping)
		{
			retStr += ", " + on.getDescription();
		}
		else
		{
			retStr += " on " + on.getDescription();
		}
		
		return retStr;
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
		
		if (p instanceof PizzaTopping)
		{
			retVal = getClass().getSimpleName().compareTo(p.getClass().getSimpleName());
		}
		else
		{
			retVal = -1;
		}
		
		return retVal;
	}
}