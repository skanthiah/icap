package com.icap.prime.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PrimeNumberUtil {
	/**
	 * This method uses the most common algorithm to find a prime number i.e. by trying to divide
	 * given number with all the odd numbers between 3 and the number itself
	 * 
	 * @param number The number of prime numbers to be returned
	 * @return boolean to indicate of the given number is prime or not
	 */
	public static boolean isPrimeSimple(long number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * This method finds if the given number is prime using Trial Division.
	 * Essentially the given number is checked to if it is multiple of any
	 * number between 2 and square root of the given number.
	 * 
	 * @param number The number of prime numbers to be returned
	 * @return boolean to indicate of the given number is prime or not
	 */
	public static boolean isPrimeOptimised(long number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		int limit = (int) Math.sqrt(number);

		for (int i = 3; i <= limit; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}


	/**
	 * This method returns max number of prime numbers. This method uses Java8 streams and leverages
	 * multi-threading using parallel function of stream api.
	 * 
	 * @param max The number of prime numbers to be returned
	 * @param predicate The algorithm to be used
	 * @return List of prime numbers
	 */
	public static List<Long> primeSequence(long max, Predicate<Long> predicate) {
		if (max > 0 && predicate != null)
			return LongStream
					.iterate(2, i -> i + 1)
					.parallel()
					.filter(x -> predicate.test(x))
					.limit(max).boxed()
					.collect(Collectors.toList());
		else
			return null;
	}
	
}
