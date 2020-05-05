package com.kobe;

import java.util.Comparator;

import com.kobe.printer.BinaryTrees;

public class Main {
	
	private static class PersonComparator implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}
	
	private static class PersonComparator2 implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5 ,8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Integer> bstBinarySearchTree = new BinarySearchTree<>();
		
		for (int i = 0; i < data.length; i++) {
			bstBinarySearchTree.add(data[i]);
		}
		
		BinaryTrees.println(bstBinarySearchTree);
		
//		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
//		
//		BinarySearchTree<Person> bst3 = new BinarySearchTree<>(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				// TODO Auto-generated method stub
//				return o2.getAge() - o1.getAge();
//			}
//			
//		});
//		bst3.add(new Person(12));
//		bst3.add(new Person(12));
	}

}
