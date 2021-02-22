# restassured-cucumber
API Framework designed using rest-assured and cucumber in JAVA


##### Framework Development Environment:
Framework is developed considering following system requirements
- OS - Windos 10/MacOS Mojave 10.14.6	
- Java Version - 1.8.0_211
- IDE - Eclipse Neon.3 Release (4.6.3)
- Maven Version - Apache Maven 3.6.2
- Rest-Assured version - 4.1.2

##### Framework Features:
- Framework is designed using Rest-Assured and CucumberV4 in JAVA.
- Implementation of tests is segregated from the tests using step definitions.
- Used reporting-plugin of cucumber to generate the Cucumber reports.
- Base URL path is mentioned in configurations.properties which can be changed to use any other url.
- Response Schema validation is also in place. Schema files are placed under testData folder

##### How to RUN:
There are two ways to execute it
~~~~~~~~~~~~~~~
First Way:
- Import project into IDE Eclipse as maven project. Cucumber plugin should be present in eclipse.
- Right click on TestRunner.java file and you will get option to RUN as JUNIT Test. Click on it and it will start execution.
- Result can be found in target/cucumber/cucumber-html-reports. Click on overview-features.html and you will see results.
- You may need to do refresh after run to see latest cucumber report
Second Way:
- Maven should be installed in the machine and path needs to be set if not.
- Go to command prompt.
- Run the following command where pom.xml resides.
- mvn clean test  - it will run all the features available in features folder.
~~~~~~~~~~~~~~~~~~
