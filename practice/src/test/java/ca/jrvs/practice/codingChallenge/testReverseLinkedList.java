package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testReverseLinkedList {

	@Test
	void testReverseLinkedListExample1() {
		ReverseLinkedList rll = new ReverseLinkedList();
		
		ListNode ln15 = new ListNode(5);
		ListNode ln14 = new ListNode(4, ln15);
		ListNode ln13 = new ListNode(3, ln14);
		ListNode ln12 = new ListNode(2, ln13);
		ListNode ln11 = new ListNode(1, ln12);
		
		ListNode ln25 = new ListNode(1);
		ListNode ln24 = new ListNode(2, ln25);
		ListNode ln23 = new ListNode(3, ln24);
		ListNode ln22 = new ListNode(4, ln23);
		ListNode ln21 = new ListNode(5, ln22);
		
		rll.reverseList(ln11);
		
		ListNode currNode1 = ln11, currNode2 = ln21;
		while (currNode1.next != null && currNode2.next != null) {
			assertTrue(currNode1.val == currNode2.val);
			currNode1 = currNode1.next;
			currNode2 = currNode2.next;
		}
	}
	
	@Test
	void testReverseLinkedListExample2() {
		ReverseLinkedList rll = new ReverseLinkedList();
		
		ListNode ln12 = new ListNode(2);
		ListNode ln11 = new ListNode(1, ln12);
		
		ListNode ln22 = new ListNode(1);
		ListNode ln21 = new ListNode(2, ln22);
		
		rll.reverseList(ln11);
		
		ListNode currNode1 = ln11, currNode2 = ln21;
		while (currNode1.next != null && currNode2.next != null) {
			assertTrue(currNode1.val == currNode2.val);
			currNode1 = currNode1.next;
			currNode2 = currNode2.next;
		}
	}
}
