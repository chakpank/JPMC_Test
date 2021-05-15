package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/PostTest.feature",plugin = "json:target/jsonReports/cucumber-report.json",glue= {"stepDefinitions"})
public class PostTest {

}
