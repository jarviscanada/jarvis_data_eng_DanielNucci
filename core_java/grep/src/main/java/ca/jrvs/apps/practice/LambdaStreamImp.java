package ca.jrvs.apps.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.jrvs.apps.grep.JavaGrep;

public class LambdaStreamImp implements LambdaStreamExc {

	public LambdaStreamImp() {
	}

	@Override
	public Stream<String> createStrStream(String... strings) {
		return Arrays.stream(strings);
	}

	@Override
	public Stream<String> toUpperCase(String... strings) {
		String[] upperStrings = new String[strings.length];
		
		for (int i = 0; i < strings.length; i++) {
			upperStrings[i] = strings[i].toUpperCase();
		}
		return Arrays.stream(upperStrings);
	}

	@Override
	public Stream<String> filter(Stream<String> strStream, String pattern) {
		List<String> filteredStrings = strStream.filter(str -> !str.contains(pattern)).collect(Collectors.toList());
		return filteredStrings.stream();
	}

	@Override
	public IntStream createIntStream(int[] arr) {
		return Arrays.stream(arr);
	}

	@Override
	public <E> List<E> toList(Stream<E> stream) {
		return stream.toList();
	}

	@Override
	public List<Integer> toList(IntStream intStream) {
		return intStream.boxed().collect(Collectors.toList());
	}

	@Override
	public IntStream createIntStream(int start, int end) {
		return IntStream.range(start, end + 1);
	}

	@Override
	public DoubleStream squareRootIntStream(IntStream intStream) {
		return intStream.mapToDouble(num -> Math.sqrt(num));
	}

	@Override
	public IntStream getOdd(IntStream intStream) {
		return intStream.filter(num -> num % 2 == 1);
	}

	@Override
	public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
		Logger log = LoggerFactory.getLogger(LambdaStreamImp.class);
		Consumer<String> printer = str -> log.info(prefix + str + suffix);
		return printer;
	}

	@Override
	public void printMessages(String[] messages, Consumer<String> printer) {
		for (String message: messages) {
			printer.accept(message);
		}
	}

	@Override
	public void printOdd(IntStream intStream, Consumer<String> printer) {
		int[] oddValues = getOdd(intStream).toArray();
		for (int i: oddValues) {
			printer.accept(i+"");
		}
	}

	@Override
	public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
		return ints.flatMap(list -> list.stream()).map(num -> num*num);
		// WIP return ints.map(String::valueOf).map(Integer::parseInt).map(num -> num*num).collect(Collectors.toList()).stream();
	}

}
