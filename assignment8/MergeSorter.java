package assignment08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class sorts an array, using the merge sort algorithm.
 * Copied but modified from Horstmann
 */
public class MergeSorter implements Sorter {

	public <E extends Comparable<? super E>> double timedSort(List<E> list) {
		long start = System.currentTimeMillis();
		sort(list);
		long end = System.currentTimeMillis();
		return end - start;
	}

	@SuppressWarnings("unchecked")
	public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
		List<E> retVal = list;
		if (list != null && list.size() > 1) {
			Object[] array = list.toArray();
			mergeSort(array);
			list.clear();
			for(Object obj : array) list.add((E)obj);
		}
		return retVal;
	}

	/**
	 * Sorts the array using merge sort.
	 * @param array array to be sorted
	 */
	@SuppressWarnings("unchecked")
	public static void mergeSort(Object[] array) {
		if (array.length > 1) {
			Object[] first = new Object[array.length/ 2];
			Object[] second = new Object[array.length - first.length];
			System.arraycopy(array, 0, first, 0, first.length);
			System.arraycopy(array, first.length, second, 0, second.length);
			mergeSort(first);
			mergeSort(second);
			//merge back into array;
			int iFirst = 0;
			int iSecond = 0;
			int j = 0;
			while (iFirst < first.length && iSecond < second.length) {             	
				if (((Comparable<Object>)first[iFirst]).compareTo(second[iSecond]) < 0) { 
					array[j] = first[iFirst];
					iFirst++;
				} else { 
					array[j] = second[iSecond];
					iSecond++;
				}
				j++;
			}
			System.arraycopy(first, iFirst, array, j, first.length - iFirst);
			System.arraycopy(second, iSecond, array, j, second.length - iSecond);           
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> lst = new ArrayList<Integer>();

		System.out.println("Mergesort using array");
		for(int i = 0; i < 100; i++)
			lst.add(r.nextInt(1000));
		System.out.println(lst);
		System.out.println(sort(lst));
	}

}