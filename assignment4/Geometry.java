package assignment04;

import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.util.Collections;

public class Geometry
{
	
	public static void main(String[] args)
	{
		// Test with 2 cases remaining
		ArrayList<Point2D.Double> test2 = new ArrayList<>();
		test2.add(new Point2D.Double(1,2));
		test2.add(new Point2D.Double(9,9));
		test2.add(new Point2D.Double(5,5));
		test2.add(new Point2D.Double(3,3));
		
		System.out.println("Input List: " + test2);
		reduce(test2);
		System.out.println("Reduced List: " + test2);
		System.out.println("Min Area: " + area(test2) + "\n");
		
		// Test with 3 cases remaining
		ArrayList<Point2D.Double> test3 = new ArrayList<>();
		test3.add(new Point2D.Double(0,0));
		test3.add(new Point2D.Double(10,10));
		test3.add(new Point2D.Double(5,5));
		test3.add(new Point2D.Double(11,11));
		test3.add(new Point2D.Double(4,4));
		test3.add(new Point2D.Double(3,3));
		test3.add(new Point2D.Double(11,10));
		test3.add(new Point2D.Double(2,1000));
		test3.add(new Point2D.Double(1,1000));
		
		System.out.println("Input List: " + test3);
		reduce(test3);
		System.out.println("Reduced List: " + test3);
		System.out.println("Min Area: " + area(test3) + "\n");
		
		// Test with 4 cases remaining
		ArrayList<Point2D.Double> test4 = new ArrayList<>();
		test4.add(new Point2D.Double(1,1));
		test4.add(new Point2D.Double(3,10));
		test4.add(new Point2D.Double(20,5));
		test4.add(new Point2D.Double(5,0));
		test4.add(new Point2D.Double(5,5));
		
		System.out.println("Input List: " + test4);
		reduce(test4);
		System.out.println("Reduced List: " + test4);
		System.out.println("Min Area: " + area(test4) + "\n");
	}
	
	public static void reduce(ArrayList<Point2D.Double> list)
	{
		if (list == null || list.size() < 2)
			throw new IllegalArgumentException("List not long enough");
		
		Point2D.Double[] tmp = list.toArray(new Point2D.Double[0]);
		
		for(int i = 0; i < tmp.length; i++)
		{
			boolean test1 = false;
			boolean test2 = false;
			boolean test3 = false;
			boolean test4 = false;
			
			for (int j = 0; j < tmp.length; j++)
			{
				if (j == i || tmp[i] == null || tmp[j] == null) // Prevent removing all elements
				{
					continue;
				}

				if (tmp[i].getX() >= tmp[j].getX())
				{
					test1 = true;
				}
			
				if (tmp[i].getX() <= tmp[j].getX())
				{
					test2 = true;
				}
			
				if (tmp[i].getY() >= tmp[j].getY())
				{
					test3 = true;
				}
			
				if (tmp[i].getY() <= tmp[j].getY())
				{
					test4 = true;
				}
			}

			if (test1 && test2 && test3 && test4)
			{
				tmp[i] = null;
				list.set(i, null);
			}
		}

		// Remove all nulls from ArrayList
		list.removeAll(Collections.singleton(null));
	
	}
	
	public static double area(ArrayList<Point2D.Double> list)
	{
		if (list == null || list.size() < 2)
			throw new IllegalArgumentException("List not long enough");
		
		double minX = list.get(0).getX();
		double maxX = list.get(0).getX();
		double minY = list.get(0).getY();
		double maxY = list.get(0).getY();
		
		for (int i = 1; i < list.size(); i++)
		{
			double xCoord = list.get(i).getX();
			double yCoord = list.get(i).getY();
			
			if (xCoord > maxX)
			{
				maxX = xCoord;
			}
			else if (xCoord < minX)
			{
				minX = xCoord;
			}
			
			if (yCoord > maxY)
			{
				maxY = yCoord;
			}
			else if (yCoord < minY)
			{
				minY = yCoord;
			}
		}

		return (maxX - minX)*(maxY-minY);
	}
}