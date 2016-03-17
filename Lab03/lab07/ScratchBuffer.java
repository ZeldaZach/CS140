package lab07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ScratchBuffer extends Buffer
{
	public ScratchBuffer()
	{
		lines = new ArrayList<>();
	}
	
	@Override
	public void save()
	{
		try
		{
			Files.write(Paths.get("scratch"), lines);
		}
		catch (IOException e)
		{
			System.out.println("Write invalid");
		}
	}}
