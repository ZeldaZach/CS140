package assignment06;

public class Child extends Parent
{
	private String cName;
	
	public Child(String p, String c)
	{
		super(p);
		cName = c;
	}
	
	@Override
	public void print()
	{
		super.print();
		System.out.println(cName);
	}
}
