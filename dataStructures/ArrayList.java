package dataStructures;

public final class ArrayList<E> {
	private E[] myArray;
	private int size;

	/**
	 * Creates an ArrayList with default size
	 */
	public ArrayList() {
		this(10);
	}

	/**
	 * Creates an ArrayList with specified length
	 * 
	 * @param length is the length of the list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity) {
		myArray = (E[]) new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Removes all elements in the arraylist
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * 
	 * @param index is the specified location where you want to get the element
	 * @return the element at the specified location
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E get(int index) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}

		return myArray[index];
	}

	/**
	 * Adds the specified element to the end of the list
	 * 
	 * @param e is the element to add to the end of the list
	 */
	@SuppressWarnings("unchecked")
	public void add(E e) {
		if (size + 1 == myArray.length) {
			E[] temp = (E[]) new Object[myArray.length * 2];
			for (int i = 0; i < size; i++) {
				temp[i] = myArray[i];
			}
			myArray = temp;
		}
		myArray[size++] = e;
	}

	/**
	 * Removes the specified element from the list, shifts all subsequent elements
	 * to the left
	 * 
	 * @param e is the element to remove from the list
	 */
	public void remove(E e) {
		int index = indexOf(e);
		if (index == -1) {
			return;
		}

		for (int j = index; j < size - 1; j++) {
			set(j, myArray[j + 1]);
		}
		if (index == size - 1) {
			set(index, null);
		}
		size--;
	}

	/**
	 * 
	 * @param e is the element to look for in the list
	 * @return true if the list contains the element, false if it does not
	 */
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}

	/**
	 * 
	 * @param e is the element to find the location of in the list
	 * @return the location of the specified element in the list, returns -1 if
	 *         element is not in the list
	 */
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (myArray[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @return true if the list is empty, false if not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @param index is the specific location to replace the element
	 * @param e     is the specific element to replace the element at the specified
	 *              location
	 * @throws IndexOutOfBoundsException if index < 0 or index > size
	 */
	public void set(int index, E e) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}

		myArray[index] = e;
	}

	/**
	 * 
	 * @return size of the list
	 */
	public int size() {
		return size;
	}

	private boolean isOutOfBounds(int index) {
		return index < 0 || index >= size;
	}

}
