package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class testRemoveDuplicates {

	@Test
	void testRemoveDuplicatesExample1() {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] inArr = {1, 1, 2};
		int[] outArr = {1, 2};
		
		int k = rd.removeDuplicates(inArr), expectedK = 2;
		
		assertEquals(expectedK, k);
		Arrays.sort(inArr, 0, k);
		Arrays.sort(outArr);
		
		for (int i = 0; i < k; i++) {
			if (inArr[i] != outArr[i]) {
				fail();
				return;
			}
		}
		assertTrue(true);
	}
	
	@Test
	void testRemoveDuplicatesExample2() {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] inArr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int[] outArr = {0, 1, 2, 3, 4};
		
		int k = rd.removeDuplicates(inArr), expectedK = 5;
		
		assertEquals(expectedK, k);
		Arrays.sort(inArr, 0, k);
		Arrays.sort(outArr);
		
		for (int i = 0; i < k; i++) {
			if (inArr[i] != outArr[i]) {
				fail();
				return;
			}
		}
		assertTrue(true);
	}
}
