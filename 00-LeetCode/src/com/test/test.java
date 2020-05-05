package com.test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		test test = new test();
		int [] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(test.trap(arr));
		
	}
	
	public int trap(int[] height) {
		if (height.length == 0) {
			return 0;
		}
		int total = 0;
		int left = height[0];
		int right = 0;
		for (int i = 1; i < height.length - 1; i++) {
			right = height[i];
			if (right < left) {
				total += (left - right);
			} else {
				left = right;
			}
		}
		return total;
    }

}
