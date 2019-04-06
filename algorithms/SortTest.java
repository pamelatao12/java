package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortTest {

	@Test
	void testQuickSort() {
		Integer[] array = new Integer[] { 3, 1, 4, 2, 7 };
		Sort.quickSort(array);
		assertEquals("[1, 2, 3, 4, 7]", Arrays.toString(array));

		Integer[] array2 = new Integer[] { 3, 2, 8, 7, 4 };
		Sort.quickSort(array2);
		assertEquals("[2, 3, 4, 7, 8]", Arrays.toString(array2));

		Integer[] array3 = new Integer[] { 5, 3, 1, 1, 6, 2, 10 };
		Sort.quickSort(array3);
		assertEquals("[1, 1, 2, 3, 5, 6, 10]", Arrays.toString(array3));

		Integer[] array4 = new Integer[] { 5 };
		Sort.quickSort(array4);
		assertEquals("[5]", Arrays.toString(array4));

		Integer[] array5 = new Integer[] { 5, 1 };
		Sort.quickSort(array5);
		assertEquals("[1, 5]", Arrays.toString(array5));

		Integer[] array6 = new Integer[] { 5, 1, 10, 4, 2, 8 };
		Sort.quickSort(array6);
		assertEquals("[1, 2, 4, 5, 8, 10]", Arrays.toString(array6));

	}

	@Test
	void testMergeSort() {
		Integer[] array = new Integer[] { 3, 1, 4, 2, 7 };
		Sort.mergeSort(array);
		assertEquals("[1, 2, 3, 4, 7]", Arrays.toString(array));

		Integer[] array2 = new Integer[] { 3, 2, 8, 7, 4 };
		Sort.mergeSort(array2);
		assertEquals("[2, 3, 4, 7, 8]", Arrays.toString(array2));

		Integer[] array3 = new Integer[] { 5, 3, 1, 1, 6, 2, 10 };
		Sort.mergeSort(array3);
		assertEquals("[1, 1, 2, 3, 5, 6, 10]", Arrays.toString(array3));
	}
}
