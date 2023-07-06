# RestAssured_Dynamic_Framework
This API project contains how to run our framework dynamically. I have created one excel where I have given all test classes name one by one and using readdataexcel function we are running test classes one by one.

Features :
1) This project is capable enough to run all GET, PUT, PATCH, POST at one run.
2) This project is capable enough to run API project dynamically using Excel file input which contains all the testclasses.
3) This project is built on concept of data driven and keydriven
4) The framework is divided into 4 packages-
   1)Request Repository which contains methods like BaseURI, Resource and fetching request body.
   2)Common Methods package which contains methods like fetching statuscode and response body
   3)Test Classes package which contains methods for validate request and response body using testNG assert method.
   4)Driver Package which contains driver class to run framework.
5) This prject is capable of saving the evidence file where we save request body, response body and status code in text file.
