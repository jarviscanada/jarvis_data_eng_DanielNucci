package ca.jrvs.apps.grep;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaGrepLambdaImp extends JavaGrepImp {

final Logger log = LoggerFactory.getLogger(JavaGrep.class);
	
	public static void main(String[] args) {
		if (args.length != 3) {
			throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
		}
		
		JavaGrepImp javaGrepLambdaImp = new JavaGrepLambdaImp(args[0], args[1], args[2]);
		
		try {
			javaGrepLambdaImp.process();
		} catch (Exception e) {
			javaGrepLambdaImp.log.error("Error: Unable to excecute javaGrepImp.process()", e);
		}
	}
	
	public JavaGrepLambdaImp() {}

	public JavaGrepLambdaImp(String regex, String rootPath, String outFile) {
		super(regex, rootPath, outFile);
	}
	
	// Implemented using Streams and Lambda functions
	@Override
	public List<String> readLines(File inputFile) throws IllegalArgumentException {
		try {
			return Files.lines(new File(inputFile.toString()).toPath()).map(line -> line.trim()).filter(line -> !line.isEmpty()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new IllegalArgumentException("Error while reading files: " + e);
		}
	}
	
	// Implemented using Streams and Lambda functions
	@Override
	public List<File> listFiles(String rootDir) {
		try (Stream<Path> files = Files.list(Paths.get(rootDir))) {
			return files.filter(file -> Files.isRegularFile(file)).map(Path::toFile).collect(Collectors.toList());

		} catch (Exception e) {
			this.log.error("Error while listing files: " + e);
		}
		return (List<File>) new ArrayList<File>();
	}
}
