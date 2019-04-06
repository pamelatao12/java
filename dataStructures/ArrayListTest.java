package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayListTest {

	@Test
	void testGet() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		arrayA.add(1);
		assertEquals(Integer.valueOf(1),(arrayA.get(0)));
		
		arrayA.add(3);
		assertEquals(Integer.valueOf(3),arrayA.get(1));

//		arrayA.add(5);
//		assertEquals(Integer.valueOf(5),arrayA.get(3));
	}
	
	@Test
	void testRemove() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		arrayA.add(1);
		assertEquals(Integer.valueOf(1),arrayA.get(0));
		
		arrayA.add(3);
		assertEquals(Integer.valueOf(3),arrayA.get(1));
		
		arrayA.add(5);
		assertEquals(Integer.valueOf(5),arrayA.get(2));
		
		arrayA.add(7);
		assertEquals(Integer.valueOf(7),arrayA.get(3));
//		System.out.println(arrayA.get(0));
		arrayA.remove(1);
		assertEquals(Integer.valueOf(3),arrayA.get(0));

		arrayA.remove(5);
		assertEquals(Integer.valueOf(7),arrayA.get(1));
		
		arrayA.remove(7);
		assertEquals(Integer.valueOf(3),arrayA.get(0));
	}
	
	@Test
	void testContains() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		arrayA.add(1);
		arrayA.add(3);
		arrayA.add(5);
		arrayA.add(7);
		assertEquals(true,arrayA.contains(3));
		assertEquals(false,arrayA.contains(2));
	}
	
	@Test
	void testIndexOf() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		arrayA.add(1);
		arrayA.add(3);
		arrayA.add(5);
		arrayA.add(7);
		assertEquals(1,arrayA.indexOf(3));
		assertEquals(-1,arrayA.indexOf(2));
	}
	
	@Test
	void testIsEmpty() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		assertEquals(true,arrayA.isEmpty());
		
		arrayA.add(1);
		arrayA.add(3);
		arrayA.add(5);
		arrayA.add(7);
		assertEquals(false,arrayA.isEmpty());
		arrayA.remove(3);
		assertEquals(false,arrayA.isEmpty());
	}
	
	@Test
	void testSet() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
	        arrayA.set(2,3);
	    });
		arrayA.add(1);
		arrayA.add(3);
		arrayA.add(5);
		arrayA.add(7);
		arrayA.set(0, 3);
		assertEquals(Integer.valueOf(3),arrayA.get(0));
	}
	
	@Test
	void testSize() {
		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		arrayA.add(1);
		arrayA.add(3);
		arrayA.add(5);
		arrayA.add(7);
		assertEquals(4,arrayA.size());
	}
}
