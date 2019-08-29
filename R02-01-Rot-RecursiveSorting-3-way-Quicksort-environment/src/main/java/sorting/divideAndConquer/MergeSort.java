package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    int middleIndex = (leftIndex + rightIndex) / 2;
		if (array.length > 1) {
		    sort(array, leftIndex, middleIndex);
		    sort(array, middleIndex + 1, rightIndex);
        }
	
	}
}
