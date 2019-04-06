package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {
 
	@Test
	void testAddtoEnd() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		assertEquals((Character) 'a', list.get(0));
		list.add('b');
		assertEquals((Character) 'b', list.get(1));
		assertEquals(2, list.size());
		
	}

	@Test
	void testAddIndexOutOfBounds() {
		LinkedList<Character> list = new LinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(3, 'a');
		});
	}

	@Test
	void testGetIndexOutOfBounds() {
		LinkedList<Character> list = new LinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(3);
		});
	}
	
	@Test
	void testRemoveIndexOutOfBounds() {
		LinkedList<Character> list = new LinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(3);
		});
	}
	
	@Test
	void testSetIndexOutOfBounds() {
		LinkedList<Character> list = new LinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(3, 'a');
		});
	}
	
	@Test
	void testAddtoFirstIndex() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('b');
		list.add('c');
		list.add(0, 'a');
		assertEquals((Character) 'a', list.get(0));
	}
	
	@Test
	void testAddtoMiddle() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add(1, 'd');
		assertEquals((Character) 'd', list.get(1));
		list.add(2, 'z');
		assertEquals((Character) 'z', list.get(2));
	}
	
	@Test
	void testAddtoLastIndex() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('c');
		list.add(1, 'b');
		assertEquals((Character) 'b', list.get(1));
	}
	
	@Test
	void testClear() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	void testContains() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		assertEquals(true, list.contains((Character) 'a'));
		assertEquals(true, list.contains((Character) 'b'));
		assertEquals(true, list.contains((Character) 'c'));
		assertEquals(false, list.contains((Character) 'e'));
	}
	
	@Test
	void testRemoveFirst() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove(0);
		assertEquals(false, list.contains((Character) 'a'));
	}
	
	@Test
	void testRemoveOne() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.remove(0);
		assertEquals(false, list.contains((Character) 'a'));
		assertEquals(0, list.size());
	}
	
	@Test
	void testRemoveMiddle() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove(1);
		assertEquals(false, list.contains((Character) 'b'));
	}
	
	@Test
	void testRemoveLast() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove(2);
		assertEquals(false, list.contains((Character) 'c'));
	}
	
	@Test
	void testRemoveLastElement() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove((Character) 'c');
		assertEquals(false, list.contains((Character) 'c'));
	}
	
	@Test
	void testRemoveFirstElement() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove((Character) 'a');
		assertEquals(false, list.contains((Character) 'a'));
	}
	
	@Test
	void testRemoveMiddleElement() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.remove((Character) 'b');
		assertEquals(false, list.contains((Character) 'b'));
	}
	
	@Test
	void testSetFirst() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('d');
		list.add('b');
		list.add('c');
		list.set(0, 'a');
		assertEquals((Character) 'a', list.get(0));
	}
	
	@Test
	void testSetMiddle() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('d');
		list.add('c');
		list.set(1, 'b');
		assertEquals((Character) 'b', list.get(1));
	}
	
	@Test
	void testSetLast() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('b');
		list.add('d');
		list.set(2, 'a');
		assertEquals("[a, b, a]", list.toString());
		
		Character[] array = new Character[3];
		array[0] = 'a';
		array[1] = 'b';
		array[2] = 'a';
		assertArrayEquals(array, list.toArray());
		assertEquals((Character) 'a', list.get(0));
	}
	
	@Test
	void testIsEmpty() {
		LinkedList<Character> list = new LinkedList<>();
		assertEquals(true, list.isEmpty());
		list.add('a');
		assertEquals(false, list.isEmpty());
	}
	
	@Test
	void testPeek() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('d');
		list.add('c');
		assertEquals((Character) 'a', list.peek());
	}
	
	@Test
	void testIterator() {
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('d');
		list.add('c');
		Iterator<Character> iterator = list.ListIterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Character) 'd', iterator.next());
		iterator.next();
		assertEquals(false, iterator.hasNext());
		iterator.remove();
		assertEquals("[a, d]", list.toString());
	}
}

