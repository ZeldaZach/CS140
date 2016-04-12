package assignment08;

import java.util.ArrayList;

public class Question2
{
	public static int recursiveSum(ArrayList<Integer> list)
	{
		int tmp;
		
		if (list == null || list.isEmpty())
			return 0;
		
		tmp = list.get(0);
		list.remove(0);
		
		return tmp + recursiveSum(list);
	}
}
