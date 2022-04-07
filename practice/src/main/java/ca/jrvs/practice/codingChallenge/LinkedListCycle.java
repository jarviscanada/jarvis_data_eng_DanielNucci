package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode currNode = head;
		
		if (currNode == null) {
			return false;
		}

		Set<ListNode> nodes = new HashSet<ListNode>();
		
		while (currNode.next != null) {
			if (nodes.contains(currNode)) {
				return true;
			}
			nodes.add(currNode);
			currNode = currNode.next;
		}
		
		return false;
	}
}
