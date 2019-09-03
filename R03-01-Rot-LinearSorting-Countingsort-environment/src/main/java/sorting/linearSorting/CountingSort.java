package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

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
      if (Util.swapValidation(array, leftIndex, rightIndex) == true) {
         int maior = array[leftIndex];

         //Achando o maior valor no array;
         for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i].compareTo(maior) > 0) {
               maior = array[i];
            }
         }
         //Criando um vetor auxiliar com tamanho de 0 ate o valor de maior;
         int[] temporaryArray = new int[maior + 1];

         // contando quantas vezes cada valor se repete.
         for (int j = leftIndex; j <= rightIndex; j++) {
            temporaryArray[array[j]] += 1;
         }

         //Fazendo o somatorio dos prefixos;
         for (int j = 1; j <= temporaryArray.length - 1; j++) {
            temporaryArray[j] += temporaryArray[j - 1];
         }

         //Criando o array auxiliar de resposta;
         int[] arrayAnswer = new int[array.length];

         //Colocando os numeros ordenadamente no arrayAnswer.
         for (int j = rightIndex; j >= leftIndex; j--) {
            temporaryArray[array[j]] -= 1;
            arrayAnswer[temporaryArray[array[j]]] = array[j];
         }

         //Passando o array auxiliar de resposta para o array original.
         for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] = arrayAnswer[i];
         }
      }
   }

   public static void main(String[] args) {
      Integer[] array = { 4, 5, 9, 4, 2, 4, 1, 1, 1, 5, 5, 4, 2, 4, 3, 7, 7, 8, 7, 8, 4, 3 };
      CountingSort countingSort = new CountingSort();

      countingSort.sort(array, 0, array.length - 1);
      System.out.println(Arrays.toString(array));
   }

}
