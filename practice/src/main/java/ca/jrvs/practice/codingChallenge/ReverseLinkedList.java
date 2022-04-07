package ca.jrvs.practice.codingChallenge;

/*class ListNode {
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
*/

public class ReverseLinkedList {
	
	private ListNode tail = null;

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		recursiveReverse(head);
		head.next = null;
		
		return tail;
	}
	
	private ListNode recursiveReverse(ListNode currNode) {
		if (currNode.next != null) {
			ListNode swap = recursiveReverse(currNode.next);
			swap.next = currNode;
			return currNode;
		}
		else {
			tail = currNode;
			return currNode;
		}
	}
}
