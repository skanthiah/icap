package com.icap.prime.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icap.prime.util.PrimeNumberUtil;

@RestController
public class PrimeNumberController {

	@RequestMapping(value="/util/prime", method = RequestMethod.GET)
	public String printPrime(@RequestParam (name="max", defaultValue="10") int max, @RequestParam(name="algorithm", defaultValue="optimised") String algorithm){		
		if("optimised".equals(algorithm))
			return PrimeNumberUtil.primeSequence(max,(x)->PrimeNumberUtil
					.isPrimeOptimised((Long)x)).toString();
		else
			return PrimeNumberUtil.primeSequence(max,(x)->PrimeNumberUtil
					.isPrimeSimple((Long)x)).toString();
	}
}
