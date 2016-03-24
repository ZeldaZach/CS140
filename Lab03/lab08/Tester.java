package lab08;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Tester
{
	StudentDatabase sd = new StudentDatabase();

	@Before
	public void setup()
	{
		sd.add(new Student("Zach", "Halpern", 2015, 284952, 16, 3.80));
		sd.add(new Student("Mark", "Child", 2012, 395814, 13, 3.98));
		sd.add(new Student("Sammy", "Smithson", 2013, 927583, 14, 2.99));
		sd.add(new Student("Drew", "Hampton", 2015, 104859, 16, 3.51));
		sd.add(new Student("Stacy", "Rogers", 2014, 106738, 18, 3.25));
	}
	
	@Test
	public void testNumStudents()
	{
		assertEquals(5, DatabaseUtilities.numStudents(sd));
	}
	
	@Test
	public void testMaxGPA()
	{
		assertEquals(3.98, DatabaseUtilities.maxGPA(sd), 1E-6);
	}
	
	@Test
	public void testAverageGPA()
	{
		// (3.80+3.98+2.99+3.51+3.25)/5 = 3.506
		assertEquals(3.506, DatabaseUtilities.averageGPA(sd), 1E-6);
	}
	
	@Test
	public void testNumGPAAbove()
	{
		assertEquals(4, DatabaseUtilities.numGPAAbove(sd, 3.0));
		assertEquals(3, DatabaseUtilities.numGPAAbove(sd, 3.4));
		assertEquals(2, DatabaseUtilities.numGPAAbove(sd, 3.7));
		assertEquals(1, DatabaseUtilities.numGPAAbove(sd, 3.9));
	}
}
