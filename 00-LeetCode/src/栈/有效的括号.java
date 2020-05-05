package 栈;

import java.util.Stack;

public class 有效的括号 {
	
	/**
	 * 方法一
	 * [({})]
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
			s = s.replace("{}", "");
			s = s.replace("()", "");
			s = s.replace("[]", "");
		}
		return s.isEmpty();
    }
	
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>(); 
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char left = stack.pop();
				if (left == '(' && c != ')') {
					return false;
				}
				if (left == '[' && c != ']') {
					return false;
				}
				if (left == '{' && c != '}') {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
}
