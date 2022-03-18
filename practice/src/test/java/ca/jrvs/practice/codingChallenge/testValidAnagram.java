package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testValidAnagram {
	
	@Test
	void testValidAnagramExample1() {
		ValidAnagram va = new ValidAnagram();
		String s = "anagram", t = "nagaram";
		
		assertTrue(va.isAnagram(s, t));
	}
	
	@Test
	void testValidAnagramExample2() {
		ValidAnagram va = new ValidAnagram();
		String s = "rat", t = "car";
		
		assertFalse(va.isAnagram(s, t));
	}
	
	@Test
	void testValidAnagramTestCase1() {
		ValidAnagram va = new ValidAnagram();
		String s = "aacc", t = "ccac";
		
		assertFalse(va.isAnagram(s, t));
	}
	
	@Test
	void testValidAnagramTestCase2() {
		ValidAnagram va = new ValidAnagram();
		String s = "middle", t = "ddimle";
		
		assertTrue(va.isAnagram(s, t));
	}
}
