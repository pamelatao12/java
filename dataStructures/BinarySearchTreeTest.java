package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void testInsert() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8); 
		tree.insert(12);
		assertEquals((Integer) 10, tree.getRootValue());
		assertEquals("3, 5, 8, 10, 12", tree.printTree(tree.getRoot()));
	}
	
	@Test
	void testRemoveRoot() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		tree.remove(10);
		assertEquals((Integer) 12, tree.getRootValue());
	}
	
	@Test
	void testRemoveLessThanRoot() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		tree.remove(3);
		assertEquals((Integer) 10, tree.getRootValue());
		assertEquals("5, 8, 10, 12", tree.printTree(tree.getRoot()));
		
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(3);
		tree1.insert(8);
		tree1.insert(12);
		tree1.remove(8);
		assertEquals((Integer) 10, tree1.getRootValue());
		assertEquals("3, 5, 10, 12", tree1.printTree(tree1.getRoot()));
		
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(3);
		tree2.insert(8);
		tree2.insert(12);
		tree2.insert(9);
		tree2.remove(8);
		assertEquals((Integer) 10, tree2.getRootValue());
		assertEquals("3, 5, 9, 10, 12", tree2.printTree(tree2.getRoot()));
		
		BinarySearchTree<Integer> tree3 = new BinarySearchTree<>();
		tree3.insert(10);
		tree3.insert(5);
		tree3.insert(3);
		tree3.insert(8);
		tree3.insert(12);
		tree3.insert(9);
		tree3.remove(5);
		assertEquals((Integer) 10, tree3.getRootValue());
		assertEquals("3, 8, 9, 10, 12", tree3.printTree(tree3.getRoot()));
		
		BinarySearchTree<Integer> tree4 = new BinarySearchTree<>();
		tree4.insert(10);
		tree4.insert(5);
		tree4.insert(3);
		tree4.insert(8);
		tree4.insert(12);
		tree4.insert(9);
		tree4.insert(2);
		tree4.remove(3);
		assertEquals((Integer) 10, tree4.getRootValue());
		assertEquals("2, 5, 8, 9, 10, 12", tree4.printTree(tree4.getRoot()));
	}
	
	@Test
	void testRemoveGreaterThanRoot() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		tree.insert(11);
		tree.insert(13);
		tree.remove(12);
		assertEquals((Integer) 10, tree.getRootValue());
		assertEquals("3, 5, 8, 10, 11, 13", tree.printTree(tree.getRoot()));
	}
	
	@Test
	void testRemoveNotFound() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8); 
		tree.insert(12);
		tree.remove(1);
		assertEquals((Integer) 10, tree.getRootValue());
		assertEquals("3, 5, 8, 10, 12", tree.printTree(tree.getRoot()));
		assertEquals(5, tree.size());
	}
	
	@Test
	void testRemoveMinimum() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		tree.insert(7);
		tree.insert(6);
		tree.remove(5);
		assertEquals("3, 6, 7, 8, 10, 12", tree.printTree(tree.getRoot()));
	}
	
	@Test
	void testRemoveNonexistingElement() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.remove(1);
		assertEquals((Integer) 10, tree.getRootValue());
		assertEquals("3, 5, 10", tree.printTree(tree.getRoot()));
	}
	
	@Test
	void testSize() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		assertEquals(5, tree.size());
	}
	
	@Test
	void testisEmpty() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.remove(10);
		assertEquals(true, tree.isEmpty());
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		assertEquals(false, tree.isEmpty());
	}
	
	@Test
	void testgetValue() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(12);
		assertEquals((Integer) 10, tree.getRootValue());
	}
}
