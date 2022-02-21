package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Valid-Palindrome-7c4d81b889e74169900eb4b794857baf
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
	
	/**
	 * O(N/2) algorithm to check for a palindrome in the current string
	 * @param s
	 * @return true if palindrome
	 */
	public boolean isPalindrome(String s) {
		String normalizedS = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		
		if (normalizedS.length() < 2) {
			return true;
		}
		else if (normalizedS.charAt(0) == normalizedS.charAt(normalizedS.length() - 1)) {
			return isPalindrome(normalizedS.substring(1, normalizedS.length() - 1));
		}
		else {
			return false;
		}
	}
}
