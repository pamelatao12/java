package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void testPut() {
		HashTable<Integer, Character> hashTable = new HashTable<>();
		assertEquals(null, hashTable.put(1, 'a'));
		hashTable.put(2, 'b');
		hashTable.put(2, 'c'); 
		hashTable.put(3, 'b');
		hashTable.put(4, 'e');
		hashTable.put(5, 'f');
		hashTable.put(12, 'z');
		hashTable.put(14, 'x');
		assertEquals("[null, [1:a], [2:c, 12:z], [3:b], [4:e, 14:x], [5:f], null, null, null, null]",
				hashTable.toString());
	}

	@Test
	void testPutSameIndex() {
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals("[null, [1:a, 6:d], [2:b], [3:c], null]", hashTable.toString());
		hashTable.put(11, 'e');
		assertEquals("[null, [1:a, 11:e], [2:b], [3:c], null, null, [6:d], null, null, null]", hashTable.toString());
	}

	@Test
	void testSize() {
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		hashTable.put(11, 'e');
		assertEquals(5, hashTable.size());
	}
	
	@Test
	void testLength() {
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		hashTable.put(11, 'e');
		assertEquals(10, hashTable.length());
	}
	
	@Test
	void testClear(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		hashTable.clear();
		assertEquals("[null, null, null, null, null]", hashTable.toString());
	}
	
	@Test
	void testContains(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals(true, hashTable.contains('b'));
		assertEquals(false, hashTable.contains('k'));
	}
	
	@Test
	void testContainsKey(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals(true, hashTable.containsKey(3));
		assertEquals(false, hashTable.containsKey(10));
	}
	
	@Test
	void testGet(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals((Character) 'c', hashTable.get(3));
		assertEquals(null, hashTable.get(5));
	}
	
	@Test
	void testGetLonger(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(11, 'c');
		hashTable.put(6, 'd');
		System.out.println(hashTable.toString());
		assertEquals((Character) 'c', hashTable.get(11));
		assertEquals(null, hashTable.get(5));
	}
	
	@Test
	void testIsEmpty(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		assertEquals(true, hashTable.isEmpty());
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals(false, hashTable.isEmpty());
	}
	
	@Test
	void testRemove(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals((Character) 'b', hashTable.remove(2));
		assertEquals("[null, [1:a, 6:d], null, [3:c], null]", hashTable.toString());
	}
	
	@Test
	void testRemoveMultiEntry(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals((Character) 'd', hashTable.remove(6));
		assertEquals("[null, [1:a], [2:b], [3:c], null]", hashTable.toString());
	}
	
	@Test
	void testRemoveNonexistentKey(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals(null, hashTable.remove(10));
	}
	
	@Test
	void testReplace(){
		HashTable<Integer, Character> hashTable = new HashTable<>();
		hashTable.put(1, 'a');
		hashTable.put(2, 'b');
		hashTable.put(3, 'c');
		hashTable.put(6, 'd');
		assertEquals((Character) 'b', hashTable.replace(2, 'x'));
		assertEquals("[null, [1:a, 6:d], [2:x], [3:c], null]", hashTable.toString());
		assertEquals(null, hashTable.replace(10, 'x'));
	}
	
	@Test
	void testException() {
		HashTable<Integer, Character> hashTable = new HashTable<>();
		assertThrows(NullPointerException.class, () -> hashTable.get(null));
		assertThrows(NullPointerException.class, () -> hashTable.contains(null));
		assertThrows(NullPointerException.class, () -> hashTable.containsKey(null));
		assertThrows(NullPointerException.class, () -> hashTable.remove(null));
		assertThrows(NullPointerException.class, () -> hashTable.put(null, 'c'));
		assertThrows(NullPointerException.class, () -> hashTable.put(1, null));
		assertThrows(NullPointerException.class, () -> hashTable.put(null, null));
	}
	
}
