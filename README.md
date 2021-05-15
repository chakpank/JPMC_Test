# Salient Features of Solution

1. Used Request and Response specification Builder to optiomize code.
2. ENUM and Properties file to store the constants and global variables
3. User POJO Classes to achive Serialization and Deserialization for Test Data Building
4. Use Random Number Generators from Math class to generate random User ID, Post ID
5. Performed Data Driven Testing using Scenario Outlines
6. Created test case grouping using tags
7. Created generic scenarios to reduce the code duplicity
8. Used Maven for dependency management and test execution
9. Used Github as Code Repository

# Execution Process 

**Way 1**: 
Using Maven Commands also the execution can be done. Open command prompt and go the directory checked out code directory
Run the command : mvn test  // This will execute all the tests present in all feature file

We can also execute group of tests based on the tag
For Example if we would like to execute the tests having tag = @Post 
maven command for that would be : mvn test -Dcucumber.filter.tags="@Post"

**Way 2**: 
Execute the SocialMediaTest class as JUnit Test to execute all the test cases
From the SocialMediaTest if we ould like to execute on those test cases with tag = @Post then use that tag as cumcumber.options


# Report Generation 

To generate the execution report use the maven command : mvn test verify

The report would be generated at : target/cucumber-html-reports/overview-features.html

# Sample Report

![image](https://user-images.githubusercontent.com/46698950/118377595-cf03b200-b5eb-11eb-88fb-8f442d48280a.png)

