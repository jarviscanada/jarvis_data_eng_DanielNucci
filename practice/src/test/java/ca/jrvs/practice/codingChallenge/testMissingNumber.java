package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testMissingNumber {

	@Test
	void testValidParsableIntegerExample1() {
		MissingNumber mn = new MissingNumber();
		int[] testArray = {3, 0, 1};
		
		assertEquals(mn.missingNumber(testArray), 2);
	}
	
	@Test
	void testValidParsableIntegerExample2() {
		MissingNumber mn = new MissingNumber();
		int[] testArray = {0, 1};
		
		assertEquals(mn.missingNumber(testArray), 2);
	}
	
	@Test
	void testValidParsableIntegerExample3() {
		MissingNumber mn = new MissingNumber();
		int[] testArray = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		
		assertEquals(mn.missingNumber(testArray), 8);
	}
}
