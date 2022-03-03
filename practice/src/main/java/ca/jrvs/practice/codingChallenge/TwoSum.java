package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.notion.so/jarvisdev/Two-Sum-938ff2196f6847f9afff03006f382246
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
	
	/**
	 * O(n) time complexity implementation for solving the two sum problem
	 * @param nums
	 * @param target
	 * @return an array containing the location of the 2 numbers that add to target
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] resArr = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
		
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(val)) {
				resArr[1] = i;
				resArr[0] = map.get(val);
				return resArr;
			}
			map.put(nums[i], i);
		}
        return new int[]{0,0};
    }
}
