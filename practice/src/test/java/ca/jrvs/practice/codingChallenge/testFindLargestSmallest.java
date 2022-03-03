package ca.jrvs.practice.codingChallenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class testFindLargestSmallest {

	@Test
	void testFindLargestSmallestPass() {
		FindLargestSmallest fls = new FindLargestSmallest();
		int[] inArr = {7, 2, 1, 6, 3, 9, 10, 0, 5};
		int[] outArr = {0, 10};
		
		assertArrayEquals(outArr, fls.findLargestSmallest(inArr));
	}
	
	@Test
	void testFindLargestSmallestSameValue() {
		FindLargestSmallest fls = new FindLargestSmallest();
		int[] inArr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] outArr = {1, 1};
		
		assertArrayEquals(outArr, fls.findLargestSmallest(inArr));
	}
	
	@Test
	void testFindLargestSmallestNegativeValues() {
		FindLargestSmallest fls = new FindLargestSmallest();
		int[] inArr = {7, 2, 1, 6, -3, 9, 10, 0, -5};
		int[] outArr = {-5, 10};
		
		assertArrayEquals(outArr, fls.findLargestSmallest(inArr));
	}
	
	@Test
	void testFindLargestSmallestAbsoluteLargeSmall() {
		FindLargestSmallest fls = new FindLargestSmallest();
		int[] inArr = {7, 2, 1, 6, 3, 9, Integer.MAX_VALUE, Integer.MIN_VALUE, 5};
		int[] outArr = {Integer.MIN_VALUE, Integer.MAX_VALUE};
		
		assertArrayEquals(outArr, fls.findLargestSmallest(inArr));
	}
	
}
