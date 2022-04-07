package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testFibonacciNumbers {
	
	@Test
	void testFibonacciNumbersExample1() {
		FibonacciNumbers fn = new FibonacciNumbers();
		int input = 2;
		int output = 1;
		
		assertEquals(fn.fib(input), output);
	}
	
	@Test
	void testFibonacciNumbersExample2() {
		FibonacciNumbers fn = new FibonacciNumbers();
		int input = 3;
		int output = 2;
		
		assertEquals(fn.fib(input), output);
	}
	
	@Test
	void testFibonacciNumbersExample3() {
		FibonacciNumbers fn = new FibonacciNumbers();
		int input = 4;
		int output = 3;
		
		assertEquals(fn.fib(input), output);
	}
}
