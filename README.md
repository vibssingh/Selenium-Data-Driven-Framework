**_Data Driven Framework - Selenium_**

**_Overview_**

A Data Driven Framework is a software testing framework that separates the test script logic from the test data. The test data is stored separately in external files like csv, xlsx, or databases that allows easy maintenance of the framework. In data driven framework, the test scripts retrieves the input values and expected results from the external source and write the actual result to the same source like spreadsheets, XML files, CSV files or database.

**_Test Framework_**

This is a sample application to demonstrate how to setup Data Driven Framework using Selenium, TestNG and Apache POI.
Framework uses Page Object Design Pattern, hence there is clean separation between test code and page specific code such as locators and layout.

1. This framework consists of:
````
   Selenium – 4.21.0
   Java 17
   TestNG – 7.10.2
   Maven – 3.9.6
   Apache POI – 5.2.5
````   
   
2. All the test to be executed can be configured in TestData.xlsx sheet placed in below path.
````
src\test\resources\testdata.xlsx
````

3. Open the command prompt and navigate to the folder in which pom.xml file is present. Run the below Maven command.
````
   mvn clean test
````   

4. Reports

This framework contains sample TestNG Reports under **_test-output_** folder.