package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testValidParsableInteger {
	
	@Test
	void testValidParsableIntegerExample1() {
		ValidParsableInteger vpi = new ValidParsableInteger();
		
		assertTrue(vpi.isValidParsableInt("1000"));
	}
	
	@Test
	void testValidParsableIntegerExample2() {
		ValidParsableInteger vpi = new ValidParsableInteger();
		
		assertFalse(vpi.isValidParsableInt(",1000"));
	}

	@Test
	void testValidParsableIntegerExample3() {
		ValidParsableInteger vpi = new ValidParsableInteger();
		
		assertFalse(vpi.isValidParsableInt("XXXX"));
	}
	
	@Test
	void testValidParsableIntegerExample4() {
		ValidParsableInteger vpi = new ValidParsableInteger();
		
		assertTrue(vpi.isValidParsableInt("1234567890"));
	}
}
