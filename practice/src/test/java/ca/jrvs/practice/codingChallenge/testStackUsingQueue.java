package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testStackUsingQueue {
	
	@Test
	void testStackUsingQueueExample1() {
		StackUsingQueue suq = new StackUsingQueue();
		
		suq.push(1);
		suq.push(2);
		assertEquals(2, suq.top()); // return 2
		assertEquals(2, suq.pop()); // return 2
		assertFalse(suq.empty()); // return false
	}

}
