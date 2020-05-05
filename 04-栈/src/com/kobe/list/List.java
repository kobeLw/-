package com.kobe.list;

public interface List<E> {
	
	static final int ELEMENT_NOT_FOUND = -1;
	
	/**
	 * 	清楚所有元素
	 */
	void clear();
	
	/**
	 * 元素的数量
	 * @return
	 */
	int size();
	
	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 是否包含某个元素	
	 * @param element
	 * @return
	 */
	boolean contains(E element);
	
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	void add(E element);
	
	/**
	 * 获取index位置的元素	
	 * @param index
	 * @return
	 */
	E get(int index);
	
	/**
	 * 给index位置的元素设置一个值
	 * @param index
	 * @param element
	 * @return
	 */
	E set(int index, E element);
	
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	void add(int index, E element);
	
	/**
	 * 在index位置删除一个元素
	 * @param index
	 * @param element
	 */
	E remove(int index);
	
	/**
	 * 查看index位置的元素
	 * @param index
	 * @param element
	 */
	int indexOf(E element);

}
