package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class testEvenOrOdd {
	
	@Test
	void testEvenOrOddExample1() {
		EvenOrOdd eoo = new EvenOrOdd();
		int input = 2;
		String output = "even";
		
		assertEquals(eoo.evenOrOdd(input), output);
	}
	
	@Test
	void testEvenOrOddExample2() {
		EvenOrOdd eoo = new EvenOrOdd();
		int input = 1;
		String output = "odd";
		
		assertEquals(eoo.evenOrOdd(input), output);
	}
	
	@Test
	void testEvenOrOddExample3() {
		EvenOrOdd eoo = new EvenOrOdd();
		int input = 1007;
		String output = "odd";
		
		assertEquals(eoo.evenOrOdd(input), output);
	}

}
