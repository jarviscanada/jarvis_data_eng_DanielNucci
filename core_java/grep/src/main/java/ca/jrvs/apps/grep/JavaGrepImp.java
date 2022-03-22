package ca.jrvs.apps.grep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaGrepImp implements JavaGrep {
	
	final Logger log = LoggerFactory.getLogger(JavaGrep.class);
	
	private String regex;
	private String rootPath;
	private String outFile;

	public static void main(String[] args) {
		if (args.length != 3) {
			throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
		}
		
		JavaGrepImp javaGrepImp = new JavaGrepImp(args[0], args[1], args[2]);
		
		try {
			javaGrepImp.process();
		} catch (Exception e) {
			javaGrepImp.log.error("Error: Unable to excecute javaGrepImp.process()", e);
		}
	}
	
	public JavaGrepImp() {}
	
	public JavaGrepImp(String regex, String rootPath, String outFile) {
		this.setRegex(regex);
		this.setRootPath(rootPath);
		this.setOutFile(outFile);
	}

	@Override
	public void process() throws IOException {
		ArrayList<String> matchedLines = new ArrayList<String>();
		List<File> allFiles = listFiles(getRootPath());
		
		for (File file: allFiles) {
			List<String> fileLines = readLines(file);
			
			for (String line: fileLines) {
				if (containsPattern(line)) {
					matchedLines.add(line);
				}
			}
		}
		writeToFile(matchedLines);
	}

	@Override
	public List<File> listFiles(String rootDir) {
		List<File> allFiles = new ArrayList<File>();
		File[] directoriesAndFiles = new File(rootDir).listFiles();
		
		for (File file: directoriesAndFiles) {
			if (file.isFile()) {
				allFiles.add(file);
			}
			else if (file.isDirectory()) {
				File[] oneLayerDeepFiles = new File(file.getAbsolutePath()).listFiles();
				for (File layerOneFile: oneLayerDeepFiles) {
					if (layerOneFile.isFile()) {
						allFiles.add(layerOneFile);
					}
				}
			}
		}
		
		return allFiles;
	}

	@Override
	public List<String> readLines(File inputFile) throws IllegalArgumentException {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("USAGE: outFile must be a file");
		}
		
		List<String> returnLines = new ArrayList<String>();
		String line;
		
		// loop through the lines and add them to the output array
		try {
			while ((line=br.readLine()) != null) {
				if (!line.equals("")) {
					returnLines.add(line.trim());
				}
			}
			br.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("USAGE: outFile must be readable");
		}
		
		return returnLines;
	}

	@Override
	public boolean containsPattern(String line) {
		return Pattern.matches(getRegex(), line);
	}

	@Override
	public void writeToFile(List<String> lines) throws IOException {
		File outputFile = new File(getOutFile());
		Path path = Paths.get(outputFile.getPath());
		
		
		try {
			BufferedWriter bw;
			if (outputFile.exists()) {
				bw = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING);
			}
			else {
				bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE);
			}
			for (String line: lines) {
				bw.write(line.trim());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			log.error("Error writing to file: " + e);
		}
		
	}
	
	//GETTERS AND SETTERS

	@Override
	public String getRootPath() {
		return this.rootPath;
	}

	@Override
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	@Override
	public String getRegex() {
		return this.regex;
	}

	@Override
	public void setRegex(String regex) {
		this.regex = regex;
	}

	@Override
	public String getOutFile() {
		return this.outFile;
	}

	@Override
	public void setOutFile(String outFile) {
		this.outFile = outFile;
	}

}
