package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class testCountingPrimes {

	@Test
	void testPrimesExample1() {
		CountPrimes cp = new CountPrimes();
		
		assertEquals(cp.countPrimes(10), 4);
	}
	
	@Test
	void testPrimesExample2() {
		CountPrimes cp = new CountPrimes();
		
		assertEquals(cp.countPrimes(0), 0);
	}
	
	@Test
	void testPrimesExample3() {
		CountPrimes cp = new CountPrimes();
		
		assertEquals(cp.countPrimes(1), 0);
	}
	
	@Test
	void testPrimesBigNumber() {
		CountPrimes cp = new CountPrimes();
		
		assertEquals(cp.countPrimes(100), 25);
	}
	
}
