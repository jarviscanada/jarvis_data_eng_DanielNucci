package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testSwapTwoNumbers {

	@Test
	void testSwapTwoNumbersExample1() {
		SwapTwoNumbers stn = new SwapTwoNumbers();
		int[] testArr = {1, 4};
		
		assertArrayEquals(testArr, stn.swapTwoNumbers(testArr));
	}
	
	@Test
	void testSwapTwoNumbersExample2() {
		SwapTwoNumbers stn = new SwapTwoNumbers();
		int[] testArr = {17, 444};
		
		assertArrayEquals(testArr, stn.swapTwoNumbers(testArr));
	}
}
