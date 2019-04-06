package dataStructures;

public final class PriorityQueue<E> {
	private Object[] array;
	private int size;

	public PriorityQueue() {
		this(50);
	}
	
	public PriorityQueue(int initialCapacity) {
		array = new Object[initialCapacity];
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
			heapString += getValue(i) + ", ";
		}
		return heapString += getValue(size - 1) + "]";
	}

	/**
	 * Adds a new element to the heap
	 * 
	 * @param element to be added to the heap
	 */
	public void add(E element, int priority) {
		ComparatorNode<E> priorityNode = new ComparatorNode<>(element, priority);
		if (size + 1 == array.length) {
			Object[] temp = new Object[array.length * 2];
			for (int i = 0; i < size; i++) {
				temp[i] = get(i);
			}
			array = temp;
		}
		array[size] = priorityNode;
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
		while (k > 0 && get(k).compareTo(get(parent)) > 0) {
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
		ComparatorNode<E> temp = get(index1);
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Deletes the max priority element and returns it
	 * 
	 * @return the max priority element in the heap
	 */
	public E poll() {
		if (size == 0) {
			return null;
		}
		E maxElement = (E) getValue(0);
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
		while (bigChild != -1 && get(k).compareTo(get(bigChild)) < 0) {
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
		} else if (get(child1).compareTo(get(child2)) < 0) {
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
		return getValue(0);
	}

	/**
	 * Returns true if this heap contains the specified element
	 * 
	 * @param element to look for in the heap
	 * @return true if this heap contains the specified element
	 */
	public boolean contains(E element) {
		for (int i = 0; i < size; i++) {
			if (getValue(i) == element) {
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
			if (getValue(i) == element) {
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
	
	/**
	 * Returns the element at the specified index of the array
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ComparatorNode<E> get(int index) {
		return (ComparatorNode<E>) array[index];
	}
	
	private E getValue(int index) {
		return get(index).value;
	}

//	/**
//	 * Inserts the specified element into this priority queue
//	 * 
//	 * @param element  to be inserted
//	 * @param priority
//	 */
//	@SuppressWarnings("unchecked")
//	public void add(E element, int priority) {
//		E priorityNode = (E) new ComparatorNode<>(element, priority);
//		priorityHeap.add(priorityNode);
//	}
//
//	/**
//	 * Removes all of the elements from this priority queue
//	 */
//	public void clear() {
//		size = 0;
//	}
//
//	/**
//	 * Retrieves, but does not remove, the head of this queue, or returns null if
//	 * this queue is empty.
//	 * 
//	 * @return the head of this queue
//	 */
//	public E peek() {
//		return priorityHeap.peek();
//	}
//
//	/**
//	 * Retrieves and removes the head of this queue, or returns null if this queue
//	 * is empty.
//	 * 
//	 * @return the head of this queue
//	 */
//	public E poll() {
//		return priorityHeap.poll();
//	}
//
//	/**
//	 * Returns the size of the queue
//	 * 
//	 * @return size of the queue
//	 */
//	public int size() {
//		return size;
//	}
//	
//	/**
//	 * Returns true if the queue contains the specified element, false if not
//	 * 
//	 * @return true if the queue contains the specified element, false if not
//	 */
//	public boolean contains(E element) {
//		return priorityHeap.contains(element);
//	}
//	
//	/**
//	 * Removes the specified element from the queue
//	 * Returns true if the queue contains the specified element, false if not
//	 * 
//	 * @return true if the queue contains the specified element, false if not
//	 */
//	public boolean remove(E element) {
//		return priorityHeap.remove(element);
//	}
//	
//	/**
//	 * Returns the queue as an array string
//	 */
//	public String toString() {
//		return priorityHeap.toString();
//	}
//	
//	/**
//	 * returns value of the element at index in the queue
//	 * @param index
//	 * @return
//	 */
//	public E getValue(int index) {
//		return priorityHeap.getValue(index);
//	}

	private class ComparatorNode<T> implements Comparable<ComparatorNode<T>> {
		T value;
		int priority;

		ComparatorNode(T val, int priority) {
			this.value = val;
			this.priority = priority;
		}

		@Override
		public int compareTo(ComparatorNode<T> o) {
			return o.priority - this.priority;
		}
	}
}
