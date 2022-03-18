package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Print-letter-with-number-70838ffec43f474dbe1e8c36787c16bc
 * Online Judge N/A
 */
public class PrintLetterWithNumber {
	
	/**
	 * O(n) time complexity algorithm to print the character's number beside it
	 * @param phrase
	 * @return the updated phrase
	 */
	public String printLetterWithNumber(String phrase) {
		StringBuilder sb = new StringBuilder();
		
		for (char c: phrase.toCharArray()) {
			sb.append(c);
			if (c >= 65 && c <= 90) { //upper case bounds
				sb.append((int) (c - 65 + 27)); //ASCII table values subtract initial value and add the value it corresponds to 
			}
			else if (c >= 97 && c <= 122) { //lower case bounds
				sb.append((int) (c - 97 + 1)); //ASCII table values subtract initial value and add the value it corresponds to
			}
		}
		
		return sb.toString();
	}
}
