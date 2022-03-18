package ca.jrvs.practice.codingChallenge;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testPrintLetterWithNumber {

	@Test
	void testPrintLetterWithNumberExample1() {
		PrintLetterWithNumber pln = new PrintLetterWithNumber();
		String input = "abcee", output = "a1b2c3e5e5";
		
		
		assertEquals(pln.printLetterWithNumber(input), output);
	}
	
	@Test
	void testPrintLetterWithNumberTestCase1() {
		PrintLetterWithNumber pln = new PrintLetterWithNumber();
		String input = "AbCeE", output = "A27b2C29e5E31";
		
		
		assertEquals(pln.printLetterWithNumber(input), output);
	}
	
	@Test
	void testPrintLetterWithNumberTestCase2() {
		PrintLetterWithNumber pln = new PrintLetterWithNumber();
		String input = "qwertyuiop", output = "q17w23e5r18t20y25u21i9o15p16";
		
		
		assertEquals(pln.printLetterWithNumber(input), output);
	}
	
	@Test
	void testPrintLetterWithNumberTestCase3() {
		PrintLetterWithNumber pln = new PrintLetterWithNumber();
		String input = "zxcvbnm", output = "z26x24c3v22b2n14m13";
		
		
		assertEquals(pln.printLetterWithNumber(input), output);
	}
}
