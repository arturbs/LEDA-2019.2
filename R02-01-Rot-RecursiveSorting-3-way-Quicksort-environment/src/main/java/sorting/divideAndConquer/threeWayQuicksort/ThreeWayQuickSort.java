package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.QuickSort;
import util.Util;

import java.util.Arrays;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Util.swapValidation(array, leftIndex, rightIndex);
		if (leftIndex < rightIndex) {
			int pivoIndex[] = organizaEmTresPartes(array, leftIndex, rightIndex);


			sort(array, leftIndex, pivoIndex[0] - 1);
			sort(array, pivoIndex[1] + 1, rightIndex);
		}

	}

	private int[] organizaEmTresPartes(T[] array, int leftIndex, int rightIndex) {

		T pivo = array[leftIndex];
		int i = leftIndex;
		int k = rightIndex;

		for (int j = leftIndex + 1; j <= k; j++) {
			if (array[j].compareTo(pivo) < 0) {
				i++;
				Util.swap(array, i, j);
			}

			if (array[j].compareTo(pivo) == 0) {
				Util.swap(array, k, j);
				k--;
				j--;
			}
		}
		Util.swap(array, i, leftIndex);
		int b = i;

		while (k < rightIndex) {
			b++;
			k++;
			Util.swap(array, b, k );
		}
		int[] a = new  int[] {i,b};
		return a;
	}


	public static void main(String[] args) {
		Integer[] intArray = new Integer[] { 5, 7, 5, 3, 1, 5, 9, 6 };
		Integer[] intArray2 = new Integer[] { 9, 8, 3, 1, 0, 7, 9, 9, 2, 13, 98, 75, 9, 49, 72, 111, 19, 18, 22, 55};

		ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();

		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));

		threeWayQuickSort.sort(intArray, 0, intArray.length -1);
		System.out.println(Arrays.toString(intArray));

		threeWayQuickSort.sort(intArray2, 0, intArray2.length -1);
		System.out.println(Arrays.toString(intArray2));

	}

}
