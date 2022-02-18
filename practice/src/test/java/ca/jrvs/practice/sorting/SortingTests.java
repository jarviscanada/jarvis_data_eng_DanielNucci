package ca.jrvs.practice.sorting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SortingTests {
	
	// Tests for QuickSort
	@Test
	void testQuickSortPass() {
		QuickSort qs = new QuickSort();
		int[] arr = {6, 7, 8, 9, 1, 2, 4, 5, 3};
		int[] compArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		qs.quickSort(arr, 0, arr.length - 1);
		
		boolean result = false;
		
		if (compArr.length == arr.length) {
			for (int i = 0; i < compArr.length; i++) {
				if (compArr[i] == arr[i]) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}
	
	@Test
	void testQuickSortFail() {
		QuickSort qs = new QuickSort();
		int[] arr = {6, 7, 8, 1, 1, 2, 4, 5, 3};
		int[] compArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		qs.quickSort(arr, 0, arr.length - 1);
		
		boolean result = false;
		
		if (compArr.length == arr.length) {
			for (int i = 0; i < compArr.length; i++) {
				if (compArr[i] == arr[i]) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertFalse(result);
	}
	
	// Tests for MergeSort
		@Test
		void testMergeSortPass() {
			MergeSort qs = new MergeSort();
			int[] arr = {6, 7, 8, 9, 1, 2, 4, 5, 3};
			int[] compArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			
			qs.mergeSort(arr, arr.length);
			
			boolean result = false;
			
			if (compArr.length == arr.length) {
				for (int i = 0; i < compArr.length; i++) {
					if (compArr[i] == arr[i]) {
						result = true;
					}
					else {
						result = false;
						break;
					}
				}
			}
			assertTrue(result);
		}
		
		@Test
		void testMergeSortFail() {
			MergeSort qs = new MergeSort();
			int[] arr = {6, 7, 8, 1, 1, 2, 4, 5, 3};
			int[] compArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			
			qs.mergeSort(arr, arr.length);
			
			boolean result = false;
			
			if (compArr.length == arr.length) {
				for (int i = 0; i < compArr.length; i++) {
					if (compArr[i] == arr[i]) {
						result = true;
					}
					else {
						result = false;
						break;
					}
				}
			}
			assertFalse(result);
		}
}
