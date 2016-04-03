# Prime number Rest Service

	This rest service returns prime numbers using two different algorithms.

## Requirements

	This application uses Spring Boot and Java 8.
   
## Installation

	This code can be installed by importing the pom.xml and executed as Spring Boot Application.

## Usage

	The rest end point for this application is as below-
	  
	GET /util/prime
	  
	The following two parameters can be used-
	  
	1. limit - The number of prime numbers to be returned. Defaulted to 10. Max limit is set to 1000.
	  	
	2. algorithm - The algorithm to be used. There are two algorithms - simple and optimised. Defaulted to optimised.
	  	
	Example:
	  	http://localhost:8080/util/prime/?limit=100&algorithm=simple
  	
## Limitations

	This rest service does not use any cache controls nor does it support json or xml output for simplicity. 

  
  
  


