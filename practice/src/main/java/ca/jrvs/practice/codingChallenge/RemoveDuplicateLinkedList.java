package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://www.notion.so/jarvisdev/Duplicate-LinkedList-Node-bf11eb84d50a4ad7a722a28de95d729a
 * Online Judge N/A
 */
public class RemoveDuplicateLinkedList {

	/**
	 * O(n+m) time complexity implementation to remove repeat elements from a linked list (where n is array length and m is number of duplicates). Not-in-place algorithm
	 * @param ll
	 */
	public void removeDupNodes(LinkedList<Integer> ll) {
		Set<Integer> allValues = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<Integer>();
		
		for (Integer i: ll) {
			if (allValues.contains(i)) {
				duplicates.add(i);
			}
			else {
				allValues.add(i);
			}
		}
		
		for (Integer del: duplicates) {
			ll.removeFirstOccurrence(del);
		}
	}
}
