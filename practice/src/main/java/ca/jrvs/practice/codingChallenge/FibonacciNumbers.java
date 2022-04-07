package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-465af314f74c4330bc6c679ae404939a
 * https://leetcode.com/problems/fibonacci-number/ and https://leetcode.com/problems/climbing-stairs/
 */
public class FibonacciNumbers {
	
	/**
	 * O(n) time complexity algorithm to generate the Fibonacci series
	 * @param n - the number
	 * @return the nth fibonacci number
	 */
	public int fib(int n) {
        if (n <= 1) {
        	return n;
        }
        
        int fib1 = 0, fib2 = 1; // base case 1, 1 for the stairs solution
        
        for (int i = 2; i <= n; i++) {
        	int newFib = fib1 + fib2;
        	
        	fib1 = fib2;
        	fib2 = newFib;
        }
        
        return fib2;
    }
}
