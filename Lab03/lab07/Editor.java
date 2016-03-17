package lab07;

public class Editor
{
	private Buffer buff;
	private StatusBar bar;

	public Editor(Buffer b)
	{
		buff = b;
		bar = new StatusBar(b);
	}

	public void draw()
	{
		buff.draw();
		bar.draw();
	}

	public void save()
	{
		buff.save();
	}
	
	public void type(String t)
	{
		buff.type(t);
	}
}
