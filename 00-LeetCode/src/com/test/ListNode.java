package com.test;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ListNode.val========" + Integer.toString(this.val);
	}
}
