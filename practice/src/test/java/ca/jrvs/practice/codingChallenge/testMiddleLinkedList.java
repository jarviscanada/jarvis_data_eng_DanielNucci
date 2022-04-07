package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testMiddleLinkedList {
	
	@Test
	void testMiddleLinkedListExample1() {
		MiddleLinkedList mll = new MiddleLinkedList();
		
		ListNode ln5 = new ListNode(5);
		ListNode ln4 = new ListNode(4, ln5);
		ListNode ln3 = new ListNode(3, ln4);
		ListNode ln2 = new ListNode(2, ln3);
		ListNode ln1 = new ListNode(1, ln2);
		
		assertTrue(mll.middleNode(ln1).equals(ln3));
	}

	@Test
	void testMiddleLinkedListExample2() {
		MiddleLinkedList mll = new MiddleLinkedList();
		
		ListNode ln6 = new ListNode(5);
		ListNode ln5 = new ListNode(5, ln6);
		ListNode ln4 = new ListNode(4, ln5);
		ListNode ln3 = new ListNode(3, ln4);
		ListNode ln2 = new ListNode(2, ln3);
		ListNode ln1 = new ListNode(1, ln2);
		
		assertTrue(mll.middleNode(ln1).equals(ln4));
	}
}
