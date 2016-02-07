package assignment02;

import java.util.Arrays;

public class InstanceMethodVersion
{
	private String str;
	public InstanceMethodVersion(String str)
	{
		this.str = str;
	}
	
	public int countSpaces()
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
	
	public String withoutExtraSpaces()
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
	
	public String first()
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
	
	public String rest()
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
	
	public String[] splitOnSpaces()
	{
		String[] returnVal = null;
		
		if (str != null)
		{
			String str_tmp = str;
			returnVal = new String[str.length()];
			int index = 0;
			
			while (str.length() > 0)
			{
				returnVal[index] = first();
				str = rest();
				index++;
			}
			
			returnVal = Arrays.copyOf(returnVal, index);
			str = str_tmp;
		}

		return returnVal;
	}
	
	public int[] strLengths()
	{
		int[] totals = null;
		String[] words = splitOnSpaces();
		
		if (str != null)
		{
			totals = new int[words.length];
			
			for (int i = 0; i < words.length; i++)
				if (words[i] != null)
					totals[i] = words[i].length();
		}
		
		return totals;
	}
}