package ca.jrvs.practice.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class BinarySearchTest {
	
	// Tests for the Recursive implementation
	@Test
	void testBinarySearchRecursiveHigh() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer target = 7;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(6));
	}
	
	@Test
	void testBinarySearchRecursiveLow() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer target = 2;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(1));
	}
	
	@Test
	void testBinarySearchRecursiveMid() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer target = 5;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(4));
	}
	
	@Test
	void testBinarySearchRecursiveHighLong() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		Integer target = 15;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(14));
	}
	@Test
	void testBinarySearchRecursiveLowLong() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		Integer target = 1;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(0));
	}
	
	@Test
	void testBinarySearchRecursiveNoMatch() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		Integer target = 0;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.empty());
	}
	
	@Test
	void testBinarySearchRecursiveString() {
		String[] arr = {"AB", "CD", "EF", "GH", "IJ", "KL", "MN"};
		String target = "CD";
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(1));
	}

	@Test
	void testBinarySearchRecursiveChar() {
		Character[] arr = {'A','B','C','D','E','F','G','H','I'};
		Character target = 'I';
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchRecursion(arr, target), Optional.of(8));
	}
	
	
	// Tests for the Iterative implementation
	@Test
	void testBinarySearchIterativeHigh() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer target = 7;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(6));
	}
	
	@Test
	void testBinarySearchIterativeLow() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer target = 2;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(1));
	}
	
	@Test
	void testBinarySearchIterativeMid() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer target = 5;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(4));
	}
	
	@Test
	void testBinarySearchIterativeHighLong() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		Integer target = 15;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(14));
	}
	@Test
	void testBinarySearchIterativeLowLong() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		Integer target = 1;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(0));
	}
	
	@Test
	void testBinarySearchIterativeNoMatch() {
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		Integer target = 0;
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.empty());
	}
	
	@Test
	void testBinarySearchIterativeString() {
		String[] arr = {"AB", "CD", "EF", "GH", "IJ", "KL", "MN"};
		String target = "CD";
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(1));
	}

	@Test
	void testBinarySearchIterativeChar() {
		Character[] arr = {'A','B','C','D','E','F','G','H','I'};
		Character target = 'I';
		
		BinarySearch bs = new BinarySearch();
		
		assertEquals(bs.binarySearchIteration(arr, target), Optional.of(8));
	}
}
