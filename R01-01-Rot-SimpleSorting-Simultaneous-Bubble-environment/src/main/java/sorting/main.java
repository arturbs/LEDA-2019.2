package sorting;

import sorting.simpleSorting.BubbleSort;
import sorting.variationsOfBubblesort.SimultaneousBubblesort;

import java.util.Arrays;

public class main {

   public static void main(String[] args) {

      // BubbleSort

      BubbleSort bubbleSort = new BubbleSort();
      Integer[] intArray = new Integer[] { 6, 8, 3, 1, 0, 7, 9, 15, 2, 13, 98, 75, 35, 49, 72, 111, 19, 18, 22, 55 };

      //
      //        bubbleSort.sort(intArray, 0, intArray.length - 1);
      //        System.out.println("--------------");
      //        System.out.println(Arrays.toString(intArray));

      //        bubbleSort.sort(intArray, 1, intArray.length - 2);
      //        System.out.println("--------------");
      //        System.out.println(Arrays.toString(intArray));

      System.out.println("end bubble");

      // InsertionSort

      //
      //                SelectionSort selectionSort = new SelectionSort();
      //
      //                selectionSort.sort(intArray, 0, intArray.length - 1);
      //                System.out.println("--------------");
      //                System.out.println(Arrays.toString(intArray));

      //                selectionSort.sort(intArray, 1, 8);
      //                System.out.println("--------------");
      //                System.out.println(Arrays.toString(intArray));

      System.out.println("end selection");

      // InsertionSort

      //        InsertionSort insertionSort = new InsertionSort();
      //
      //        insertionSort.sort(intArray, 0, intArray.length - 1);
      //        System.out.println("----------------------");
      //        System.out.println(Arrays.toString(intArray));

      //        insertionSort.sort(intArray, 1, 8);
      //        System.out.println("----------------------");
      //        System.out.println(Arrays.toString(intArray));

      System.out.println("EndInsertion");

      // SimultaneusBubbleSort

      SimultaneousBubblesort simultaneousBubblesort = new SimultaneousBubblesort();

      simultaneousBubblesort.sort(intArray, 0, intArray.length - 1);
      System.out.println("----------------------");
      System.out.println(Arrays.toString(intArray));

      //        simultaneousBubblesort.sort(intArray, 1, 8);
      //        System.out.println("----------------------");
      //        System.out.println(Arrays.toString(intArray));

      System.out.println("EndsimultaneousBubble");

   }
}
