package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void testBinarySearch() {
		int[] array = new int[] {1, 2, 3, 4, 5, 6};
		BinarySearch n = new BinarySearch();
		assertEquals(0, n.binarySearch(array, 1));
		assertEquals(1, n.binarySearch(array, 2));
		assertEquals(2, n.binarySearch(array, 3));
		assertEquals(3, n.binarySearch(array, 4));
		assertEquals(4, n.binarySearch(array, 5));
		assertEquals(5, n.binarySearch(array, 6));
		
		int[] array2 = new int[] {1, 2, 3, 4, 5};
		BinarySearch n2 = new BinarySearch();
		assertEquals(0, n2.binarySearch(array2, 1));
		assertEquals(1, n2.binarySearch(array2, 2));
		assertEquals(2, n2.binarySearch(array2, 3));
		assertEquals(3, n2.binarySearch(array2, 4));
		assertEquals(4, n2.binarySearch(array2, 5));
	}
	
	@Test
	void testBinarySearchRecursive() {
		int[] array = new int[] {1, 2, 3, 4, 5, 6};
		BinarySearch n = new BinarySearch();
		assertEquals(0, n.binarySearchRecursive(array, 1, 0, array.length - 1));
		assertEquals(1, n.binarySearchRecursive(array, 2, 0, array.length - 1));
		assertEquals(2, n.binarySearchRecursive(array, 3, 0, array.length - 1));
		assertEquals(3, n.binarySearchRecursive(array, 4, 0, array.length - 1));
		assertEquals(4, n.binarySearchRecursive(array, 5, 0, array.length - 1));
		assertEquals(5, n.binarySearchRecursive(array, 6, 0, array.length - 1));
		
		int[] array2 = new int[] {1, 2, 3, 4, 5};
		BinarySearch n2 = new BinarySearch();
		assertEquals(0, n2.binarySearchRecursive(array2, 1, 0, array.length - 1));
		assertEquals(1, n2.binarySearchRecursive(array2, 2, 0, array.length - 1));
		assertEquals(2, n2.binarySearchRecursive(array2, 3, 0, array.length - 1));
		assertEquals(3, n2.binarySearchRecursive(array2, 4, 0, array.length - 1));
		assertEquals(4, n2.binarySearchRecursive(array2, 5, 0, array.length - 1));
	}

}
