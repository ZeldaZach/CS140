package lab08;

public class Student
{
	private String firstName, lastName;
	private int yearEnrolled, BNumber, numCredits;
	private double GPA;
	
	public Student(String fn, String ln, int ye, int bn, int nc, double gpa)
	{
		firstName = fn;
		lastName = ln;
		yearEnrolled = ye;
		BNumber = bn;
		numCredits = nc;
		GPA = gpa;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getYearEnrolled()
	{
		return yearEnrolled;
	}

	public int getBNumber()
	{
		return BNumber;
	}

	public int getNumCredits()
	{
		return numCredits;
	}

	public double getGPA()
	{
		return GPA;
	}
	
	@Override
	public String toString()
	{
		return firstName + " " + lastName + " " + yearEnrolled + " " +
				GPA + " " + BNumber + " " + numCredits;
	}
	
}
