package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.notion.so/jarvisdev/Valid-Anagram-84ebc600b39a42e3b160cb1b312c19ba
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
	
	/**
	 * O(n) algorithm to determine if two strings are anagrams of each other
	 * @param s - string 1
	 * @param t - string 2
	 * @return if the two strings are anagrams
	 */
	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        if (s.length() != t.length()) {
        	return false;
        }
        
        //add all values to the map
        for (char c: s.toCharArray()) {
        	//if it exists add to the number of occurrences in the string
        	if (charMap.containsKey(c)) {
        		charMap.put(c, charMap.get(c) + 1);
        	}
        	else {
        		charMap.put(c, 1);
        	}
        }
        
        //remove all values and return true if all are removed with no extra chars
        for (char c: t.toCharArray()) {
        	if (charMap.containsKey(c)) {
        		if (charMap.get(c) == 1) {
        			charMap.remove(c);
        		}
        		else {
        			charMap.put(c, charMap.get(c) - 1);
        		}
        	}
        	else {
        		return false;
        	}
        }
		
		return true;
    }
}
