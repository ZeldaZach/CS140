package lab07;

public class Driver
{
	public static void main(String[] args)
	{
		Buffer buff;
		if (args.length > 0)
		{
			buff = new FileBuffer(args[0]);
		}
		else
		{
			buff = new ScratchBuffer();
		}
		
		Editor editor = new Editor(buff);
		
		editor.draw();
		editor.type("Hello world!");
		editor.draw();
		
		editor.type("What's up?");
		editor.draw();
		editor.save();
	}
}
