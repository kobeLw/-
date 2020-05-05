package com.kobe.list;

@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstrackList<E> {
	
	/**
	 * 所有的元素
	 */
	private E[] elements;
	
	private static final int DEAFULT_CAPACITY = 10;
	
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEAFULT_CAPACITY) ? DEAFULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	
	public ArrayList() {
		this(DEAFULT_CAPACITY);
	}
	
	/**
	 * 	清楚所有元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	/**
	 * 获取index位置的元素	
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		return elements[index]; // O(1)
	}
	
	/**
	 * 给index位置的元素设置一个值
	 * @param index
	 * @param element
	 * @return
	 */
	public E set(int index, E element) { // O(1)
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {

		/**
		 *  最好：O(1)
		 *  最坏：O(n)
		 *  平均：O(n)
		 */
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		
		ensureCapacity(size + 1);
		
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	} // size是数据规模
	
	/**
	 * 在index位置删除一个元素
	 * @param index
	 * @param element
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size:" + size);
		}
		E old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		elements[size] = null;
		
		return old;
	}
	
	/**
	 * 查看index位置的元素
	 * @param index
	 * @param element
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
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
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println("旧的容量：" + oldCapacity + "----新的容量：" + newCapacity);
	}
}
