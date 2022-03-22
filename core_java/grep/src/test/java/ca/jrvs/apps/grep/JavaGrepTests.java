package ca.jrvs.apps.grep;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

class JavaGrepTests {

	// Tests regarding listFiles()
	@Test
	void testListFilesMatch() {
		JavaGrepImp jgi = new JavaGrepImp();
		List<String> compareList = Arrays.asList("shakespeare.txt", "test.txt");
		List<File> generatedList = jgi.listFiles("./data/txt");
		
		compareList.sort(Comparator.naturalOrder());
		generatedList.sort(Comparator.naturalOrder());
		
		boolean result = false;
		
		if (compareList.size() == generatedList.size()) {
			for (int i = 0; i < compareList.size(); i++) {
				if (compareList.get(i).equals(generatedList.get(i).getName())) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}

	@Test
	void testListFilesMatch2ndLayer() {
		JavaGrepImp jgi = new JavaGrepImp();
		List<String> compareList = Arrays.asList("shakespeare.txt", "test.txt");
		List<File> generatedList = jgi.listFiles("./data");
		
		compareList.sort(Comparator.naturalOrder());
		generatedList.sort(Comparator.naturalOrder());
		
		boolean result = false;
		
		if (compareList.size() == generatedList.size()) {
			for (int i = 0; i < compareList.size(); i++) {
				if (compareList.get(i).equals(generatedList.get(i).getName())) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}
	
	// Tests regarding readLines()
	@Test
	void testReadLinesMatch() {
		JavaGrepImp jgi = new JavaGrepImp();
		List<String> compareList = Arrays.asList("Test file", "Line two", "Line three");
		List<String> generatedList = jgi.readLines(new File ("./data/txt/test.txt")); //coverage for leading and trailing newlines, tabs and spaces
		
		boolean result = false;
		
		if (compareList.size() == generatedList.size()) {
			for (int i = 0; i < compareList.size(); i++) {
				if (compareList.get(i).equals(generatedList.get(i))) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}
	
	// Tests regarding containsPattern()
	@Test
	void testContainsPatternMatch() {
		JavaGrepImp jgi = new JavaGrepImp();
		jgi.setRegex(".*Romeo.*Juliet.*");
		
		boolean result = jgi.containsPattern("Romeo, there dead, was husband to that Juliet");
		
		assertTrue(result);
	}
	
	@Test
	void testContainsPatternFailure() {
		JavaGrepImp jgi = new JavaGrepImp();
		jgi.setRegex("^([0-9]{1,3}[\\\\.]){3}[0-9]{1,3}$");
		
		boolean result = jgi.containsPattern("00.1.449.999.");
		
		assertFalse(result);
	}
	
	// Tests regarding writeToFile() (dependent on readlines() for assertions)
	void testWriteToFile() {
		JavaGrepImp jgi = new JavaGrepImp();
		jgi.setRootPath("./out/testOut.txt");
		List<String> compareList = Arrays.asList("Test file		", "Line two  ", "Line three");
		try {
			jgi.writeToFile(compareList);
		} catch (IOException e) {
			fail(e);
		}
		
		List<String> generatedList = jgi.readLines(new File (jgi.getRootPath())); //coverage for leading and trailing newlines, tabs and spaces
		
		boolean result = false;
		
		if (compareList.size() == generatedList.size()) {
			for (int i = 0; i < compareList.size(); i++) {
				if (compareList.get(i).equals(generatedList.get(i))) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}
	
	// Tests regarding lambda listFiles()
	@Test
	void testLambdaListFilesMatch() {
		JavaGrepLambdaImp jgli = new JavaGrepLambdaImp();
		List<String> compareList = Arrays.asList("shakespeare.txt", "test.txt");
		List<File> generatedList = jgli.listFiles("./data/txt");
		
		compareList.sort(Comparator.naturalOrder());
		generatedList.sort(Comparator.naturalOrder());
		
		boolean result = false;
		
		if (compareList.size() == generatedList.size()) {
			for (int i = 0; i < compareList.size(); i++) {
				if (compareList.get(i).equals(generatedList.get(i).getName())) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}
	
	// Tests regarding lambda readLines()
	@Test
	void testLambdaReadLinesMatch() {
		JavaGrepLambdaImp jgli = new JavaGrepLambdaImp();
		List<String> compareList = Arrays.asList("Test file", "Line two", "Line three");
		List<String> generatedList = jgli.readLines(new File ("./data/txt/test.txt")); //coverage for leading and trailing newlines, tabs and spaces
		
		boolean result = false;
		
		if (compareList.size() == generatedList.size()) {
			for (int i = 0; i < compareList.size(); i++) {
				if (compareList.get(i).equals(generatedList.get(i))) {
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		assertTrue(result);
	}
}
