package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Check-if-a-String-contains-only-digits-b250b10980354da68a5888eb031524cc
 * Online Judge N/A
 */
public class ValidParsableInteger {

	/**
	 * O(n) time complexity algorithm to determine if all characters in a given string are numeric
	 * @param s
	 * @return if all characters are integers
	 */
	public boolean isValidParsableInt(String s) {
		for (char c: s.toCharArray()) {
			if (c < 48 || c > 57) {
				return false;
			}
		}
		return true;
	}
}
