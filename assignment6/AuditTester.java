package assignment06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class AuditTester
{
	
	/** Harper Audit Tester
	 * Requires one of the following to pass
	 * 2 C/J + 3 W
	 * 3 C/J + 1 W
	 * 4 C/J 
	 */
	
	@Test
	public void test_harper_2C_1W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("C", "W"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertFalse(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_2C_2W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("W"))));
		list.add(new CourseOffering("W301", "Class 301", 201620, new ArrayList<String>(Arrays.asList("W"))));
		list.add(new CourseOffering("W401", "Class 401", 201620, new ArrayList<String>(Arrays.asList("A", "F", "C"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertFalse(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_2C_3W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("W"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F", "W"))));
		list.add(new CourseOffering("W401", "Class 401", 201790, new ArrayList<String>(Arrays.asList("W"))));
		list.add(new CourseOffering("W501", "Class 501", 201620, new ArrayList<String>(Arrays.asList("J"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertTrue(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_2C_1J_1W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("W"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F", "W"))));
		list.add(new CourseOffering("W401", "Class 401", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W501", "Class 501", 201620, new ArrayList<String>(Arrays.asList("C"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertTrue(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_1C_2J_1W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("W"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F", "W"))));
		list.add(new CourseOffering("W401", "Class 401", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W501", "Class 501", 201620, new ArrayList<String>(Arrays.asList("J"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertTrue(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_2C_2J_0W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F"))));
		list.add(new CourseOffering("W401", "Class 401", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W501", "Class 501", 201620, new ArrayList<String>(Arrays.asList("J"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertTrue(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_3C_1J_0W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F"))));
		list.add(new CourseOffering("W401", "Class 401", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W501", "Class 501", 201620, new ArrayList<String>(Arrays.asList("C"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertTrue(ha.writingSatisfied(list));
	}
	
	@Test
	public void test_harper_4C_0J_0W()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W201", "Class 201", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W301", "Class 301", 201610, new ArrayList<String>(Arrays.asList("A", "F"))));
		list.add(new CourseOffering("W401", "Class 401", 201790, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W501", "Class 501", 201620, new ArrayList<String>(Arrays.asList("C"))));
		
		HarpurAudit ha = new HarpurAudit();
		assertTrue(ha.writingSatisfied(list));
	}
	
	/** CS Audit Tester
	 * Requires one of the following to pass
	 * 1 C/J AND "CS301"
	 */
	
	@Test
	public void test_cs_1C_no301()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		
		CSAudit ca = new CSAudit();
		assertFalse(ca.writingSatisfied(list));
	}
	
	@Test
	public void test_cs_2C_no301()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		list.add(new CourseOffering("W301", "Class 301", 201620, new ArrayList<String>(Arrays.asList("J"))));
		
		CSAudit ca = new CSAudit();
		assertFalse(ca.writingSatisfied(list));
	}
	
	@Test
	public void test_cs_0C_yes301()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();	
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		list.add(new CourseOffering("CS301", "CS Writing", 201790, new ArrayList<String>(Arrays.asList("O"))));
		
		CSAudit ca = new CSAudit();
		assertFalse(ca.writingSatisfied(list));
	}
	
	@Test
	public void test_cs_1C_yes301()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		list.add(new CourseOffering("CS301", "CS Writing", 201790, new ArrayList<String>(Arrays.asList("O"))));
		
		CSAudit ca = new CSAudit();
		assertTrue(ca.writingSatisfied(list));
	}
	
	/** SOM Audit Tester
	 * Requires one of the following to pass
	 * 2 C/J
	 */
	
	@Test
	public void test_som_0C_0J()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("A"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		
		SOMAudit sa = new SOMAudit();
		assertFalse(sa.writingSatisfied(list));
	}
	
	@Test
	public void test_som_1C_1J()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		list.add(new CourseOffering("W301", "Class 301", 201620, new ArrayList<String>(Arrays.asList("J"))));
		
		SOMAudit sa = new SOMAudit();
		assertTrue(sa.writingSatisfied(list));
	}
	
	@Test
	public void test_som_0C_2J()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("J"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		list.add(new CourseOffering("W301", "Class 301", 201620, new ArrayList<String>(Arrays.asList("J"))));
		
		SOMAudit sa = new SOMAudit();
		assertTrue(sa.writingSatisfied(list));
	}
	
	@Test
	public void test_som_2C_0J()
	{
		ArrayList<CourseOffering> list = new ArrayList<>();
		list.add(new CourseOffering("W101", "Class 101", 201620, new ArrayList<String>(Arrays.asList("C"))));
		list.add(new CourseOffering("W201", "Class 201", 201620, new ArrayList<String>(Arrays.asList("F"))));
		list.add(new CourseOffering("W301", "Class 301", 201620, new ArrayList<String>(Arrays.asList("C"))));
		
		SOMAudit sa = new SOMAudit();
		assertTrue(sa.writingSatisfied(list));
	}
	
}
