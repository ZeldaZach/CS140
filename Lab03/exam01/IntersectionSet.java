package exam01;

import java.util.ArrayList;

public class IntersectionSet
{
	private ArrayList<Integer> list = new ArrayList<>();
	
	public IntersectionSet(int[] aList)
	{
		for (int i = 0; i < aList.length; i++)
		{
			list.add(aList[i]);
		}
	}

	public int size()
	{
		int count = 0;
		for (Integer i : list)
		{
			count++;
		}
		return count;
	}

	public boolean contains(int n)
	{
		boolean retVal = false;
		for (int i = 0; i < this.size(); i++)
		{
			if (list.get(i) == n)
			{
				retVal = true;
				break;
			}
		}
		return retVal;
	}

	public ArrayList<Integer> getElements()
	{
		return list;
	}

	public void intersect(IntersectionSet other)
	{
		int[] tmp = new int[this.size()];
		for (int i = 0; i < this.size(); i++)
		{	
			tmp[i] = list.get(i); // Copy list to tmp array
		}

		for (int j = 0; j < tmp.length; j++)
		{
			if (!other.contains(tmp[j]))
			{
				this.list.remove(new Integer(tmp[j]));
			}
		}
	}

	public boolean wouldModify(IntersectionSet other)
	{
		boolean retVal = false;
		for (int j = 0; j < size(); j++)
		{
			if (!other.contains(list.get(j)))
			{
				retVal = true;
				break;
			}
		}
		return retVal;
	}
}
