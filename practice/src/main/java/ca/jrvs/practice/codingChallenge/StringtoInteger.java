package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/String-to-Integer-atoi-57eb0949eee14ea2b3e42e36cf4a4eea
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringtoInteger {
	
	/**
	 * O(n) time complexity algorithm to extract the first complete integer in string s
	 * @param s
	 * @return the integer
	 */
	public int myAtoi(String s) {
		boolean plusSign = true;
		int result = 0;
		int currIndex = 0;
		int n = s.length();

		//trim whitespace
		while (currIndex < n && s.charAt(currIndex) == ' ') {
			currIndex++;
		}

		//determine the sign
		if (currIndex < n && s.charAt(currIndex) == '+') {
			plusSign = true;
			currIndex++;
		} 
		else if (currIndex < n && s.charAt(currIndex) == '-') {
			plusSign = false;
			currIndex++;
		}

		//parse through the string
		while (currIndex < n && Character.isDigit(s.charAt(currIndex))) {
			int digit = s.charAt(currIndex) - '0';

			if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
				return plusSign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			result = 10 * result + digit;
			currIndex++;
		}

		return (plusSign ? 1 : -1) * result;
	}
}
