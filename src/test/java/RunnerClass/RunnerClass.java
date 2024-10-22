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
	
    // Static field for the browser type
    public static String browser = "chrome"; // only accepted values = chrome or firefox or edge.

    // Static field for the path to the local HTML file. // Update this path with your LOCAL path to the actual .html file when you need to execute the project
    public static String htmlFilePath = "C:/Users/choul/Downloads/QA Programming Exercise.html"; 

    public static void setBrowser(String selectedBrowser) {
        browser = selectedBrowser;
    }

    public static void setHtmlFilePath(String filePath) {
        htmlFilePath = filePath;
    }
}