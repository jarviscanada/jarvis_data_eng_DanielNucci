package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

/**
 * https://www.notion.so/jarvisdev/Valid-Parentheses-dba0db669136493d9b00f4b960278251
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
	
	/**
	 * O(n) time complexity algorithm to determine if all open parentheses have a matching close parentheses
	 * @param s
	 * @return if the string contains valid parentheses
	 */
	public boolean isValid(String s)  {
		Stack<Character> brackets = new Stack<Character>();
		
		for (char c: s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				brackets.push(c);
			}
			else if (brackets.size() > 0 && c == ')' && brackets.peek() == '(') {
				brackets.pop();
			}
			else if (brackets.size() > 0 && c == '}' && brackets.peek() == '{') {
				brackets.pop();
			}
			else if (brackets.size() > 0 && c == ']' && brackets.peek() == '[') {
				brackets.pop();
			}
			else {
				return false;
			}
		}
		if (brackets.size() == 0) {
			return true;
		}
		
		return false;
	}
}
