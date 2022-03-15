package ca.jrvs.apps.practice;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface LambdaStreamExc {
	
	/**
	 * Create a String stream from an array (Arbitrary number of values will be stored)
	 * 
	 * @param strings
	 * @return Stream<String>
	 */
	Stream<String> createStrStream(String... strings);
	
	/**
	 * Convert all strings to uppercase (By use of createStrStream)
	 * 
	 * @param strings
	 * @return Stream<String>
	 */
	Stream<String> toUpperCase(String... strings);
	
	/**
	 * Filter strings that contains pattern (remove all strings that match pattern from the stream)
	 * 
	 * @param strStream
	 * @param pattern
	 * @return Stream<String>
	 */
	Stream<String> filter(Stream<String> strStream, String pattern);
	
	/**
	 * Create an intStream from an integer arr[]
	 * 
	 * @param arr
	 * @return IntStream
	 */
	IntStream createIntStream(int[] arr);
	
	/**
	 * Convert stream to a list
	 * 
	 * @param <E>
	 * @param stream
	 * @return List<E>
	 */
	<E> List<E> toList(Stream<E> stream);
	
	/**
	 * Convert IntSteam to list
	 * 
	 * @param intStream
	 * @return List<Integer>
	 */
	List<Integer> toList(IntStream intStream);
	
	/**
	 * Create an IntStream range from start to end inclusive
	 * 
	 * @param start
	 * @param end
	 * @return IntStream
	 */
	IntStream createIntStream(int start, int end);
	
	/**
	 * Convert an intStream to a doubleStream and compute the square root of each element
	 * 
	 * @param intStream
	 * @return DoubleStream
	 */
	DoubleStream squareRootIntStream(IntStream intStream);
	
	/**
	 * Filter out all even numbers and return odd numbers from an intStream
	 * 
	 * @param intStream
	 * @return IntStream
	 */
	IntStream getOdd(IntStream intStream);
	
	/**
	 * Return a lambda function that prints a message with a prefix and suffix
	 *
	 * e.g.
	 * LambdaStreamExc lse = new LambdaStreamImp();
	 * Consumer<String> printer = lse.getLambdaPrinter("start", "end");
     * printer.accept("Message body");
     * 
	 * @param prefix
	 * @param suffix
	 * @return Consumer<String>
	 */
	Consumer<String> getLambdaPrinter(String prefix, String suffix);
	
	/**
	 * Print each message with a given printer (Uses the getLambdaPrinter method)
	 * 
	 * e.g.
     * String[] messages = {"a", "b", "c"};
     * lse.printMessages(messages, lse.getLambdaPrinter("msg:", "!") );
	 * 
	 * @param messages
	 * @param printer
	 */
	void printMessages(String[] messages, Consumer<String> printer);
	
	/**
	 * Print all odd numbers from an intStream (Uses createIntStream and getLambdaPrinter methods)
	 * 
	 * e.g.
     * lse.printOdd(lse.createIntStream(0, 5), lse.getLambdaPrinter("odd number:", "!"));
     *
	 * @param intStream
	 * @param printer
	 */
	void printOdd(IntStream intStream, Consumer<String> printer);
	
	/**
	 * Square each number from the input (implemented in two ways, one using flatMap)
	 * 
	 * @param ints
	 * @return Stream<Integer>
	 */
	Stream<Integer> flatNestedInt(Stream<List<Integer>> ints);
}
