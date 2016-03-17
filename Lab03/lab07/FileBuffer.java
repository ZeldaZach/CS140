package lab07;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;

public class FileBuffer extends Buffer
{
	private String fileName;

	public FileBuffer(String fn)
	{
		fileName = fn;
		try
		{
			lines = Files.readAllLines(Paths.get(fileName));
		}
		catch (Exception e)
		{
			lines = new ArrayList<>();
		}
	}

	@Override
	public void save()
	{
		try
		{
			Files.write(Paths.get(fileName), lines);
		}
		catch (IOException e)
		{
			System.out.println("Write invalid");
		}
	}

}
