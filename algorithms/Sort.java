package algorithms;

public final class Sort {

	/**
	 * Sorts an array of int inv: array[0.. i-1] is sorted
	 * @param <E>
	 * 
	 * @param array to be sorted 
	 */
	public static <E extends Comparable<E>> void insertionSort(E[] array) {
		for (int i = 0; i < array.length; i++) {
			int k = i;
			while (k > 0 && array[k].compareTo(array[k - 1]) < 0) {
				swap(array, k, k - 1);
				k--;
			}
		}
	}

	/**
	 * Sorts an array of int inv: array[0.. i-1] is sorted AND array[0.. i-1] <=
	 * array[i..]
	 * 
	 * @param array is to be sorted
	 */
	public static <E extends Comparable<E>> void selectionSort(E[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = minimum(array, i, array.length - 1);
			swap(array, i, min);
		}
	}

	/**
	 * Sorts an array of int
	 * 
	 * @param array
	 */
	public static <E extends Comparable<E>> void quickSort(E[] array) {
		quickSortHelper(array, 0, array.length - 1);
	}

	/**
	 * Sorts an array of int from startIndex to endIndex
	 * 
	 * @param array is the array to be sorted
	 */
	private static <E extends Comparable<E>> void quickSortHelper(E[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int pivot = partition(array, startIndex, endIndex);
		quickSortHelper(array, startIndex, pivot);
		quickSortHelper(array, pivot + 1, endIndex);
	}

	/**
	 * Moves all values < pivot to the left of pivot and all values > pivot to the
	 * right
	 * 
	 * @return the index of the pivot in the partitioned array
	 */
	private static <E extends Comparable<E>> int partition(E[] array, int startIndex, int endIndex) {
		int pivot = startIndex;
		int end = endIndex;
		while (pivot < end) {
			if (array[pivot + 1].compareTo(array[pivot]) < 0) {
				swap(array, pivot + 1, pivot);
				pivot++;
			} else {
				swap(array, end, pivot + 1);
				end--;
			}
		}
		return pivot;
	}

	public static <E extends Comparable<E>> void mergeSort(E[] array) {
		mergeSortHelper(array, 0, array.length - 1);
	}

	/**
	 * Sorts an array, that is a subsection of array, from startIndex to endIndex
	 * inclusive
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	private static <E extends Comparable<E>> void mergeSortHelper(E[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int mid = (startIndex + endIndex) / 2;

		mergeSortHelper(array, startIndex, mid);
		mergeSortHelper(array, mid + 1, endIndex);
		merge(array, startIndex, endIndex);
	}

	/**
	 * Merges two sorted halves of an array into one sorted array
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	@SuppressWarnings("unchecked")
	private static <E extends Comparable<E>> void merge(E[] array, int startIndex, int endIndex) {
//		int[] copy = new int[array.length];
//		int middle = (startIndex + endIndex) / 2;
//
//		int startA = startIndex; // Going from startA --> middle
//		int startB = middle; // Going from middle --> endIndex
//
//		int copyArrayIndex = startIndex;
//
//		while (startA < middle && startB < endIndex) {
//			if (array[startA] < array[startB]) {
//				copy[copyArrayIndex++] = array[startA++];
//			} else {
//				copy[copyArrayIndex++] = array[startB++];
//			}
//		}
//
//		while (startA < middle) {
//			copy[copyArrayIndex++] = array[startA++];
//		}
//
//		while (startB < endIndex) {
//			copy[copyArrayIndex++] = array[startB++];
//		}
//
//		for (int i = startIndex; i < endIndex; i++) {
//			array[i] = copy[i];
//		}

		
		int midIndex = (startIndex + endIndex) / 2;
		int startA = startIndex;
		int startB = midIndex + 1;

		E[] temp = (E[]) new Comparable[array.length];
		
		int tempIndex = startIndex;

		while (startA <= midIndex && startB <= endIndex) {
			if (array[startA].compareTo(array[startB]) < 0) {
				temp[tempIndex++] = array[startA++];
			} else {
				temp[tempIndex++] = array[startB++];
			}
		}

		while (startA <= midIndex) {
			temp[tempIndex++] = array[startA++];
		}

		while (startB <= endIndex) {
			temp[tempIndex++] = array[startB++];
		}

		for (int i = startIndex; i <= endIndex; i++) {
			array[i] = temp[i];
		}
	}

	/**
	 * Swaps two elements of an array
	 * 
	 * @param element1 is the first element to swap
	 * @param element2 is the second element to swap
	 */
	private static <E extends Comparable<E>> void swap(E[] array, int index1, int index2) {
		E temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Returns the index of the minimum value in a range in the array
	 */
	private static <E extends Comparable<E>> int minimum(E[] array, int startIndex, int endIndex) {
		int min = startIndex;
		for (int i = startIndex + 1; i <= endIndex; i++) {
			if (array[min].compareTo(array[i]) > 0) {
				min = i;
			}
		}
		return min;
	}
}
