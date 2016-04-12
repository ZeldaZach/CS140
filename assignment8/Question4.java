package assignment08;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Question4
{
	public static double getArea(ArrayList<Point2D.Double> points)
	{
		if (points.size() < 3)
			return 0;
		

		double area = calcArea(points.get(0), points.get(points.size() - 1), points.get(points.size() - 2));
		points.remove(points.size() - 1);

		return area + getArea(points);
	}

	private static double calcArea(Point2D.Double... points)
	{
		// Math.abs(p.x*q.y + q.x*r.y + r.x*p.y - p.y*q.x - q.y*r.x - r.y*p.x)/2
		// p = 0, q = 1, r = 2
		return Math.abs(
				points[0].getX()*points[1].getY() + 
				points[1].getX()*points[2].getY() +
				points[2].getX()*points[0].getY() -
				points[0].getY()*points[1].getX() -
				points[1].getY()*points[2].getX() -
				points[2].getY()*points[0].getX()
				) / 2.0;
	}
}
