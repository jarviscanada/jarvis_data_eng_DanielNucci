package ca.jrvs.apps.practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class LambdaStreamTests {

	// Tests regarding createStrStream
	@Test
	void testCreateStrStreamMatch() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<String> compareList = Arrays.asList("Hello, ", "World", "!");
		List<String> generatedList = lsi.createStrStream("Hello, ", "World", "!").toList();
		
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
	
	@Test
	void testCreateStrStreamFailToMatch() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<String> compareList = Arrays.asList("Hello, ", "Universe", "!");
		List<String> generatedList = lsi.createStrStream("Hello, ", "World", "!").toList();
		
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
		assertFalse(result);
	}
	
	@Test
	void testCreateStrStreamFailLength() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<String> compareList = Arrays.asList("Hello, ", "World!");
		List<String> generatedList = lsi.createStrStream("Hello, ", "World", "!").toList();
		
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
		assertFalse(result);
	}
	
	// Tests regarding toUpperCase
	@Test
	void testToUpperCaseMatch() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<String> compareList = Arrays.asList("HELLO, ", "WORLD", "!");
		List<String> generatedList = lsi.toUpperCase("Hello, ", "World", "!").toList();
		
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
	
	@Test
	void testToUpperCaseFailToMatch() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<String> compareList = Arrays.asList("HELLO, ", "WORLd", "!");
		List<String> generatedList = lsi.toUpperCase("Hello, ", "World", "!").toList();
		
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
		assertFalse(result);
	}

	@Test
	void testToUpperCaseFailLength() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<String> compareList = Arrays.asList("HELLO, ", "WORLD!");
		List<String> generatedList = lsi.toUpperCase("Hello, ", "World", "!").toList();
		
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
		assertFalse(result);
	}

	// Tests regarding filter
	@Test
	void testFilterMatchOne() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		Stream<String> compareStream = Arrays.asList("World", "!").stream();
		Stream<String> generatedStream = lsi.filter(Arrays.asList("Hello, ", "World", "!").stream(), ",");
		
		List<String> compareList = compareStream.toList();
		List<String> generatedList = generatedStream.toList();
		
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

	@Test
	void testFilterMatchMultiple() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		Stream<String> compareStream = Arrays.asList("test").stream();
		Stream<String> generatedStream = lsi.filter(Arrays.asList("Hello!", "test" , "World!", "!").stream(), "!");
		
		List<String> compareList = compareStream.toList();
		List<String> generatedList = generatedStream.toList();
		
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
	
	@Test
	void testFilterNoMatches() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		Stream<String> compareStream = Arrays.asList("Hello!", "test" , "World!", "!").stream();
		Stream<String> generatedStream = lsi.filter(Arrays.asList("Hello!", "test" , "World!", "!").stream(), "0");
		
		List<String> compareList = compareStream.toList();
		List<String> generatedList = generatedStream.toList();
		
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
	
	@Test
	void testFilterFalse() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		Stream<String> compareStream = Arrays.asList("Hello!", "test" , "World!").stream();
		Stream<String> generatedStream = lsi.filter(Arrays.asList("Hello!", "test" , "World!", "!").stream(), "0");
		
		List<String> compareList = compareStream.toList();
		List<String> generatedList = generatedStream.toList();
		
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
		assertFalse(result);
	}
	
	// Tests regarding createIntStream
	
	
	// Tests regarding toList<E>
	
	
	// Tests regarding toList<Interger>
	
	
	// Tests regarding createIntStream
	
	
	// Tests regarding squareRootIntStream
	
	
	// Tests regarding getOdd
	
	
	// Tests regarding getLambdaPrinter
	@Test
	void testGetLambdaPrinter() {
		LambdaStreamExc lsi = new LambdaStreamImp(); 
		Consumer<String> printer = lsi.getLambdaPrinter("start>", "<end"); 
		printer.accept("Message body");
	}
	
	// Tests regarding printMessages
	
	
	// Tests regarding printOdd
	@Test
	void testprintMessages() {
		LambdaStreamExc lsi = new LambdaStreamImp(); 
		lsi.printOdd(lsi.createIntStream(0, 5), lsi.getLambdaPrinter("odd number:", "!"));
	}
	
	// Tests regarding flatNestedInt
	@Test
	void testFlatNestedIntMatch() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<Integer> testInts = Arrays.asList(1, 2);
		List<List<Integer>> fullList = Arrays.asList(testInts, testInts);
		Object[] testArray = {1, 4, 1, 4};
		assertArrayEquals(lsi.flatNestedInt(fullList.stream()).toArray(), testArray);
	}
	
	@Test
	void testFlatNestedIntLongMatch() {
		LambdaStreamExc lsi = new LambdaStreamImp();
		List<Integer> testInts = Arrays.asList(1, 2, 3);
		List<List<Integer>> fullList = Arrays.asList(testInts, testInts, testInts);
		Object[] testArray = {1, 4, 9, 1, 4, 9, 1, 4, 9};
		assertArrayEquals(lsi.flatNestedInt(fullList.stream()).toArray(), testArray);
	}

}
