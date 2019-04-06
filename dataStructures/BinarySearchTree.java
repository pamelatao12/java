package dataStructures;

public final class BinarySearchTree<E extends Comparable<E>> {
	private TreeNode<E> root;
	private int size;

	public BinarySearchTree() {
	}

	/**
	 * Inserts the element into the BST at the appropriate location
	 * 
	 * @param element is the element to insert into the BST
	 */
	public void insert(E element) {
		root = insertHelper(this.root, element);
		size++;
	}

	/**
	 * Inserts the element into the BST with temp as root BST is not empty
	 */
	private TreeNode<E> insertHelper(TreeNode<E> root, E element) {
		if (root == null) {
			return new TreeNode<E>(element);
		}
		int rootLargerThanElement = root.value.compareTo(element);
		if (rootLargerThanElement > 0) {
			root.leftNode = insertHelper(root.leftNode, element);
		} else if (rootLargerThanElement < 0) {
			root.rightNode = insertHelper(root.rightNode, element);
		}

		return root;
	}

	/**
	 * Removes the specified element from the BST
	 * 
	 * @param element to be removed
	 */
	public void remove(E element) {
		removeHelper(this.root, element);
	}

	/**
	 * Removes element from tree with root and returns the new root
	 * 
	 * @param root
	 * @param element
	 */
	private TreeNode<E> removeHelper(TreeNode<E> root, E element) {
		if (root == null) {
			return root;
		}

		if (root.value.equals(element)) {
			root = removeElement(root);
			size--;
		} else if (root.value.compareTo(element) > 0) {
			root.leftNode = removeHelper(root.leftNode, element);
		} else if (root.value.compareTo(element) < 0) {
			root.rightNode = removeHelper(root.rightNode, element);
		}
		return root;
	}

	/**
	 * Removes the specified root element from the tree
	 * 
	 * @param root
	 * @return
	 */
	private TreeNode<E> removeElement(TreeNode<E> root) {
		if (root.leftNode == null && root.rightNode == null) {
			root = null;
		} else if (root.leftNode == null) {
			root = root.rightNode;
		} else if (root.rightNode == null) {
			root = root.leftNode;
		} else {
			TreeNode<E> minElement = minimum(root.rightNode);
			root.value = minElement.value;
			// have to remove minElement so lower nodes move up
			root.rightNode = removeHelper(root.rightNode, minElement.value);
		}
		return root;
	}

	/**
	 * Finds the node with the minimum element in the tree with root Tree must not
	 * be empty
	 * 
	 * @param root is the root of the tree
	 * @return the node with the minimum element in the tree with root
	 */
	private TreeNode<E> minimum(TreeNode<E> root) {
		while (root.leftNode != null) {
			root = root.leftNode;
		}
		return root;
	}

	/**
	 * Returns the node which contains the value element
	 * 
	 * @param element is the value to look for in the BST
	 * @return the node which contains the specified value
	 */
	public TreeNode<E> find(E element) {
		return find(this.root, element);
	}

	/**
	 * Returns the node which contains the value element. Returns the root if
	 * 
	 * @param element is the value to look for in the BST
	 * @return the node which contains the specified value
	 */
	private TreeNode<E> find(TreeNode<E> root, E element) {
		if (root == null) {
			return null;
		}

		int rootLargerThanElement = root.value.compareTo(element);
		if (rootLargerThanElement == 0) {
			return root;
		}
		return find(rootLargerThanElement > 0 ? root.leftNode : root.rightNode, element);
	}

	/**
	 * Returns true if the BST is empty, false if not
	 * 
	 * @return true if the BST is empty, false if not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the size of the BST
	 * 
	 * @return size of BST
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the root of the tree
	 * 
	 * @return root of the tree
	 */
	public TreeNode<E> getRoot() {
		return root;
	}

	// TODO(dacho): This should not take a root.
	/**
	 * Prints the BST with root "root" in sorted order
	 * 
	 * @param tree
	 */
	public String printTree(TreeNode<E> root) {
		if (root.leftNode == null && root.rightNode == null) {
			return root.value + "";
		}

		String treeString = "";
		if (root.leftNode != null && root.rightNode != null) {
			treeString += printTree(root.leftNode) + ", " + root.value + ", " + printTree(root.rightNode);
		} else if (root.leftNode == null) {
			treeString += root.value + ", " + printTree(root.rightNode);
		} else if (root.rightNode == null) {
			treeString += printTree(root.leftNode) + ", " + root.value;
		}
		return treeString;
	}

	/**
	 * Returns the root of the BST
	 * 
	 * @return
	 */
	public E getRootValue() {
		return root.value;
	}

	private static class TreeNode<T> {
		private T value;
		private TreeNode<T> leftNode;
		private TreeNode<T> rightNode;

		TreeNode(T val) {
			this.value = val;
		}

	}
}
