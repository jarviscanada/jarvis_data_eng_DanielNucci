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

/**
 * https://www.notion.so/jarvisdev/Nth-Node-From-End-of-LinkedList-2d50aabb37104a9aa63b0f5d30b86d66
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNode {

	/**
	 * O(m + (m - n)) or O(n) time complexity algorithm to remove the nth node from a singly linked list (where m is the length and n is the node index)
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 1;
		ListNode currNode = head;
		while (currNode.next != null) { 
			length++;
			currNode = currNode.next;
		}
		
		if (length <= 1) {
			return null; 
		}
		
		currNode = head;
		for (int i = 1; i < length - n; i++) {
			currNode = currNode.next;
		}
		
		ListNode backupNode = currNode.next;
		currNode.next = currNode.next.next;
		
		return length != n ? head : backupNode;
	}
}
