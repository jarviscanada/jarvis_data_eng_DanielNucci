package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class testDuplicateCharacters {

	@Test
	void testDuplicateCharactersExample1() {
		DuplicateCharacters dc = new DuplicateCharacters();
		String testString = "A black cat";
		
		char[] testArray = {' ', 'a', 'c'};
		char[] generatedArray = dc.duplicateCharacters(testString);
		
		Arrays.sort(testArray);
		Arrays.sort(generatedArray);
		
		assertArrayEquals(generatedArray, testArray);
	}
	
	@Test
	void testDuplicateCharactersExample2() {
		DuplicateCharacters dc = new DuplicateCharacters();
		String testString = "racecar";
		
		char[] testArray = {'r', 'a', 'c'};
		char[] generatedArray = dc.duplicateCharacters(testString);
		
		Arrays.sort(testArray);
		Arrays.sort(generatedArray);
		
		assertArrayEquals(generatedArray, testArray);
	}
	
	@Test
	void testDuplicateCharactersExample3() {
		DuplicateCharacters dc = new DuplicateCharacters();
		String testString = "thequickbrown";
		
		char[] testArray = {};
		char[] generatedArray = dc.duplicateCharacters(testString);
		
		Arrays.sort(testArray);
		Arrays.sort(generatedArray);
		
		assertArrayEquals(generatedArray, testArray);
	}
}
