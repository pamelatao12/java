package dataStructures;

import java.util.NoSuchElementException;

public final class Queue<E> {
	private final DoublyLinkedList<E> list;

	/**
	 * Creates an empty queue
	 */
	public Queue() {
		this.list = new DoublyLinkedList<>();
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions
	 * 
	 * @param element to be inserted in this queue
	 * @return true if specified element is successfully inserted
	 * @throws NullPointerException - if the specified element is null and this
	 *                              queue does not permit null elements
	 */
	public boolean add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		list.add(element);
		return true;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue
	 * 
	 * @return the first element (head) of this queue
	 * @throws NoSuchElementException if queue is empty
	 */
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.peek();
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue
	 * is empty
	 * 
	 * @return the head of this queue. Null if this queue is empty
	 */
	public E poll() {
		// TODO(dacho): Use ternary operator.
		// if (a) { return b } else { return c } <==> a ? b : c.
		return isEmpty() ? null : list.removeFirst();
		}

	/**
	 * Retrieves and removes the head of this queue. This method differs from poll
	 * only in that it throws an exception if this queue is empty.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException if queue is empty
	 */
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return poll();
	}
	
	/**
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
