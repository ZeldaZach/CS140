package lab03;

public class Arrays
{
	public static void main(String[] args)
	{
		String[] arr = {"abc", null, "def", null, "hij"};
		printAllStrings(arr);
		printStringLengths(arr);
	
		for (String element : args)
		{
			printAllStrings(element);
			printStringLengths(element);
		}
		
		System.out.println("------");
		try
		{
			System.out.println(arr[arr.length]);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			System.out.println(arr[2].charAt(arr[2].length()));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public static void printAllStrings(String... cases)
	{
		for (String element : cases)
		{	
			try
			{	
				System.out.println(element);
			}
			catch (Exception e)
			{
			
			}
		}
	}

	public static void printStringLengths(String... str)
	{
		for (String element : str)
		{
			try
			{
				int str_len = element.length();
				System.out.println(str_len);
			}
			catch (Exception e)
			{
		
			}
		}
	}
}