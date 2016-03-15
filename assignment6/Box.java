package assignment06;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Box
{
	private Color color;
	private Rectangle2D.Double box;
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Rectangle2D.Double getBox()
	{
		return box;
	}
	
	public void setBox(Rectangle2D.Double box)
	{
		this.box = box;
	}
	
	public String toString()
	{
		return "" + color + " " + box;
	}
}
