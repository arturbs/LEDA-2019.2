package sorting.linearSorting;

import sorting.AbstractSorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
        int maior = array[leftIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i].compareTo(maior) > 0) {
                maior = array[i];
            }
        }

        Integer[] temporaryArray = new Integer[maior];


        for (int j = leftIndex; j <= rightIndex; j++) {
            temporaryArray[array[j] - 1] += 1;
        }

        for (int j = 1; j <= temporaryArray.length - 1; j++) {
            temporaryArray[j] += temporaryArray[j - 1];

        }

        System.out.println(Arrays.toString(temporaryArray));
	}

    public static void main(String[] args) {
        
    }

}


