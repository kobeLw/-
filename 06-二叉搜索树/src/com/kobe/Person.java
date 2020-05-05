package com.kobe;

public class Person implements Comparable<Person> {
	private int age;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Person e) {
		// TODO Auto-generated method stub
		
		return age - e.age;
	}
}
