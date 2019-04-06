package dataStructures;

public final class HashTableLL<K, V> {
	private Object[] array;
	private int size;

	public HashTableLL() {
		this(5);
	}

	public HashTableLL(int initialCapacity) {
		array = new Object[initialCapacity];
		for (int i = 0; i < initialCapacity; i++) {
			array[i] = new LinkedList<>();
		}
	}

	/**
	 * Clears this hashtable so it contains no keys
	 */
	@SuppressWarnings("unchecked")
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[i];
			list.clear();
		}
	}

	/**
	 * Tests if some key maps into the specified value in this hashtable.
	 * 
	 * @param value - value to search for
	 * @return true if some key maps to the value argument in this hashtable as
	 *         determined by the equals method; false otherwise.
	 * @throws NullPointerException if value is null
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(V value) {
		if (value == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < array.length; i++) {
			LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[i];
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).value.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Tests if the specified object is a key in this hashtable.
	 * 
	 * @param key - key to search for
	 * @return true if and only if the specified object is a key in this hashtable,
	 *         as determined by the equals method; false otherwise.
	 * @throws NullPointerException if key is null
	 */
	@SuppressWarnings("unchecked")
	public boolean containsKey(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		int indexKey = indexOf(key);
		LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[indexKey];
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this map
	 * contains no mapping for the key.
	 * 
	 * @param key - the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key.
	 * @throws NullPointerException - if the specified key is null
	 */
	@SuppressWarnings("unchecked")
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		int indexKey = indexOf(key);
		LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[indexKey];
		for (int i = 0; i < list.size(); i++) {
			Entry<K, V> entry = list.get(i);
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	/**
	 * Tests if this hashtable maps no keys to values.
	 * 
	 * @return true if this hashtable maps no keys to values; false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the key (and its corresponding value) from this hashtable. This
	 * method does nothing if the key is not in the hashtable.
	 * 
	 * @param key - the key that needs to be removed
	 * @return the value to which the key had been mapped in this hashtable, or null
	 *         if the key did not have a mapping
	 * @throws NullPointerException if key is null
	 */
	@SuppressWarnings("unchecked")
	public V remove(K key) {
		if (key == null) {
			throw new NullPointerException();
		}

		int indexKey = indexOf(key);
		LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[indexKey];
		for (int i = 0; i < list.size(); i++) {
			Entry<K, V> entry = list.get(i);
			if (entry.key.equals(key)) {
				V tempValue = entry.value;
				list.remove(entry);
				size--;
				return tempValue;
			}
		}
		return null;
	}

	/**
	 * Replaces the entry for the specified key only if it is currently mapped to
	 * some value.
	 * 
	 * @param key   - key with which the specified value is associated
	 * @param value - value to be associated with the specified key
	 * @return the previous value associated with the specified key, or null if
	 *         there was no mapping for the key
	 */
	@SuppressWarnings("unchecked")
	public V replace(K key, V value) {
		int indexKey = indexOf(key);
		LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[indexKey];
		for (int i = 0; i < list.size(); i++) {
			Entry<K, V> entry = list.get(i);
			if (entry.key.equals(key)) {
				V previousValue = entry.value;
				entry.value = value;
				return previousValue;
			}
		}
		return null;
	}

	/**
	 * Maps the specified key to the specified value in this hashtable. Neither the
	 * key nor the value can be null. The value can be retrieved by calling the get
	 * method with a key that is equal to the original key.
	 * 
	 * @param key   - hashtable key
	 * @param value - the value
	 * @return the previous value of the specified key in this hashtable, or null if
	 *         it did not have one
	 * @throws NullPointerException - if the key or value is null
	 */
	@SuppressWarnings("unchecked")
	public V put(K key, V value) {
		if (key == null || value == null) {
			throw new NullPointerException();
		}

		double loadFactor = (double) size / array.length;
		if (loadFactor > 0.75) {
			size = 0;
			rehash();
		}

		Entry<K, V> newEntry = new Entry<>(key, value);
		LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[indexOf(newEntry.key)];
		if (containsKey(key)) {
			return replace(key, value);
		}
		list.add(newEntry);
		size++;
		return null;
	}

	/**
	 * Increases the capacity of and internally reorganizes this hashtable, in order
	 * to accommodate and access its entries more efficiently. This method is called
	 * automatically when the number of keys in the hashtable exceeds this
	 * hashtable's capacity and load factor.
	 */
	@SuppressWarnings("unchecked")
	protected void rehash() {
		Object[] newArray = new Object[array.length * 2];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = new LinkedList<>();
		}
		Object[] oldArray = array;
		array = newArray;
		for (int i = 0; i < oldArray.length; i++) {
			LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) oldArray[i];
			for (int j = 0; j < list.size(); j++) {
				put(list.get(j).key, list.get(j).value);
			}
		}
	}

	/**
	 * Returns the hashtable as a string of the underlying array
	 */
	@SuppressWarnings("unchecked")
	public String toString() {
		String hashString = "[";
		for (int i = 0; i < array.length; i++) {
			LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) array[i];
			if (list.size() != 0) {
				String indexString = "[";
				for (int j = 0; j < list.size() - 1; j++) {
					indexString += list.get(j).key + ":" + list.get(j).value + ", ";
				}
				indexString += list.get(list.size() - 1).key + ":" + list.get(list.size() - 1).value + "]";
				hashString += indexString + ", ";
			} else {
				hashString += "[], ";
			}
		}
		hashString = hashString.substring(0, hashString.length() - 2) + "]";
		return hashString;
	}

	/**
	 * Returns the number of entries in the hashtable
	 * 
	 * @return the number of entries in the hashtable
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the length of the array
	 * 
	 * @return
	 */
	public int length() {
		return array.length;
	}

	/**
	 * Returns the index of the element where it occurs in the array
	 * 
	 * @param Entry
	 * @return the index of the element where it should occur in the array
	 */
	private int indexOf(K key) {
		return key.hashCode() % array.length;
	}

	/**
	 * Constructs a new entry for the hashtable with key K and value V
	 * 
	 * @author pamelatao
	 *
	 * @param <K>
	 * @param <V>
	 */
	private class Entry<KY, VE> {
		private KY key;
		private VE value;

		Entry(KY key, VE value) {
			this.key = key;
			this.value = value;
		}
	}
}
