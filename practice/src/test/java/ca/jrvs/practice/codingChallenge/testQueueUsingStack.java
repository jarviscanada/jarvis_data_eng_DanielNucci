package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testQueueUsingStack {

	@Test
	void testQueueUsingStackExample1() {
		QueueUsingStack qus = new QueueUsingStack();
		
		qus.push(1);
		qus.push(2);
		assertEquals(1, qus.peek()); // return 2
		assertEquals(1, qus.pop()); // return 2
		assertFalse(qus.empty()); // return false
	}
	
}
