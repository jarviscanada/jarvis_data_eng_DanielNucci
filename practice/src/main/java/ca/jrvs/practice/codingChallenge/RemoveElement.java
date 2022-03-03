package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Remove-Element-a0d6b2ddf1ba44cd95d4c0a236aff132
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
	
	/**
	 * O(n) implementation to remove all elements matching a value from an array
	 * @param nums
	 * @param val
	 * @return the number of values left over in the array
	 */
	public int removeElement(int[] nums, int val) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        
        while (leftIndex <= rightIndex) {
        	if (nums[leftIndex] == val) {
        		nums[leftIndex] = nums[rightIndex];
        		rightIndex--;
        	}
        	else {
        		leftIndex++;
        	}
        }
		
		return rightIndex + 1;
    }
}
