package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Merge-Sorted-Array-0f71b52a19d84508a8a3bd76b7dca52d
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
	
	/**
	 * O(n log n) time complexity algorithm to merge two sorted arrays
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums1Index = m - 1, nums2Index = n - 1, returnIndex = m + n - 1;
		
		while (nums1Index >= 0 && nums2Index >= 0) {
			if (nums1[nums1Index] > nums2[nums2Index]) {
				nums1[returnIndex] = nums1[nums1Index];
				
				returnIndex--;
				nums1Index--;
			}
			else {
				nums1[returnIndex] = nums2[nums2Index];
				
				returnIndex--;
				nums2Index--;
			}
		}
		
		while (nums2Index >= 0) {
			nums1[returnIndex] = nums2[nums2Index];
			
			returnIndex--;
			nums2Index--;
		}
	}
}
