package com.icap.prime.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icap.prime.util.PrimeNumberUtil;

@RestController
public class PrimeNumberController {
	//constants
	public static final int MAX_LIMIT = 5000;
	public static final String ALGORITHM_OPTIMISED = "OPTIMIZED";
	public static final String ALGORITHM_SIMPLE = "SIMPLE";
	
	//defautls
	public static final String DEFAULT_LIMIT = "10";
	public static final String DEFAULT_ALGORITHM = ALGORITHM_OPTIMISED;

	
	/**
	 * This method is the handler method for rest uri /util/prime. This takes max number of prime numbers required
	 * and the algorithm to be used as the parameters. 
	 * @param limit
	 * @param algorithm
	 * @return Returns the prime numbers as a list in the response body
	 */
	@RequestMapping(value="/util/prime", method = RequestMethod.GET)
	public String printPrime(@RequestParam (name="limit", defaultValue=DEFAULT_LIMIT) String limit, 
			@RequestParam(name="algorithm", defaultValue=DEFAULT_ALGORITHM) String algorithm){

		long parsedLimit = 0;
		
		//If limit is not a number or less than 1 or greater than MAX_LIMIT, gracefully default
		try{
			parsedLimit = Long.parseLong(limit);
			if (parsedLimit < 1 || parsedLimit > MAX_LIMIT) {
				parsedLimit = Long.parseLong(DEFAULT_LIMIT);
			}
		}catch(NumberFormatException nfe){
			parsedLimit = Long.parseLong(DEFAULT_LIMIT);
		}catch(Exception e){
			parsedLimit = Long.parseLong(DEFAULT_LIMIT);
		}

		//Use simple algorithm if specifically chosen, otherwise always use optimised algorithm
		if(ALGORITHM_SIMPLE.equals(algorithm)) {
			return PrimeNumberUtil.primeSequence(parsedLimit,
					(x)->PrimeNumberUtil.isPrimeSimple((Long)x)).toString();	
		} else {
			return PrimeNumberUtil.primeSequence(parsedLimit,
					(x)->PrimeNumberUtil.isPrimeOptimised((Long)x)).toString();
		}

	}
}
