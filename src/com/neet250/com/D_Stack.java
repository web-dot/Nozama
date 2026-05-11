package com.neet250.com;

import java.util.Stack;

public class D_Stack {

	
	// valid parenthesis
	public static boolean isValidBruteForce(String s) {
		String prev = "";
		while(!s.equals(prev)) {
			prev = s;
			s = s.replace("()", "").replace("[]", "").replace("{}", "");
		}
		return s.isEmpty();
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				if(c == ')' && stack.pop() != '(') {
					return false;
				}
				if(c == '}' && stack.pop() != '{') {
					return false;
				}
				if(c == ']' && stack.pop() != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	
	
	public static void main(String args[]) {
		System.out.println(isValid(")))"));
	}
}
