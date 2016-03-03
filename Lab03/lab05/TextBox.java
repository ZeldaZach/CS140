package lab05;

import java.awt.Rectangle;

public class TextBox
{
	private String text;
	private Rectangle box;
	
	public TextBox(String text, Rectangle box)
	{
		this.text = text;
		this.box = box;
	}

	public double getWidth()
	{
		return box.getWidth();
	}

	public double getHeight()
	{
		return box.getHeight();
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Rectangle getBox()
	{
		return box;
	}

	public void setBox(Rectangle box)
	{
		this.box = box;
	}
	
	public double getArea()
	{
		return box.width * box.height;
	}
	
}
