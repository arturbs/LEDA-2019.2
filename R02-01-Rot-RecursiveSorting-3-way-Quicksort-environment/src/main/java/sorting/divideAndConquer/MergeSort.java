package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    Util.swapValidation(array, leftIndex, rightIndex);
	    if (leftIndex < rightIndex) {
	        int middleIndex = (leftIndex + (rightIndex - leftIndex) / 2);
            System.out.println(middleIndex);

            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);

        }
	}



	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

	    T[] copy = (T[]) new Comparable[rightIndex - leftIndex + 1];
	    for (int i = leftIndex; i <= rightIndex; i++) {
	        copy[i - leftIndex] = array[i];
        }

        System.out.println(Arrays.toString(copy));
        System.out.println(copy.length);

	    int middle = (copy.length - 1) / 2;

        int i = leftIndex;
	    int j = middleIndex + 1;
	    int k = leftIndex;

	    while ( i <= middleIndex && j <= rightIndex) {
	        if (copy[i - leftIndex].compareTo(copy[j- leftIndex]) < 0) {
	            array[k] = copy[i - leftIndex];
	            i++;
            } else {
	            array[k] = copy[j- leftIndex];
	            j++;
            }
	        k++;
            System.out.println(Arrays.toString(array));
        }

	    while (i<= middleIndex) {
	        array[k] = copy[i - leftIndex];
	        k++;
	        i++;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = new Integer[] { 7, 5, 18, 3, 9, 4, 2 };
        Integer[] intArray2 = new Integer[] { 6, 8, 3, 1, 0, 7, 9, 15, 2, 13, 98, 75, 35, 49, 72, 111, 19, 18, 22, 55};

        MergeSort mergeSort = new MergeSort();

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(intArray2));

        mergeSort.sort(intArray, 0, intArray.length -1);
        System.out.println(Arrays.toString(intArray));

        mergeSort.sort(intArray2, 0, intArray2.length -1);
        System.out.println(Arrays.toString(intArray2));
    }
}
