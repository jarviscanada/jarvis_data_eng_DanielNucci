package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testTwoSum {
	
	@Test
	void testTwoSumExample1() {
		TwoSum ts = new TwoSum();
		int[] inArr = {2, 7, 11, 15};
		int[] outArr = {0, 1};
		int target = 9;
		
		assertArrayEquals(outArr, ts.twoSum(inArr, target));
	}
	
	@Test
	void testTwoSumExample2() {
		TwoSum ts = new TwoSum();
		int[] inArr = {3, 2, 4};
		int[] outArr = {1, 2};
		int target = 6;
		
		assertArrayEquals(outArr, ts.twoSum(inArr, target));
	}
	
	@Test
	void testTwoSumExample3() {
		TwoSum ts = new TwoSum();
		int[] inArr = {3, 3};
		int[] outArr = {0, 1};
		int target = 6;
		
		assertArrayEquals(outArr, ts.twoSum(inArr, target));
	}
}
