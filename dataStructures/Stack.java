package dataStructures;

import java.util.EmptyStackException;

public final class Stack<E> {
	private DoublyLinkedList<E> list;

	/**
	 * Creates an empty stack
	 */
	public Stack() {
		this.list = new DoublyLinkedList<>();
	} 

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack
	 * 
	 * @return the object at the top of this stack
	 * @throws EmptyStackException if stack is empty
	 */
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.getTail();
	}

	/**
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function
	 * 
	 * @return the object at the top of this stack
	 */
	public E pop() {
		return list.removeLast();
	}

	/**
	 * 
	 * @param element is the element to be pushed onto the stack
	 * @return the element that is pushed onto the stack
	 */
	public E push(E element) {
		list.add(element);
		return element;
	}

	/**
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * 
	 * @param element is the element to search for in the stack
	 * @return the 1-based position where an object is on this stack. The topmost
	 *         item of the stack is at distance 1. Returns -1 if the object is not
	 *         in the stack.
	 */
	public int search(E element) {
		if (!list.contains(element)) {
			return -1;
		}
		return list.size() - list.indexOf(element);
	}

	/**
	 * Returns the size of the stack
	 * 
	 * @return the size of the stack
	 */
	public int size() {
		return list.size();
	}
}
