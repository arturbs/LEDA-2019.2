package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		int menor = array[leftIndex];
		for ( int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
			if (array[i].compareTo(maior) > 0) {
				maior = array[i];
			}

		}

		int diferencaTamanho = maior - menor;
	}

}
