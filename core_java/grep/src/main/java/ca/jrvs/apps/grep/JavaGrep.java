package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {

	/**
	 * Top level search workflow
	 * 
	 * @throws IOException
	 */
	void process() throws IOException;
	
	/**
	 * Traverse a given directory and return all files
	 * 
	 * @param rootDir input directory
	 * @return files under the rootDir
	 */
	List<File> listFiles(String rootDir);
	
	/**
	 * Read a file and return all of the contained lines
	 * 
	 * @param inputFile file to be read
	 * @return lines from within the file
	 * @throws IllegalArgumentException if InputFile is not a file
	 */
	List<String> readLines(File inputFile) throws IllegalArgumentException;
	
	/**
	 * Check if a line contains the regex pattern passed through args[]
	 * 
	 * @param line input string
	 * @return true if there is a match
	 */
	boolean containsPattern(String line);
	
	/**
	 * Write lines to a file
	 * 
	 * @param lines matched line
	 * @throws IOException if write to file failed
	 */
	void writeToFile(List<String> lines) throws IOException;
	
	
	//GETTERS AND SETTERS
	
	String getRootPath();
	void setRootPath(String rootPath);
	
	String getRegex();
	void setRegex(String regex);
	
	String getOutFile();
	void setOutFile(String outFile);
	
}
