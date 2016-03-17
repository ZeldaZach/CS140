package lab07;

import java.util.List;

public class Buffer
{
	protected List<String> lines;

	public int getNumlines()
	{
		return lines.size();
	}

	public String getText()
	{
		return String.join("\n", this.lines);
	}

	public void draw()
	{
		System.out.println(this.getText());
	}

	public void save()
	{
		throw new UnsupportedOperationException();
	}

	public void type(String toType)
	{
		for (int i = 0; i < toType.length(); i++)
		{
			if (toType.charAt(i) ==  '\n')
			{
				lines.add("");
			}
			else
			{
				lines.add(Character.toString(toType.charAt(i)));
			}
		}
	}
}
