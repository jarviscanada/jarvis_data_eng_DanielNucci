package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Count-Primes-76942143ee8640e3af020464b93c85d0
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {
	
	/**
	 * O(N/2) * O(sqrt N) = O(N * sqrt N) time complexity algorithm for counting prime numbers
	 * @param num
	 * @return how many positive numbers are prime under num
	 */
	public int countPrimes(int num) {
		if (num < 3) {
			return 0; 
		}
		
		int count = 1; // include 2 as a prime
		for (int i = 3; i < num; i+=2) { //
			if (isPrime(i)) {
				count++;
			}
		}
        return count;
    }
	
	/**
	 * O(sqrt N) time complexity algorithm to check if a given number is prime
	 * @param num 
	 * @return true if prime
	 */
	public boolean isPrime(int num) {
		for (int i = 2; Math.pow(i, 2) <= num; i++) { // no need to go higher than i^2
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	
}