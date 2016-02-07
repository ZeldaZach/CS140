package assignment02;

import java.util.Arrays;

public class Utilities02
{
	public static int countNulls(Object[] array)
	{
		int count = 0;
		if (array != null && array.length != 0)
			for (int i = 0; i < array.length; i++)
				if (array[i] == null)
					count++;
		
		return count;
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
	
	public static String[] splitOnSpaces(String str)
	{
		int len = countSpaces(withoutExtraSpaces(str));
		String[] returnVal = null;
		
		if (len >= 0)
		{
			returnVal = new String[len + 1];
			for (int i = 0; i <= len; i++)
			{
				returnVal[i] = first(str);
				str = rest(str);
			}
		}
		
		return returnVal;
	}
	
	public static int[] strLengths(String str)
	{
		int[] totals = null;
		String[] words = splitOnSpaces(str);
		
		if (str != null)
		{
			totals = new int[words.length];
			
			for (int i = 0; i < words.length; i++)
				if (words[i] != null)
					totals[i] = words[i].length();
		}
		
		return totals;
	}
	
	public static String[] splitOnSpaces1(String str)
	{
		String[] returnVal = null;
		
		if (str != null)
		{
			returnVal = new String[str.length()];
			int index = 0;
			
			while (str.length() > 0)
			{
				returnVal[index] = first(str);
				str = rest(str);
				index++;
			}
			
			returnVal = Arrays.copyOf(returnVal, index);
		}
		
		return returnVal;
	}
	
}