package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      Util.swapValidation(array, leftIndex, rightIndex);
      for (int i = leftIndex; i <= rightIndex; i++) {
         for (int j = leftIndex; j < rightIndex - i; j++) {
            //				System.out.println(Arrays.toString(array)); // Apenas para vizualização do processo
            if (array[j].compareTo(array[j + 1]) > 0) {
               Util.swap(array, j, j + 1);
            }
         }
      }
   }
}