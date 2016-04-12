package assignment08;

import java.util.List;

public class ABubbleSortUtility implements Sorter {

	public <E extends Comparable<? super E>> double timedSort(List<E> list) {
        long start = System.currentTimeMillis();
		boolean changeOccured = true;
		while (changeOccured) {
			changeOccured = false;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i-1).compareTo(list.get(i)) > 0) {
					E temp = list.get(i);
					list.set(i, list.get(i-1));
					list.set(i-1, temp);
					changeOccured = true;
				}
			}
		}
        long end = System.currentTimeMillis();
        return end - start;
	}
	
}