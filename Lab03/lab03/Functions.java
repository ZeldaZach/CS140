package lab03;

import java.util.ArrayList;

public class Functions
{
	public static ArrayList<String> splitOnSpaces(String str)
	{
		int len = countSpaces(withoutExtraSpaces(str));
		ArrayList<String> returnVal = new ArrayList<>();
		
		if (len >= 0)
		{
			for (int i = 0; i <= len; i++)
			{
				returnVal.add(first(str));
				str = rest(str);
			}
		}
		else
		{
			System.out.println(len);
		}
		
		return returnVal;
	}
	
	public static ArrayList<Integer> strLengths(String str)
	{
		ArrayList<Integer> totals = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>(splitOnSpaces(str));
		
		if (str != null)
		{
			for (int i = 0; i < words.size(); i++)
			{
				if (words.get(i) != null)
					totals.add(words.get(i).length());
			}
		}
		
		return totals;
	}
	
	public static int countSpaces(String str)
	{
		int count = -1;
		if (str != null)
		{
			count++; // Set count to 0 as it's not a null string
			for (int i = 0; i < str.length(); i++)
				if (str.charAt(i) == ' ')
					count++;
		}
	
		return count;
	}
	
	public static String withoutExtraSpaces(String str)
	{
		String returnVal = null;
	
		if (str != null)
		{
			returnVal = str.trim();
			int len1 = 0, len2 = 0;
		
			do
			{
				len1 = returnVal.length();
				returnVal = returnVal.replace("  ", " ");
				len2 = returnVal.length();
			}
			while (len2 < len1);
		}
	
		return returnVal;
	}
	
	public static String first(String str)
	{
		String returnVal = null;
		
		if (str != null)
		{
			returnVal = str.trim();
			int i = returnVal.indexOf(" ");
			if (i > 0)
				returnVal = returnVal.substring(0,i);
		}
		
		return returnVal;
	}
	
	public static String rest(String str)
	{
		String returnVal = null;
		
		if (str != null)
		{
			returnVal = str.trim();
			int i = returnVal.indexOf(" ");
			if (i >= 0)
				returnVal = returnVal.substring(i+1).trim();
			else
				returnVal = "";
		}
		
		return returnVal;
	}
}