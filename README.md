# Prime number Rest Service

  This rest service returns prime numbers using two different algorithms.

## Requirements

   This application uses Spring Boot and Java 8.
   
## Installation

   This code can be installed by importing the pom.xml run as Spring Boot Application.

## Usage

  The rest end point for this application is as below-
  
  GET /util/prime
  
  The following two parameters can be used-
  
  	**max** - The number of prime numbers to be returned. Defaulted to 10.
  	
  	**algorithm** - The algorithm to be used. There are two algorithms - simple and optimised. Defaulted to optimised.
  	
  
  Example:
  	http://localhost:8080/util/prime/?max=100&algorithm=simple
  
  


