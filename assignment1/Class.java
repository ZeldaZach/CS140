package assignment01;

public class Class {
	private String name;
	private String number;
	private int numCredits;
	private int crn;
	private double qualPoints;

	public Class(String aName, String aNumber, int aNumCredits, int aCrn)
	{
		name = aName;
		number = aNumber;
		numCredits = aNumCredits;
		crn = aCrn;
		qualPoints = 0.0;
	}
	
	public static final Class DUMMY_CLASS = new Class("Dummy", "000", 0, 0);

	public String getName()
	{
		return name;
	}

	public String getNumber()
	{
		return number;
	}

	public int getNumCredits()
	{
		return numCredits;
	}

	public int getCrn()
	{
		return crn;
	}

	public double getQualPoints()
	{
		return qualPoints;
	}

	public void setQualPoints(double qPoints)
	{
		qualPoints = qPoints;
	}
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public void setNumber(String aNumber)
	{
		number = aNumber;
	}
	
	public void setNumCredits(int aNumCredits)
	{
		numCredits = aNumCredits;
	}
	
	public void setCrn(int aCrn)
	{
		crn = aCrn;
	}
}