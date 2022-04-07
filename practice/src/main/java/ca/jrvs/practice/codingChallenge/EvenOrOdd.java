package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Sample-Check-if-a-number-is-even-or-odd-fd77ac222783404ea408e79f605b05c8
 * Online Judge N/A
 */
public class EvenOrOdd {
	
	/**
	 * O(1) time complexity algorithm to determine if a number is even or odd
	 * @param num
	 * @return even if even, odd if odd
	 */
	public String evenOrOdd(int num) {
		return (num % 2 == 0) ? "even" : "odd";
	}
}
