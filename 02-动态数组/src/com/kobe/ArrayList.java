package com.kobe;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class ArrayList {
	
	/**
	 * 元素的数量
	 */
	private int size = 0;
	
	/**
	 * 所有的元素
	 */
	private int[] elements;
	
	private static final int DEAFULT_CAPACITY = 10;
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEAFULT_CAPACITY) ? DEAFULT_CAPACITY : capaticy;
		elements = new int[capaticy];
	}
	
	public ArrayList() {
		this(DEAFULT_CAPACITY);
	}
	
	/**
	 * 	清楚所有元素
	 */
	public void clear() {
		size = 0;
	}
	
	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 是否包含某个元素	
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {
		add(size, element);
	}
	
	/**
	 * 获取index位置的元素	
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		return elements[index];
	}
	
	/**
	 * 给index位置的元素设置一个值
	 * @param index
	 * @param element
	 * @return
	 */
	public int set(int index, int element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		
		ensureCapacity(size + 1);
		
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
		
	
	
	}
	
	/**
	 * 在index位置删除一个元素
	 * @param index
	 * @param element
	 */
	public int remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		int old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		return old;
	}
	
	/**
	 * 查看index位置的元素
	 * @param index
	 * @param element
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public String toString() {
		StringBuilder string =  new StringBuilder();
		string.append("size=").append(size).append(",[");
		for (int i = 0; i < size; i++) {
			string.append(elements[i]);
			if (i != size - 1) {
				string.append(", ");
			}
		}
		string.append("]");
		return string.toString();
	}
	
	
	/**
	 * 	保证要有capacity
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		int[] newElements = new int[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println("旧的容量：" + oldCapacity + "----新的容量：" + newCapacity);
	}
}
