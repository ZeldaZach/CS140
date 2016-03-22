package assignment07;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JUnitTester
{	
	private Piece[] piece = new Piece[11];
	private Subassembly[] assembly = new Subassembly[5];

	@Before
	public void setup()
	{
		piece[0] = new Piece("Piece 0", 6.50, 5.8);
		piece[1] = new Piece("Piece 1", 1.50, 10);
		piece[2] = new Piece("Piece 2", 1.00, 7.5);
		piece[3] = new Piece("Piece 3", 2.50, 30.2);
		piece[4] = new Piece("Piece 4", 2.00, 16.7);
		piece[5] = new Piece("Piece 5", 3.50, 29.0);
		piece[6] = new Piece("Piece 6", 3.00, 17.9);
		piece[7] = new Piece("Piece 7", 4.50, 11);
		piece[8] = new Piece("Piece 8", 4.00, 14.4);
		piece[9] = new Piece("Piece 9", 5.50, 3);
		piece[10] = new Piece("Piece 10", 5.00, 2.9);

		Subassembly sub0 = new Subassembly("Assembly 0");
		Subassembly sub1 = new Subassembly("Assembly 1");
		Subassembly sub2 = new Subassembly("Assembly 2");
		Subassembly sub3 = new Subassembly("Assembly 3");
		Subassembly sub4 = new Subassembly("Assembly 4");

		assembly[0] = sub0;
		assembly[1] = sub1;
		assembly[2] = sub2;
		assembly[3] = sub3;
		assembly[4] = sub4;

		sub0.add(piece[0]);
		sub0.add(sub1);
		sub1.add(piece[1]);
		sub1.add(piece[2]);
		sub1.add(piece[3]);
		sub0.add(sub2);
		sub2.add(sub3);
		sub3.add(piece[4]);
		sub3.add(piece[5]);
		sub3.add(piece[6]);
		sub2.add(sub4);
		sub4.add(piece[7]);
		sub4.add(piece[8]);
		sub4.add(piece[9]);
		sub2.add(piece[10]);	
	}

	@Test
	public void printPrettyList()
	{
		for (Product p : assembly[0])
			System.out.println(p);
	}

	@Test
	public void testGetCost()
	{
		assertEquals(39.00, assembly[0].getCost(), 1E-6);
	}

	@Test
	public void testGetManufacturingTime()
	{
		assertEquals(30.2, assembly[0].getManufactureTime(), 1E-6);
	}
	
	@Test
	public void testCostIncrease()
	{
		Visitor v = new CostIncreaseVisitor(50); // Increase cost by 50%
		for (Product p : assembly[0])
			p.accept(v);

		assertEquals(39.00 + 39.00/2, assembly[0].getCost(), 1E-6);
	}
	
	@Test
	public void testManufactureDecrease()
	{
		Visitor v = new ManufactureTimeVisitor(-25); // Reduce time by 25%
		for (Product p : assembly[0])
			p.accept(v);
		
		assertEquals(30.2 - 30.2/4, assembly[0].getManufactureTime(), 1E-6);
	}
	
	@Test
	public void testSorter()
	{
		Visitor v = new Sorter();
		for (Product p : assembly[0])
			p.accept(v);
		
		System.out.println("\n--Line Break--\n");
		printPrettyList(); // Call another JUnit Test Case to re-run
	}
}
