package RunnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		   features = "src/test/resources/Features",  // Path to feature files
		   glue = {"StepDefinitions"},  // Path to step definitions
		   plugin = {"pretty", "html:target/HtmlReports/test_results_report.html",   //.html reports
					           "json:target/JSONReports/test_results_report.json", 	 //.json reports
					           "junit:target/JUnitReports/test_results_report.xml"}, //.xml reports
		   monochrome = true,  // Makes console output more readable
		   tags = "@SmokeTests" // tag filtering
		)
public class RunnerClass {
   // No additional code needed
}