package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testRemoveNthNode {

	@Test
	void testRemoveNthNodeExample1() {
		RemoveNthNode rnn = new RemoveNthNode();
		
		ListNode ln15 = new ListNode(5);
		ListNode ln14 = new ListNode(4, ln15);
		ListNode ln13 = new ListNode(3, ln14);
		ListNode ln12 = new ListNode(2, ln13);
		ListNode ln11 = new ListNode(1, ln12);
		
		ListNode ln25 = new ListNode(5);
		ListNode ln23 = new ListNode(3, ln25);
		ListNode ln22 = new ListNode(2, ln23);
		ListNode ln21 = new ListNode(1, ln22);
		
		rnn.removeNthFromEnd(ln11, 2);
		
		ListNode currNode1 = ln11, currNode2 = ln21;
		while (currNode1.next != null && currNode2.next != null) {
			assertTrue(currNode1.val == currNode2.val);
			currNode1 = currNode1.next;
			currNode2 = currNode2.next;
		}
	}
	
	@Test
	void testRemoveNthNodeExample2() {
		RemoveNthNode rnn = new RemoveNthNode();
		
		ListNode ln11 = new ListNode(1);
		
		assertEquals(rnn.removeNthFromEnd(ln11, 1), null);
	}
	
	@Test
	void testRemoveNthNodeExample3() {
		RemoveNthNode rnn = new RemoveNthNode();
		
		ListNode ln12 = new ListNode(2);
		ListNode ln11 = new ListNode(1, ln12);
		
		ListNode ln21 = new ListNode(1);
		
		rnn.removeNthFromEnd(ln11, 1);
		
		ListNode currNode1 = ln11, currNode2 = ln21;
		while (currNode1.next != null && currNode2.next != null) {
			assertTrue(currNode1.val == currNode2.val);
			currNode1 = currNode1.next;
			currNode2 = currNode2.next;
		}
	}
	
	@Test
	void testRemoveNthNodeTest1() {
		RemoveNthNode rnn = new RemoveNthNode();
		
		ListNode ln12 = new ListNode(2);
		ListNode ln11 = new ListNode(1, ln12);
		
		ListNode ln21 = new ListNode(2);
		
		rnn.removeNthFromEnd(ln11, 2);
		
		ListNode currNode1 = ln11, currNode2 = ln21;
		while (currNode1.next != null && currNode2.next != null) {
			assertTrue(currNode1.val == currNode2.val);
			currNode1 = currNode1.next;
			currNode2 = currNode2.next;
		}
	}
}
