package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

	@Test
	void testAddtoEnd() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		assertEquals("[a, b]", list.toString());
	}

	@Test
	void testAddFirstIndex() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add(0, 'b');
		assertEquals("[b, a]", list.toString());
	}

	@Test
	void testAddMiddleIndex() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.add(2, 'b');
		assertEquals("[a, b, b, c, d]", list.toString());
	}

	@Test
	void testAddLastIndex() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add(1, 'b');
		assertEquals("[a, b, b]", list.toString());
	}

	@Test
	void testClear() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	void testContains() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals(true, list.contains('a'));
		assertEquals(false, list.contains('e'));
	}

	@Test
	void testGetFirst() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals((Character) 'a', list.get(0));
	}

	@Test
	void testGetMiddle() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals((Character) 'b', list.get(1));
	}

	@Test
	void testGetLast() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals((Character) 'c', list.get(2));
	}

	@Test
	void testIndexOfFirst() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals(0, list.indexOf('a'));
	}

	@Test
	void testIndexOfMiddle() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals(1, list.indexOf('b'));
	}

	@Test
	void testIndexOfLast() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals(2, list.indexOf('c'));
	}

	@Test
	void testPeek() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals((Character) 'a', list.peek());
	}

	@Test
	void testIsEmpty() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		assertEquals(true, list.isEmpty());
		list.add('a');
		assertEquals(false, list.isEmpty());
	}

	@Test
	void testRemoveFirst() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove(0);
		assertEquals("[b, c]", list.toString());
	}

	@Test
	void testRemoveMiddle() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove(1);
		assertEquals("[a, c]", list.toString());
	}

	@Test
	void testRemoveLast() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove(2);
		assertEquals("[a, b]", list.toString());
	}
	
	@Test
	void testRemoveOnlyOne() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.remove(0);
		assertEquals(true, list.isEmpty());
	}

	@Test
	void testRemoveElement() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove((Character) 'a');
//		System.out.println(list.toString());
		assertEquals("[b, c]", list.toString());
	}

	@Test
	void testSetFirst() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.set(0, 'z');
		assertEquals("[z, b, c]", list.toString());
	}

	@Test
	void testSetMiddle() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.set(1, 'z');
		assertEquals("[a, z, c]", list.toString());
	}

	@Test
	void testSetLast() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.set(2, 'z');
		assertEquals("[a, b, z]", list.toString());
	}

	@Test
	void testSize() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals(3, list.size());
	}

	@Test
	void testToString() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals("[a, b, c]", list.toString());
	}

	@Test
	void testToArray() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		Character[] array = new Character[2];
		array[0] = 'a';
		array[1] = 'b';
		list.add('a');
		list.add('b');
		assertArrayEquals(array, list.toArray());
	}
	
	@Test
	void testIndexOutOfBounds() {
		LinkedList<Character> list = new LinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(3, 'a');
			list.get(3);
			list.remove(3);
			list.set(3, 'a');
		});
	}

}
