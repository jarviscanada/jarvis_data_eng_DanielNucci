package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testVaildParentheses {

	@Test
	void testVaildParethesesExample1() {
		ValidParentheses vp = new ValidParentheses();
		
		assertTrue(vp.isValid("()"));
	}
	
	@Test
	void testVaildParethesesExample2() {
		ValidParentheses vp = new ValidParentheses();
		
		assertTrue(vp.isValid("(){}[]"));
	}
	
	@Test
	void testVaildParethesesExample3() {
		ValidParentheses vp = new ValidParentheses();
		
		assertFalse(vp.isValid("(]"));
	}
	
}
