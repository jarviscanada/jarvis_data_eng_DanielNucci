package ca.jrvs.practice.codingChallenge;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

/**
 * https://www.notion.so/jarvisdev/Middle-of-the-Linked-List-19ca994fea944d99bf6f699227384d84
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleLinkedList {
	
	/**
	 * O(n + floor(n/2) + 1) or O(n) time complexity algorithm to return the last half of a singly linked list
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		int length = 1;
		ListNode currNode = head;
		while (currNode.next != null) { 
			length++;
			currNode = currNode.next;
		}

		currNode = head; //reset the head and loop till floor(n/2) + 1, where n is the length
		for (int i = 1; i < Math.floor(length / 2) + 1; i++) {
			currNode = currNode.next;
		}
		
		return currNode;
	}
}
