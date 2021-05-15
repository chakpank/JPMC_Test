# Execution Process: 

**Way 1**: 
Using Maven Commands also the execution can be done. Open command prompt and go the directory checked out code directory
Run the command : mvn test  // This will execute all the tests present in all feature file

We can also execute group of tests based on the tag
For Example if we would like to execute the tests having tag = @Post 
maven command for that would be : mvn test -Dcucumber.filter.tags="@Post"

**Way 2**: 
Execute the SocialMediaTest class as JUnit Test to execute all the test cases
From the SocialMediaTest if we ould like to execute on those test cases with tag = @Post then use that tag as cumcumber.options


# Report Generation: 

To generate the execution report use the maven command : mvn test verify

The report would be generated at : target/cucumber-html-reports/overview-features.html
