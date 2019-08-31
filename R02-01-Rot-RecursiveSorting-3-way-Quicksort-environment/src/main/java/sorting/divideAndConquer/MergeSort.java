package sorting.divideAndConquer;

import sorting.AbstractSorting;

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
	    if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;



            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, rightIndex);

        }
	}

    private void merge(T[] array, int leftIndex, int rightIndex) {

        int middleIndex = (leftIndex + rightIndex) / 2;
        int halfSize = rightIndex - leftIndex + 1;

        T[] leftCopy = (T[]) new Comparable[halfSize];
        T[] rigthCopy = (T[]) new Comparable[halfSize];


        for (int c = leftIndex; c <= middleIndex; c++) {
            leftCopy[c - leftIndex] = array[c];
            System.out.println(Arrays.toString(leftCopy));
        }
        for (int c = middleIndex + 1; c <= rightIndex; c++) {
            rigthCopy[c - (middleIndex + 1)] = array[c];
        }
        int i = 0, j = 0, k = 0;
        while ((i <= leftCopy.length - 2) && (j <= rigthCopy.length - 2)) {
            System.out.println(leftCopy.length);
            System.out.println(rigthCopy.length);

            if (leftCopy[i].compareTo(rigthCopy[j]) < 0){
                array[k] = leftCopy[i];
                i++;
            } else {
                array[k] = rigthCopy[j];
                j++;
            }
            k++;
        }

        while (j <= rigthCopy.length - 1) {
            array[k] = rigthCopy[j];
            j++;
            k++;
        }

        while (i <= leftCopy.length - 1) {
            array[k] = leftCopy[i];
            i++;
            k++;
        }

    }

    public static void main(String[] args) {
        Integer[] intArray = new Integer[] { 5, 7, 3, 4 , 9, 2 };
        Integer[] intArray2 = new Integer[] { 6, 8, 3, 1, 0, 7, 9, 15, 2, 13, 98, 75, 35, 49, 72, 111, 19, 18, 22, 55};

        MergeSort mergeSort = new MergeSort();

        System.out.println(Arrays.toString(intArray));
//        System.out.println(Arrays.toString(intArray2));

        mergeSort.sort(intArray, 0, intArray.length -1);
        System.out.println(Arrays.toString(intArray));

//        mergeSort.sort(intArray2, 0, intArray2.length -1);
//        System.out.println(Arrays.toString(intArray2));

    }
}
