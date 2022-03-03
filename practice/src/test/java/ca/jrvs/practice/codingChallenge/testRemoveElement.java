package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class testRemoveElement {
	
	@Test
	void testRemoveElementExample1() {
		RemoveElement re = new RemoveElement();
		int[] inArr = {3, 2, 2, 3};
		int[] outArr = {2, 2};
		int value = 3;
		
		int k = re.removeElement(inArr, value), expectedK = 2;
		
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
	void testRemoveElementExample2() {
		RemoveElement re = new RemoveElement();
		int[] inArr = {0, 1, 2, 2, 3, 0, 4, 2};
		int[] outArr = {0, 1, 4, 0, 3};
		int value = 2;
		
		int k = re.removeElement(inArr, value), expectedK = 5;
		
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
