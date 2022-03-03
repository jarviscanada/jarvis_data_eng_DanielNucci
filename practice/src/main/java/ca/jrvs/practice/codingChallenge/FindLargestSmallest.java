package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Find-Largest-Smallest-517a6d6416c3473eb8558c23075be197
 * Online Judge N/A
 */
public class FindLargestSmallest {
	
	/**
	 * O(n) implementation to find the smallest number and the largest number in a given array
	 * @param nums
	 * @return an array containing the smallest value in [0] and the largest in [1]
	 */
	public int[] findLargestSmallest(int[] nums) {
		int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
		
		for (int number: nums) {
			if (number > largest) {
				largest = number;
			}
			else if (number < smallest) {
				smallest = number;
			}
		}
		return new int[] {smallest, largest};
	}
}
