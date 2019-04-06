package dataStructures;

public interface Iterator<E> {

	/**
	 * 
	 * @return true if the iteration has more elements
	 */
	boolean hasNext();

	/**
	 * 
	 * @return the next element in the iteration
	 */
	E next();

	/**
	 * Removes from the underlying collection the last element returned by this
	 * iterator
	 */
	void remove();

}
