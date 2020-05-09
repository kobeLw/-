package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		test test = new test();
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(test.dailyTemperatures(temperatures));
		
	}
	
	/**
	 * 739.每日温度
	 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
	 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[T.length];
		
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				res[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			
			stack.push(i);
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		return res;
	}

}
