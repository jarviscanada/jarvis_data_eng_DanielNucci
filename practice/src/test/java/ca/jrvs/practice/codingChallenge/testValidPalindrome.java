package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testValidPalindrome {

	@Test
	void testPalindromeExample1() {
		ValidPalindrome vp = new ValidPalindrome();
		
		assertTrue(vp.isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	@Test
	void testPalindromeExample2() {
		ValidPalindrome vp = new ValidPalindrome();
		
		assertFalse(vp.isPalindrome("race a car"));
	}
	
	@Test
	void testPalindromeExample3() {
		ValidPalindrome vp = new ValidPalindrome();
		
		assertTrue(vp.isPalindrome(" "));
	}
}
