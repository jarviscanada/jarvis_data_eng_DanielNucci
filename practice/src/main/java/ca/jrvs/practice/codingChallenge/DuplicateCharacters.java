package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.notion.so/jarvisdev/Duplicate-Characters-68c65f8e39144bc980d747f1b35ab22d
 * Online Judge N/A
 */
public class DuplicateCharacters {

	/**
	 * O(n) time complexity algorithm to find all duplicate characters in a given string
	 * @param s
	 * @return the duplicate characters
	 */
	public char[] duplicateCharacters(String s) {
		Set<Character> charSet = new HashSet<Character>();
		List<Character> returnList = new ArrayList<Character>();
		
		for (char c: s.toCharArray()) {
			if (!charSet.contains(c)) {
				charSet.add(c);
			}
			else {
				returnList.add(c);
			}
		}
		
		char[] returnArr = new char[returnList.size()];
		for (int i = 0; i < returnList.size(); i++) {
			returnArr[i] = returnList.get(i);
		}
		
		return returnArr;
	}
}
