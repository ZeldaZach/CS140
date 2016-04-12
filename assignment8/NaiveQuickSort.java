package assignment08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NaiveQuickSort implements Sorter {

	/**
	 * Return a list of all the elements that are less than list.get(0)
	 * according to the compareTo of E, i.e. all elements e in list such
	 * that e.compareTo(get(0)) < 0.
	 * @param list the input list from which the elements that are less than are taken
	 * @return a list of all the elements that are less than list.get(0)
	 * according to the compareTo of E 
	 */
	private static <E extends Comparable<? super E>> List<E> less(List<E> list)
	{
		List<E> tmp = new ArrayList<>();

		for (int i = 1; i < list.size(); i++)
		{
			if (list.get(i).compareTo(list.get(0)) < 0)
			{
				tmp.add(list.get(i));
			}
		}

		return tmp;
	}

	/**
	 * Return a list of all the elements that are greater than or equal to list.get(0)
	 * according to the compareTo of E, i.e. all elements e in list such
	 * that e.compareTo(get(0)) >= 0. 
	 * @param list the input list from which the elements that are not less than are taken
	 * @return a list of all the elements that are greater than or equal to list.get(0)
	 * according to the compareTo of E 
	 */
	private static <E extends Comparable<? super E>> List<E> gteq(List<E> list)
	{
		List<E> tmp = new ArrayList<>();

		for (int i = 1; i < list.size(); i++)
		{
			if (list.get(i).compareTo(list.get(0)) >= 0)
			{
				tmp.add(list.get(i));
			}
		}

		return tmp;
	}

	/**
	 * Returns true or false according as the list is already sorted according to the
	 * compareTo of E.
	 * @param list a list to be checked for sorted order
	 * @return true if the list is already sorted, otherwise false
	 */
	private static <E extends Comparable<? super E>> boolean inOrder(List<E> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			for (int j = i+1; j < list.size(); j++)
			{
				if (list.get(i).compareTo(list.get(j)) > 0)
				{
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Return a sorted copy of the input list, using the compareTo of E
	 * to determine the order of the elements
	 * @param list the input list
	 * @return the same list elements in sorted order
	 */

	public static <E extends Comparable<? super E>> List<E> sort(List<E> list)
	{
		List<E> tmp = new ArrayList<>();
		List<E> tmp_low = new ArrayList<>(less(list));
		List<E> tmp_high = new ArrayList<>(gteq(list));

		if (tmp_low.size() > 0)
		{
			tmp_low = sort(tmp_low);
			tmp.addAll(tmp_low);
		}

		tmp.add(list.get(0));

		if (tmp_high.size() > 0)
		{
			tmp_high = sort(tmp_high);
			tmp.addAll(tmp_high);
		}

		if (inOrder(tmp))
		{
			return tmp;
		}
		else
		{
			System.out.println(tmp);
			return sort(tmp);
		}	
	}

	@Override
	public <E extends Comparable<? super E>> double timedSort(List<E> list)
	{
		long start = System.currentTimeMillis();
		list = sort(list);
		long end = System.currentTimeMillis();
		return end - start;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> lst = new ArrayList<Integer>();

		for(int i = 0; i < 1000; i++)
			lst.add(r.nextInt(1000));
		System.out.println(lst);
		System.out.println(sort(lst));

		for(int i = 0; i < 10000; i++)
			lst.add(r.nextInt(10000));
		System.out.println(lst);
		System.out.println(sort(lst));
	}
}