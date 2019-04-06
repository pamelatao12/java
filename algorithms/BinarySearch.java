package algorithms;

public class BinarySearch {

	/**
	 * Implements binary search iteratively
	 * 
	 * @param array   is the sorted array in which to look for n
	 * @param element is the element to search for in the array
	 * @return the index of the position of n in the array
	 */
	public int binarySearch(int array[], int element) {
		int leftIndex = 0;
		int rightIndex = array.length - 1;

		while (leftIndex <= rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			// check if element is present at middleIndex
			if (array[middleIndex] == element) {
				return middleIndex;
			}
			// if element less than array[middleIndex], then rightIndex = middle - 1
			if (array[middleIndex] > element) {
				rightIndex = middleIndex - 1;
			} else if (array[middleIndex] < element) {
				leftIndex = middleIndex + 1;
			}
		}
		return -1;
	}

	/**
	 * Implements binary search recursively
	 * 
	 * @param array      is the sorted array in which to look for n
	 * @param element    is the element to search for in the array
	 * @param leftIndex  is the leftmost index of the array
	 * @param rightIndex is the rightmost index of the array
	 */
	public int binarySearchRecursive(int array[], int element, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			if (array[middleIndex] == element) {
				return middleIndex;
			}
			if (array[middleIndex] > element) {
				return binarySearchRecursive(array, element, leftIndex, middleIndex - 1);
			} 
			if (array[middleIndex] < element) {
				return binarySearchRecursive(array, element, middleIndex + 1, rightIndex);
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		BinarySearch example = new BinarySearch();
		int[] array = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println(example.binarySearch(array, 2));
	}
}
