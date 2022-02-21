package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Rotate-String-0e69fdf991fe4cff8e022db19bc8e7f1
 * https://leetcode.com/problems/rotate-string/
 */
public class RotateString {
	
	/**
	 * O(N^2) where N is s.length time complexity algorithm
	 * @param s
	 * @param goal
	 * @return if the goal can be created by right shifting s any number of times
	 */
	public boolean rotateString(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		return (s + s).contains(goal);
	}
}
