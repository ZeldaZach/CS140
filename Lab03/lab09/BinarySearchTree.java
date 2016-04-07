package lab09;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree<T>
{
	private T item;
	private BinarySearchTree<T> left, right; 
	private Comparator<T> compare;
	
	public BinarySearchTree(Comparator<T> c)
	{
		this.compare = c;
	}
	
	public void insert(T i)
	{
		if (item == null)
		{
			//System.out.println("item was null, item now is " + i);
			item = i;
			return;
		}

		int theCompare = compare.compare(i, item);
		
		if (theCompare < 0)
		{
			if (left == null)
			{
				//System.out.println("creating new sub tree");
				left = new BinarySearchTree<T>(compare);
			}
				
			//System.out.println("inserting " + i + " to left tree");
			left.insert(i);
		}
		else if (theCompare > 0)
		{
			if (right == null)
			{
				//System.out.println("creating new sub tree");
				right = new BinarySearchTree<T>(compare);
			}
			
			//System.out.println("inserting " + i + " to right tree");
			right.insert(i);
		}
		else
		{
			return;
		}
	}
	
	public T find(T i)
	{
		if (item == null)
			return null;

		int theCompare = compare.compare(i, item);
		if (theCompare < 0)
		{
			if (left != null)
				return left.find(i);
			else
				return null;
		}
		else if (theCompare > 0)
		{
			
			if (right != null)
				return right.find(i);
			else
				return null;
		}
		else
		{
			return i;
		}
	}
	
	public ArrayList<T> getElems()
	{
		ArrayList<T> items = new ArrayList<>();
		
		items.add(item);
		
		if (left != null)
			items.addAll(left.getElems());
		
		if (right != null)
			items.addAll(right.getElems());
		
		return items;
	}
}
