package exam01;

public class ArrayUtils
{
	public static int countMax(int[] array)
	{
		int max = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
			}
		}
		
		for (int j = 0; j < array.length; j++)
		{
			if (array[j] == max)
			{
				count++;
			}
		}
		return count;
	}

	public static int[] reverse(int[] array)
	{
		int[] tmp = new int[array.length];

		for (int i = 0; i < array.length; i++)
		{
			tmp[i] = array[array.length - i - 1];
			// If array.length = 4
			// tmp[0] = array[4], tmp[1] = array[3], tmp[2] = array[2], tmp[3] = array[1], tmp[4] = array[0]
		}
		return tmp;
	}

	public static int[] intersperse(int[] array, int n)
	{
		int[] tmp = new int[2*array.length - 1];
		// [1,2,3] == [1,n,2,n,3] 3 -> 5
		// [1,2,3,4] == [1,n,2,n,3,n,4] 4->7
		
		int actualInsertIndex = 0;
		for (int i = 0; i < array.length; i++)
		{
			tmp[actualInsertIndex] = array[i];
			actualInsertIndex++;
			
			if (i != array.length - 1)
			{
				tmp[actualInsertIndex] = n;
				actualInsertIndex++;
			}
			
		}
		return tmp;
	}
}
