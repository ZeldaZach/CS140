package assignment08;

import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestQuestions
{
	@Test
	public void testQ2_sum()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random r = new Random(); // this is java.util.Random
		int count = 0;
		for(int i = 0; i < 100; i++)
		{
			int j = r.nextInt(1000);
			list.add(j);
			count += j;
		}

		assertEquals(Question2.recursiveSum(list), count, 1E-6);
	}

	@Test
	public void testQ2_null()
	{
		assertEquals(0, Question2.recursiveSum(null));
	}

	@Test
	public void testQ2_empty()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertEquals(0, Question2.recursiveSum(list));
	}

	@Test
	public void testQ3_0()
	{
		assertEquals(0, Question3.squareRoot(0), 1E-6);
	}

	@Test
	public void testQ3_2()
	{
		assertEquals(Math.sqrt(2), Question3.squareRoot(2), 1E-6);
	}

	@Test
	public void testQ4_triangle()
	{
		Point2D.Double point1 = new Point2D.Double(0, 0);
		Point2D.Double point2 = new Point2D.Double(10, 10);
		Point2D.Double point3 = new Point2D.Double(10, 0);

		ArrayList<Point2D.Double> pointList = new ArrayList<>(Arrays.asList(point1, point2, point3));

		assertEquals(50, Question4.getArea(pointList), 1E-6);
	}

	@Test
	public void testQ4_rectangle()
	{
		Point2D.Double point1 = new Point2D.Double(0, 0);
		Point2D.Double point2 = new Point2D.Double(10, 10);
		Point2D.Double point3 = new Point2D.Double(10, 0);
		Point2D.Double point4 = new Point2D.Double(0, 10);

		ArrayList<Point2D.Double> pointList = new ArrayList<>(Arrays.asList(point1, point2, point3, point4));

		assertEquals(100, Question4.getArea(pointList), 1E-6);
	}
	
	@Test
	public void testQ4_regularHexagon()
	{
		/*
		 * A = C/2 = 2
		 * B = sqrt(3)/2 * C == 2*Math.sqrt(3)
		 * C = C
		 * --------
		 * C = 4
		 */
		Point2D.Double point1 = new Point2D.Double(0, 6);
		Point2D.Double point2 = new Point2D.Double(0, 2);
		Point2D.Double point3 = new Point2D.Double(2*Math.sqrt(3), 0);
		Point2D.Double point4 = new Point2D.Double(4*Math.sqrt(3), 2);
		Point2D.Double point5 = new Point2D.Double(4*Math.sqrt(3), 6);
		Point2D.Double point6 = new Point2D.Double(2*Math.sqrt(3), 8);
		
		ArrayList<Point2D.Double> pointList = new ArrayList<>(Arrays.asList(point1, point2, point3, point4, point5, point6));
		
		// A = 3*s^2*sqrt(3)/2
		assertEquals(3*4*4*Math.sqrt(3)/2, Question4.getArea(pointList), 1E-6);
	}
}
