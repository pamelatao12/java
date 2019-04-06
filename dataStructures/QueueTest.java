package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testAdd() {
		Queue<Character> queue = new Queue<>();
		queue.add('a');
		assertEquals((Character) 'a', queue.peek());
	}
	
	@Test
	void testPoll() {
		Queue<Character> queue = new Queue<>();
		queue.add('a'); 
		queue.add('b');
		assertEquals((Character) 'a', queue.poll());
		assertEquals((Character) 'b', queue.peek());
		
		queue.remove();
		assertEquals(null, queue.poll());
	}
	
	@Test
	void testRemove() {
		Queue<Character> queue = new Queue<>();
		queue.add('a');
		queue.add('b');
		assertEquals((Character) 'a', queue.remove());
	}
	
	@Test
	void testisEmpty() {
		Queue<Character> queue = new Queue<>();
		queue.add('a');
		queue.add('b');
		queue.remove();
		assertEquals(false, queue.isEmpty());
		queue.remove();
		assertEquals(true, queue.isEmpty());
	}

}
