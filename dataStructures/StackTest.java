package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testPushPeek() {
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		stack.push('b');
		assertEquals((Character) 'b', stack.peek());
	}

	@Test
	void testPop() {
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		stack.push('b');
		assertEquals((Character) 'b', stack.pop());
		assertEquals((Character) 'a', stack.peek());
	}
	
	@Test
	void testIsEmpty() {
		Stack<Character> stack = new Stack<>();
		assertEquals(true, stack.isEmpty());
		stack.push('a');
		assertEquals(false, stack.isEmpty());
	}
	
	@Test
	void testSearch() {
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		stack.push('b');
		assertEquals(1, stack.search('b'));
		assertEquals(-1, stack.search('z'));
	}
	
	@Test
	void testSize() {
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		stack.push('b');
		assertEquals(2, stack.size());
	}
}
