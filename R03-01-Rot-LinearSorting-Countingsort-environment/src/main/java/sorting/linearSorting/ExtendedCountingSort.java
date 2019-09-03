package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      if (Util.swapValidation(array, leftIndex, rightIndex) == true) {
         int maior = array[leftIndex];
         int menor = array[leftIndex];

         //Achando o maior e o menor valor no array;
         for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i].compareTo(menor) < 0) {
               menor = array[i];
            }
            if (array[i].compareTo(maior) > 0) {
               maior = array[i];
            }

         }

         //Calculando a diferenca do maior valor para o menor valor encontrado do array passado.
         int diferencaTamanho = maior - menor;

         //Criando um vetor auxiliar com tamanho do menor valor encontrado no array ate o de valor maior;
         int[] temporarryArray = new int[diferencaTamanho + 1];

         // contando quantas vezes cada valor se repete.
         for (int i = leftIndex; i <= rightIndex; i++) {
            temporarryArray[array[i] - menor] += 1;
         }

         //Fazendo o somatorio dos prefixos;
         for (int i = 1; i <= temporarryArray.length - 1; i++) {
            temporarryArray[i] += temporarryArray[i - 1];
         }

         //Criando o array auxiliar de resposta;
         int[] arrayAnswer = new int[array.length];

         //Colocando os numeros ordenadamente no arrayAnswer.
         for (int i = rightIndex; i >= leftIndex; i--) {
            temporarryArray[array[i] - menor]--;
            arrayAnswer[temporarryArray[array[i] - menor]] = array[i];
         }

         //Passando o array auxiliar de resposta para o array original.
         for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] = arrayAnswer[i];
         }
         //		System.out.println(temporarryArray.length);
      }
   }

   public static void main(String[] args) {
      Integer[] array = { 4, 5, -2, 4, 5, 5, 4, 3, 7, 7, 8, 7, 8, 0, -4 };
      ExtendedCountingSort extendedCountingSort = new ExtendedCountingSort();

      extendedCountingSort.sort(array, 0, array.length - 1);
      System.out.println(Arrays.toString(array));
   }

}
