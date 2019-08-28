package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      Util.swapValidation(array, leftIndex, rightIndex);

      //		        System.out.println(leftIndex); // Apenas para vizualização do processo
      //		        System.out.println(rightIndex); // Apenas para vizualização do processo

      for (int i = leftIndex; i < rightIndex; i++) {
         int min = i;

         for (int j = i + 1; j <= rightIndex; j++) {
            if (array[min].compareTo(array[j]) > 0) {
               min = j;
            }
         }
         Util.swap(array, min, i);
         //			System.out.println(Arrays.toString(array)); // Apenas para vizualização do processo

      }
   }
}
