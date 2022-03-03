package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Duplicates-from-Sorted-Array-212ac59539794dbe94260608c1467ed8
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {
	
	/**
	 * O(n) implementation for removing 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int possibleDuplicate = nums[0], index = 0;
	
		for (int value: nums) {
			if (value != possibleDuplicate) {
				nums[index] = possibleDuplicate;
				index++;
			}
			possibleDuplicate = value;
		}
		nums[index] = possibleDuplicate;
		index++;
		return index;
	}
}
