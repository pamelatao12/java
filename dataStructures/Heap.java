package dataStructures;

public final class Heap<E extends Comparable<E>> {
	@SuppressWarnings("unchecked")
	private E[] array = (E[]) new Comparable[50];
	private int size;

	/**
	 * Constructs an empty Heap
	 */
	public Heap() {
		size = 0;
	}

	/**
	 * Returns the heap as a string of the underlying array
	 */
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		String heapString = "[";
		for (int i = 0; i < size - 1; i++) {
			heapString += array[i] + ", ";
		}
		return heapString += array[size - 1] + "]";
	}

	/**
	 * Adds a new element to the heap
	 * 
	 * @param element to be added to the heap
	 */
	@SuppressWarnings("unchecked")
	public void add(E element) {
		if (size + 1 == array.length) {
			E[] temp = (E[]) new Object[array.length * 2];
			for (int i = 0; i < size; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[size] = element;
		size++;
		bubbleUp(size - 1);
	}

	/**
	 * Moves element up the heap until it is less than the root and greater than
	 * children
	 * 
	 * @param element
	 */
	private void bubbleUp(int k) {
		int parent = (k - 1) / 2;
		while (k > 0 && array[k].compareTo(array[parent]) > 0) {
			swap(k, parent);
			k = parent;
			parent = (k - 1) / 2;
		}
	}

	/**
	 * Moves element up the heap until it is less than the root and greater than
	 * children Recursive function of bubbleUp(int k)
	 * 
	 * @param element
	 */
//	private void bubbleUpRecursive(int k) {
//		int parent = (k - 1) / 2;
//		while (k > 0 && array[k].compareTo(array[parent]) > 0) {
//			swap(k, parent);
//			bubbleUpRecursive(parent);
//		}
//	}

	/**
	 * Swaps the value of array at index1 with value at index2
	 * 
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2) {
		E temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Deletes the max element and returns it
	 * 
	 * @return the max element in the heap
	 */
	public E poll() {
		if (size == 0) {
			return null;
		}
		E maxElement = array[0];
		array[0] = array[size - 1];
		bubbleDown(0);
		size--;
		return maxElement;
	}

	/**
	 * Moves the element at array[k] to its appropriate position in the list by
	 * swapping places with the bigger child of its children
	 * 
	 * @param k is the location of the element to move to the end of the list in the
	 *          array
	 */
	private void bubbleDown(int k) {
		int bigChild = maximum(k);
		while (bigChild != -1 && array[k].compareTo(array[bigChild]) < 0) {
			swap(k, bigChild);
			k = bigChild;
			bigChild = maximum(k);
		}
	}

	/**
	 * Returns the index of the bigger child of k
	 *
	 * @param child1
	 * @param child2
	 * @return
	 */
	private int maximum(int k) {
		int child1 = 2 * k + 1;
		int child2 = 2 * k + 2;
		if (child1 >= size && child2 >= size) {
			return -1;
		} else if (array[child1].compareTo(array[child2]) < 0) {
			return child2;
		} else {
			return child1;
		}
	}

	/**
	 * Returns the max element
	 * 
	 * @return the max element
	 */
	public E peek() {
		return array[0];
	}

	/**
	 * Returns true if this heap contains the specified element
	 * 
	 * @param element to look for in the heap
	 * @return true if this heap contains the specified element
	 */
	public boolean contains(E element) {
		for (int i = 0; i < size; i++) {
			if (array[i] == element) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the specified element from the heap Returns true if the heap contains
	 * the specified element, false if not
	 * 
	 * @return true if the heap contains the specified element, false if not
	 */
	public boolean remove(E element) {
		for (int i = 0; i < size; i++) {
			if (array[i] == element) {
				array[i] = array[size - 1];
				bubbleDown(i);
				size--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the size of the heap
	 */
	public int size() {
		return size;
	}
}
