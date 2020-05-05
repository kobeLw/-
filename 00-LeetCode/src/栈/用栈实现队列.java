package 栈;

import java.util.Queue;
import java.util.Stack;

public class 用栈实现队列 {
	
	private Stack<Integer> inStack = new Stack<Integer>();
	
	private Stack<Integer> outStack = new Stack<Integer>();
	
	/** Initialize your data structure here. */
    public 用栈实现队列() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if (outStack.isEmpty()) {
			for (int i = 0; i < inStack.size(); i++) {
				outStack.push(inStack.pop());
			}
		} 
		return outStack.pop();
		
    }
    
    /** Get the front element. */
    public int peek() {
    	int element = pop();
    	push(element);
    	return element;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
}
