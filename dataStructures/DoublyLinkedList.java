package dataStructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	/**
	 * Creates an empty list with size 0
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 * 
	 * @param n is the element to be appended to this list
	 */
	public void add(E element) {
		Node<E> newNode = new Node<E>(element);
		switch (size) {
		case 0:
			head = newNode;
			break;
		case 1:
			head.next = newNode;
			newNode.previous = head;
			break;
		default:
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		size++;
	}

	/**
	 * Inserts the specified element at the specified position in this list
	 * 
	 * @param index is the index at which the specified element is to be inserted
	 * @param n     is the element to be inserted
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void add(int index, E element) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> newNode = new Node<>(element);
		Node<E> current = head;
		if (index == 0) {
			newNode.next = current;
			current.previous = newNode;
			head = newNode;
		} else {
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next.previous = newNode;
			current.next = newNode;
			newNode.previous = current;
		}
		size++;
	}

	/**
	 * Removes all of the elements from this list
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * @param n is the element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(E element) {
		return indexOf(element) != -1;
	}

	/**
	 * 
	 * @param index is the specified location to get the element
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E get(int index) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.value;
	}
	
	/**
	 * 
	 * @return the value of the head of the list
	 */
	public E getHead() {
		return head.value;
	}
	
	/**
	 * 
	 * @return the value of the tail of the list
	 */
	public E getTail() {
		return tail.value;
	}

	/**
	 * 
	 * @param n is the element to look for its position in this list
	 * @return the index of the first occurrence of the specified element in this
	 *         list, -1 if list does not contain the element
	 */
	public int indexOf(E element) {
		Node<E> newNode = new Node<>(element);
		Node<E> current = head;
		for (int i = -1; i < size - 1; i++) {
			if (current.value.equals(newNode.value)) {
				return i + 1;
			}
			current = current.next;
		}
		return -1;
	}

	/**
	 * Returns true if list is empty, false if not
	 * 
	 * @return true if list is empty, false if not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return the first element (head) of this list
	 */
	public E peek() {
		return head.value;
	}

	/**
	 * Removes the element at the specified position in this list
	 * 
	 * @param index is the specific position in this list at which to remove the
	 *              element
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E remove(int index) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> current = head;
		if (size == 1) {
			head = null;
			tail = null;
		} else if (index == 0) {
			head = head.next;
			head.previous = null;
		} else {
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			if (current == tail) {
				tail = current.previous;
				current.previous.next = null;
			} else {
			current.next.previous = current.previous;
			current.previous.next = current.next;
			}
		}
		size--;
		return current.value;
	}
	
	/**
	 * Retrieves and removes the first element of the list
	 * @return the first element of the list
	 */
	public E removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return remove(0);
	}
	
	/**
	 * Retrieves and removes the last element of the list
	 * @return the last element of the list
	 */
	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return remove(indexOf(tail.value));
	}

	/**
	 * Removes the specified element from the list
	 * 
	 * @param n is the element to remove from the list
	 */
	public void remove(E element) {
		int index = indexOf(element);
		remove(index);
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element
	 * 
	 * @param index is the specified location of the element to replace
	 * @param n     is the specified element to be stored at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void set(int index, E element) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> current = head;
		while (index != indexOf(current.value)) {
			current = current.next;
		}
		current.value = element;
	}

	/**
	 * Returns the number of elements in this list
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if index is out of bounds
	 */
	private boolean isOutOfBounds(int index) {
		return index < 0 || index > size;
	}

	/**
	 * Returns a string of the list
	 */
	public String toString() {
		String listString = "[";
		for (int i = 0; i < size - 1; i++) {
			listString += get(i) + ", ";
		}
		return listString + get(size - 1) + "]";
	}

	/**
	 * Returns an array of the linked list
	 */
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = get(i);
		}
		return array;
	}

	private static class Node<T> {
		private T value;
		private Node<T> next;
		private Node<T> previous;

		/**
		 * Constructs a node with specified value and next = null
		 * 
		 * @param value is the value of the node
		 */
		Node(T value) {
			this.value = value;
			this.next = null;
			this.previous = null;
		}
	}
}
