package lab05;

import java.awt.Rectangle;

public class TextBoxes {
	private TextBox[] boxes;
	private int nextIndex;

	public TextBoxes(int n)
	{
		if (n > 0)
		{
			boxes = new TextBox[n];
		}
		else
		{
			throw new IllegalArgumentException("Parameter cannot be negative");
		}
	}

	public TextBoxes(TextBox[] boxes, int nextIndex)
	{
		if ((boxes == null && nextIndex != 0) || nextIndex < 0 || nextIndex > boxes.length)
		{
			throw new IllegalArgumentException("");
		}

		this.boxes = boxes;
		this.nextIndex = nextIndex;
	}

	public TextBoxes(TextBox[] boxes)
	{
		if (boxes != null)
		{
			this.boxes = boxes;
			nextIndex = this.boxes.length;
		}
	}

	public boolean addTextBox(TextBox box)
	{
		boolean status = false;
		if (boxes.length != nextIndex)
		{
			boxes[nextIndex] = box;
			nextIndex++;
			status = true;
		}

		return status;
	}

	/**
	 * Loops through the boxes array and
	 * for each non-null element checks to see
	 * if it has the longest string. If so, it
	 * will set the {@longest} variable and the
	 * {@Rectangle} variables accordingly.
	 * When loop is finished:
	 * @return longestRect
	 */
	public Rectangle longestTextRectangle()
	{
		int longest = 0;
		Rectangle longestRect = null;

		if (boxes != null)
		{
			for (int i = 0; i < boxes.length; i++)
			{
				if (boxes[i] != null)
				{
					if (boxes[i].getText().length() > longest)
					{
						longest = boxes[i].getText().length();
						longestRect = boxes[i].getBox();
					}
				}
			}
		}

		return longestRect;
	}

	public String largestAreaText()
	{
		double area = 0;
		String text = null;

		if (boxes != null)
		{
			for (int i = 0; i < boxes.length; i++)
			{
				if (boxes[i] != null)
				{
					if (boxes[i].getArea() > area)
					{
						area = boxes[i].getArea();
						text = boxes[i].getText();
					}
				}
			}
		}

		return text;
	}
}
