package com.kobe;

public class Main {
	public static void main(String[] args) {
		int array[] = new int[] {11, 22, 33};
		
		
		ArrayList list =  new ArrayList();
		list.add(77);
		list.add(88);
		list.add(99);
		list.add(66);
		list.add(55);
		
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		
		System.out.println(list.toString());

		
	}
}
