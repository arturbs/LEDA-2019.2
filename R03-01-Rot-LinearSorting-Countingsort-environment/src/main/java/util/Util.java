package util;

/**
 * Class containing useful methods for arrays manipulation.
 */
public class Util {

	/**
	 * Swaps the contents of two positions in an array.
	 *
	 * @param array
	 *            The array to be modified, not null
	 * @param i
	 *            One of the target positions
	 * @param j
	 *            The other target position
	 */
	public static void swap(Object[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static boolean swapValidation(Object[] array, int leftIndex, int rigthIndex) {

	    boolean isValid = true;

        if (rigthIndex < leftIndex) {
            isValid = false;
    }
        if (rigthIndex > array.length - 1) {
            isValid = false;
        }

        if (leftIndex < 0 || rigthIndex < 0) {
            isValid = false;
        }

        if ( array == null || array.length == 0) {
            isValid = false;
        }

        return isValid;
	}

	/**
	 * It says if a specific number is prime or not.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n) {
		boolean result = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0){
				result = false;
				break;
			}
		}
		return result;
	}
}