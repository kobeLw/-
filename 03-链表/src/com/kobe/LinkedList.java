package com.kobe;

public class LinkedList<E> extends AbstrackList<E> {

	private Node<E> first;
	private Node<E> last;
	
	
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			System.out.println("哈哈哈哈哈");
			StringBuilder sb = new StringBuilder();
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			sb.append("_").append(element).append("_");
			
			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			return sb.toString();
		}
		
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		if (index == size) {
			Node<E> oldLastNode = last;
			last = new Node<>(last, element, null);
			if (oldLastNode == null) {
				first = last;
			} else {
				oldLastNode.next = last;
			}
			
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node;
			
			if (prev == null) {
				first = node;
			} else {
				prev.next = node;
			}
		}
		
		
		
		
		
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = node(index);
		
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
		}
		
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
		}
		
		
		
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}
				node = node.next;
			}
		}
		return 0;
	}
	
	/**
	 * 根据index找到对应的node
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		
		if (index < size / 2) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder string =  new StringBuilder();
		string.append("size=").append(size).append(",[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node);

			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
}
