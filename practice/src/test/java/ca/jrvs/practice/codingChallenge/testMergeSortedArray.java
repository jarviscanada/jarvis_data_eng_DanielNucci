package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testMergeSortedArray {

	@Test
	void testMergeSortedArrayExample1() {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
		int m = 3, n = 3;
		
		int[] testArray = {1,2,2,3,5,6};
		
		msa.merge(nums1, m, nums2, n);
		assertArrayEquals(nums1, testArray);
	}
	
	@Test
	void testMergeSortedArrayExample2() {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = {1}, nums2 = {};
		int m = 1, n = 0;
		
		int[] testArray = {1};
		
		msa.merge(nums1, m, nums2, n);
		assertArrayEquals(nums1, testArray);
	}
	
	@Test
	void testMergeSortedArrayExample3() {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = {0}, nums2 = {1};
		int m = 0, n = 1;
		
		int[] testArray = {1};
		
		msa.merge(nums1, m, nums2, n);
		assertArrayEquals(nums1, testArray);
	}
	
	@Test
	void testMergeSortedArrayTestCase1() {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = {2, 0}, nums2 = {1};
		int m = 1, n = 1;
		
		int[] testArray = {1, 2};
		
		msa.merge(nums1, m, nums2, n);
		assertArrayEquals(testArray, nums1);
	}
}
