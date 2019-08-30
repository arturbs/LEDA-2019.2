package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivoIndex = organiza(array, leftIndex, rightIndex);

			sort( array, leftIndex, pivoIndex - 1);
			sort( array, pivoIndex + 1, rightIndex);

		}
	}

	public int organiza(T[] array, int leftIndex, int rigthIndex) {
//
//		T pivo = array[rigthIndex];
//		int i = leftIndex - 1;
//
//		for (int j = leftIndex; j <= rigthIndex - 1; j++) {
//			if (array[j].compareTo(pivo) < 0) {
//				i++;
//				Util.swap(array, i, j);
//			}
//		}
//		Util.swap(array, i + 1, rigthIndex);
//		return i + 1;

		T pivo = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rigthIndex; j++) {
			if (array[j].compareTo(pivo) < 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, i, leftIndex);
		return  i;
	}

	public static void main(String[] args) {
		Integer[] intArray = new Integer[] { 5, 7, 3, 4 , 9, 2 };
		Integer[] intArray2 = new Integer[] { 6, 8, 3, 1, 0, 7, 9, 15, 2, 13, 98, 75, 35, 49, 72, 111, 19, 18, 22, 55};

		QuickSort quickSort = new QuickSort();

		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));

		quickSort.sort(intArray, 0, intArray.length -1);
		System.out.println(Arrays.toString(intArray));

		quickSort.sort(intArray2, 0, intArray2.length -1);
		System.out.println(Arrays.toString(intArray2));

	}
}
