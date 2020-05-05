package com.kobe;

public class Main {
	public static void main(String[] args) {
		SingleCycleLinkedList<Integer> list = new SingleCycleLinkedList<Integer>();
		list.add(20);
		list.add(0, 10);
		list.add(30);
		list.add(list.size(), 40);
		
//		list.remove(1);
		
		System.out.println(list);
	}
}
