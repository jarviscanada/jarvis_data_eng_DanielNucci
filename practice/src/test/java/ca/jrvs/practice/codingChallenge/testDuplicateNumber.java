package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testDuplicateNumber {

	@Test
	void testDuplicateNumberExample1() {
		DuplicateNumber dn = new DuplicateNumber();
		int[] nums = {1, 3, 4, 2, 2};
		int compInt = 2;
		
		assertEquals(dn.findDuplicate(nums), compInt);
	}
	
	@Test
	void testDuplicateNumberExample2() {
		DuplicateNumber dn = new DuplicateNumber();
		int[] nums = {3,1,3,4,2};
		int compInt = 3;
		
		assertEquals(dn.findDuplicate(nums), compInt);
	}
	
}
