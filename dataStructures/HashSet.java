package dataStructures;

public class HashSet<K, V> {
	private HashTableLL<K, V> set = new HashTableLL<>();

	public HashSet() {
	}

	/**
	 * Dummy value to associate with an object value in the backing hashtable
	 */
	private static final Object PRESENT = new Object();

	/**
	 * Adds the specified element to this set if it is not already present. Leaves
	 * the set unchanged if element is present
	 * 
	 * @param key - element to add in the set
	 * @return true if element was added, false if not
	 */
	@SuppressWarnings("unchecked")
	public boolean add(K key) {
		return set.put(key, (V) PRESENT) == null;
	}

	/**
	 * Removes the specified element from this set if it is present
	 * 
	 * @param key - object to be removed from this set, if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(K key) {
		return set.remove(key) != null;
	}

	/**
	 * Removes all of the elements from this set
	 */
	public void clear() {
		set.clear();
	}

	/**
	 * Returns true if this set contains the specified element
	 * 
	 * @param key - the specified element to look for
	 * @return true if this set contains the specified element
	 */
	public boolean contains(K key) {
		return set.containsKey(key);
	}

	/**
	 * Returns true if this set contains no elements
	 * 
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Returns the number of elements in this set
	 * 
	 * @return number of elements in this set
	 */
	public int size() {
		return set.size();
	}
}
