package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.notion.so/jarvisdev/Find-the-Duplicate-Number-958477eeb0264290ac26b9cdd2f18303
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class DuplicateNumber {

	/**
	 * O(n) time complexity algorithm to find the duplicate integer in an array of integers
	 * @param nums
	 * @return the number that is repeated
	 */
	public int findDuplicate(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		
		for (int num: nums) {
			if (numSet.contains(num)) {
				return num;
			}
			else {
				numSet.add(num);
			}
		}
		
		return -1;
    }
}
