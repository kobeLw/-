package com.kobe;

public class Main {
	public static void main(String[] args) {
		int array[] = new int[] {11, 22, 33};
		
		
		ArrayList list =  new ArrayList();
		list.add(77);
		list.add(88);
		list.add(99);
		
		list.add(3, 66);
		System.out.println(list.toString());
	}
}
