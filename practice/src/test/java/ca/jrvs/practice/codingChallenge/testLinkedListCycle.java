package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testLinkedListCycle {

	@Test
	void testLinkedListCycleExample1() {
		LinkedListCycle llc = new LinkedListCycle();
		
		ListNode ln4 = new ListNode(-4);
		ListNode ln3 = new ListNode(0, ln4);
		ListNode ln2 = new ListNode(2, ln3);
		ListNode ln1 = new ListNode(3, ln2);
		ln4.next = ln2;
		
		assertTrue(llc.hasCycle(ln1));
	}
	
	@Test
	void testLinkedListCycleExample2() {
		LinkedListCycle llc = new LinkedListCycle();
		
		ListNode ln2 = new ListNode(2);
		ListNode ln1 = new ListNode(1, ln2);
		ln2.next = ln1;
		
		assertTrue(llc.hasCycle(ln1));
	}
	
	@Test
	void testLinkedListCycleExample3() {
		LinkedListCycle llc = new LinkedListCycle();
		
		ListNode ln1 = new ListNode(1);
		
		assertFalse(llc.hasCycle(ln1));
	}
	
	@Test
	void testLinkedListCycleTest1() {
		LinkedListCycle llc = new LinkedListCycle();
		
		ListNode ln1 = null;
		
		assertFalse(llc.hasCycle(ln1));
	}
}
