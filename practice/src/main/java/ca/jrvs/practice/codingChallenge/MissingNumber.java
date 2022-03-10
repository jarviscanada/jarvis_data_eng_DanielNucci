package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.notion.so/jarvisdev/Missing-Number-2a55a640614c4e978e33a386523a2ae3
 * https://leetcode.com/problems/missing-number
 */
public class MissingNumber {

	/**
	 * O(n) time complexity algorithm for finding a missing number in a given range
	 * @param nums
	 * @return the missing number else 0
	 */
	public int missingNumber(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		
		for (int num: nums) {
			numSet.add(num);
		}
		
		//must be an inclusive check
		for (int i = 0; i <= nums.length; i++) {
			if (!numSet.contains(i)) {
				return i;
			}
		}
		
		return 0;
	}
}
