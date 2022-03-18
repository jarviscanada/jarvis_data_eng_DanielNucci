package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testContainsDuplicate {
	
	@Test
	void testDuplicateNumberExample1() {
		ContainsDuplicate cd = new ContainsDuplicate();
		int[] nums = {1, 2, 3, 1};
		boolean containsDuplicate = cd.containsDuplicate(nums);
		
		assertTrue(containsDuplicate);
	}
	
	@Test
	void testDuplicateNumberExample2() {
		ContainsDuplicate cd = new ContainsDuplicate();
		int[] nums = {1, 2, 3, 4};
		boolean containsDuplicate = cd.containsDuplicate(nums);
		
		assertFalse(containsDuplicate);
	}
	
	@Test
	void testDuplicateNumberExample3() {
		ContainsDuplicate cd = new ContainsDuplicate();
		int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
		boolean containsDuplicate = cd.containsDuplicate(nums);
		
		assertTrue(containsDuplicate);
	}
}
