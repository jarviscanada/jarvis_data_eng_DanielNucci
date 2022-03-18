package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.notion.so/jarvisdev/Contains-Duplicate-7ea904b61a2441a193d7b90abf60d3c2
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
	
	/**
	 * O(n) time complexity algorithm to determine if an array contains a duplicate number
	 * @param nums
	 * @return true if a duplicate exists
	 */
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int num: nums){
            if (numSet.contains(num)) {
                return true;
            }
            else {
                numSet.add(num);
            }
        }
        return false;
    }
}
