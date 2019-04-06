package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeapTest {

	@Test
	void testAddtoEmptyHeap() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		assertEquals("[55]", heap.toString());
	}
	
	@Test
	void testAddtoEndofHeap() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.add(38);
		heap.add(22);
		heap.add(35);
		heap.add(30);
		heap.add(19);
		heap.add(21);
		assertEquals("[55, 38, 22, 35, 30, 19, 21]", heap.toString());
	}
	
	@Test
	void testAddtoTopofHeap() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.add(38);
		heap.add(22);
		heap.add(35);
		heap.add(30);
		heap.add(19);
		heap.add(21);
		assertEquals("[55, 38, 22, 35, 30, 19, 21]", heap.toString());
		heap.add(60);
		assertEquals("[60, 55, 22, 38, 30, 19, 21, 35]", heap.toString());
	}
	
	@Test
	void testAddtoMiddleofHeap() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.add(38);
		heap.add(22);
		heap.add(35);
		heap.add(30);
		heap.add(19);
		heap.add(21);
		assertEquals("[55, 38, 22, 35, 30, 19, 21]", heap.toString());
		heap.add(42);
		assertEquals("[55, 42, 22, 38, 30, 19, 21, 35]", heap.toString());
	}
	
	@Test
	void testPoll() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.add(38);
		heap.add(22);
		heap.add(35);
		heap.add(30);
		heap.add(19);
		heap.add(21);
		heap.poll();
		assertEquals("[38, 35, 22, 21, 30, 19]", heap.toString());
	}
	
	@Test
	void testPollSizeOneHeap() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.poll();
		assertEquals("[]", heap.toString());
	}
	
	@Test
	void testPeek() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.add(38);
		heap.add(22);
		heap.add(35);
		heap.add(30);
		heap.add(19);
		heap.add(21);
		assertEquals((Integer) 55, heap.peek());
	}
	
	@Test
	void testContains() {
		Heap<Integer> heap = new Heap<>();
		heap.add(55);
		heap.add(38);
		heap.add(22);
		heap.add(35);
		heap.add(30);
		heap.add(19);
		heap.add(21);
		assertEquals(true, heap.contains(22));
		assertEquals(false, heap.contains(2));
	}
}
