package com.kobe;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.kobe.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 添加第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 添加的不是第一个节点
		// 找到父节点
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // 想等
				node.element = element;
				return;
			}
		}
		
		// 看看插入到父节点的那个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
	}
	
	public void remove(E element) {
		
	}
	
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * 前序遍历
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<E> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	/**
	 * 中序遍历
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<E> node) {
		if (node == null) {
			return;
		}
		
		inorderTraversal(node.left);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}
	
	/**
	 * 后序遍历
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<E> node) {
		if (node == null) {
			return;
		}
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.element);
	}
	
	public void levelOrderTranversal() {
		
	}
	
	/**
	 * @param e1
	 * @param e2
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1>e2；返回值小于0，代表e1<e2
	 */
	public int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) {
			return;
		}
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) {
				return;
			}
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @param element
		 * @return 如果返回true就停止遍历
		 */
		abstract boolean visit(E element);
	}
	
	/**s
	 * 是否是完全二叉树
	 * @return
	 */
	public boolean isComplete() {
		if (root == null) {
			return false;
		}
		Queue<Node<E>> queue = new LinkedList<>();
		
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) {
				return false;
			}
			
			if (node.hasTwoChildren()) {
				queue.offer(node.left);
				queue.offer(node.right);
			} else if (node.left == null && node.right != null) {
				return false;
			} else {
				leaf = true;
				if (node.left != null ) {
					queue.offer(node.left);
				}
			}
		}
		return true;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
	}

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).element;
	}
}
