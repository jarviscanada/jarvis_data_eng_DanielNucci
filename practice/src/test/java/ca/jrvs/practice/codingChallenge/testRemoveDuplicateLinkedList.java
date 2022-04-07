package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class testRemoveDuplicateLinkedList {

	@Test
	void testRemoveDuplicateLinkedListExample1() {
		RemoveDuplicateLinkedList rdll = new RemoveDuplicateLinkedList();
		
		LinkedList<Integer> withDupes = new LinkedList<Integer>();
		LinkedList<Integer> noDupes = new LinkedList<Integer>();
		
		withDupes.add(3);
		withDupes.add(1);
		withDupes.add(2);
		withDupes.add(4);
		withDupes.add(1);
		withDupes.add(5);
		withDupes.add(2);
		
		noDupes.add(3);
		noDupes.add(4);
		noDupes.add(1);
		noDupes.add(5);
		noDupes.add(2);
		
		rdll.removeDupNodes(withDupes);
		
		assertTrue(withDupes.equals(noDupes));
	}
}
