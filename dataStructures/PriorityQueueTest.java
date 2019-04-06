package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {

	@Test
	void testAddtoEmptyQueue() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		assertEquals("[a]", queue.toString());
	}
	
	@Test
	void testAddtoQueue() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		assertEquals("[a, b, c, d]", queue.toString());
	}
	
	@Test
	void testAddtoFullQueue() {
		PriorityQueue<Character> queue = new PriorityQueue<>(3);
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		assertEquals("[a, b, c, d]", queue.toString());
	}
	
	@Test
	void testAddHigherPriority() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 2);
		queue.add('b', 3);
		queue.add('c', 4);
		queue.add('d', 1);
		assertEquals("[d, a, c, b]", queue.toString());
	}

	@Test
	void testPoll() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		queue.poll();
		assertEquals("[c, b, d]", queue.toString());
	}
	
	@Test
	void testPollSizeOneHeap() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.poll();
		assertEquals("[]", queue.toString());
	}
	
	@Test
	void testPollEmptyHeap() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		assertEquals(null, queue.poll());
	}
	
	@Test
	void testSize() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		assertEquals(1, queue.size());
	}
	
	@Test
	void testPeek() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		assertEquals((Character) 'a', queue.peek());
	}
	
	@Test
	void testContains() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		assertEquals(true, queue.contains('c'));
		assertEquals(false, queue.contains('z'));
	}
	
	@Test
	void testRemoveMiddle() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		queue.add('e', 5);
		queue.remove('b');
		assertEquals(false, queue.contains('b'));
		assertEquals("[a, d, c, e]", queue.toString());
	}
	
	@Test
	void testRemoveFirst() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		queue.remove('a');
		assertEquals("[c, b, d]", queue.toString());
	}
	
	@Test
	void testRemoveEnd() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		queue.remove('d');
		assertEquals("[a, b, c]", queue.toString());
	}
	
	@Test
	void testRemoveNonexistent() {
		PriorityQueue<Character> queue = new PriorityQueue<>();
		queue.add('a', 1);
		queue.add('b', 3);
		queue.add('c', 2);
		queue.add('d', 4);
		queue.remove('e');
		assertEquals("[a, b, c, d]", queue.toString());
	}

}
