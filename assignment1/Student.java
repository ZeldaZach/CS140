 

public class Student {
	private Person self;
	private Class class1 = Class.DUMMY_CLASS;
	private Class class2 = Class.DUMMY_CLASS;
	private Class class3 = Class.DUMMY_CLASS;
	private Class class4 = Class.DUMMY_CLASS;
	
	public Student(Person aSelf)
	{
		self = aSelf;
	}
	
	public void setQualPoints1(double qPoints)
	{
	    class1.setQualPoints(qPoints);
	}
	
	public void setQualPoints2(double qPoints)
	{
	    class2.setQualPoints(qPoints);
	}
	
	public void setQualPoints3(double qPoints)
	{
	    class3.setQualPoints(qPoints);
	}
	
	public void setQualPoints4(double qPoints)
	{
	    class4.setQualPoints(qPoints);
	}
	
	public String getName()
	{
		return self.getFirstName() + " " + self.getMiddleInitial() + ". " + self.getLastName();
	}
	
	public void setClass1(Class aClass)
	{
		class1 = aClass;
	}
	public void setClass2(Class aClass)
	{
		class2 = aClass;
	}
	public void setClass3(Class aClass)
	{
		class3 = aClass;
	}
	public void setClass4(Class aClass)
	{
		class4 = aClass;
	}
	
	public Class getClass1()
	{
		return class1;
	}
	public Class getClass2()
	{
		return class2;
	}
	public Class getClass3()
	{
		return class3;
	}
	public Class getClass4()
	{
		return class4;
	}
	
	public double computeSemesterGPA()
	{
		double gpa = 0.0;
		double totalPoints = 0.0;
		int totalCredits = 0;
		
		Class class1 = getClass1();
		Class class2 = getClass2();
		Class class3 = getClass3();
		Class class4 = getClass4();
		
		totalPoints += class1.getQualPoints();
		totalPoints += class2.getQualPoints();
		totalPoints += class3.getQualPoints();
		totalPoints += class4.getQualPoints();
		
		totalCredits += class1.getNumCredits();
		totalCredits += class2.getNumCredits();
		totalCredits += class3.getNumCredits();
		totalCredits += class4.getNumCredits();
		
		if (totalCredits > 0)
			gpa = totalPoints / totalCredits;

		return gpa;
	}
}
