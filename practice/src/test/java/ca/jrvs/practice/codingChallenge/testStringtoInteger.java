package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testStringtoInteger {

	@Test
	void testStringtoIntegerExample1() {
		StringtoInteger stn = new StringtoInteger();
		String s = "42";
		int compInt = 42;
		
		assertEquals(stn.myAtoi(s), compInt);
	}
	
	@Test
	void testStringtoIntegerExample2() {
		StringtoInteger stn = new StringtoInteger();
		String s = "   -42";
		int compInt = -42;
		
		assertEquals(stn.myAtoi(s), compInt);
	}
	
	@Test
	void testStringtoIntegerExample3() {
		StringtoInteger stn = new StringtoInteger();
		String s = "4193 with words";
		int compInt = 4193;
		
		assertEquals(stn.myAtoi(s), compInt);
	}
}
