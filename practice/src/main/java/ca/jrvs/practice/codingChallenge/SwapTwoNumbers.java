package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Swap-two-numbers-41862076b31b47fb83e294f95cc10bf0
 * Online Judge N/A
 */
public class SwapTwoNumbers {
	
	/**
	 * O(1) time complexity for swapping two variables with no third variable
	 * @param nums
	 * @return a swapped version of the array
	 */
	public int[] swapTwoNumbers (int[] nums) {
		nums[0] ^= nums[1]; // same as nums[0] = nums[0] ^ nums[1]
		nums[1] = nums[0] ^ nums[1];
		nums[0] ^= nums[1];
		return nums;
	}
}
