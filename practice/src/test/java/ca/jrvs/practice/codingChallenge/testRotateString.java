package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testRotateString {

	@Test
	void testRotateStringExample1() {
		RotateString rs = new RotateString();
		
		assertTrue(rs.rotateString("abcde", "cdeab"));
	}
	
	@Test
	void testRotateStringExample2() {
		RotateString rs = new RotateString();
		
		assertFalse(rs.rotateString("abcde", "abced"));
	}
}
