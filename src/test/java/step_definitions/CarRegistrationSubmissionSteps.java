package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import test_runner.TestRunner;
import web_pages.CarRegistrationSubmission;

import org.junit.Assert;


public class CarRegistrationSubmissionSteps {
	
    WebDriver driver;
    CarRegistrationSubmission carRegistrationSubmission;

    // Setup WebDriver for each test (Scenario)
    @Before
    public void setup() {
        setupWebDriver();  // Ensure new WebDriver session for each test
    }

    public void setupWebDriver() {
        // Get the browser type from "RunnerClass" class
        String browser = TestRunner.browser;
        
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser type not supported: " + browser);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after the test
        }
    }

    @Given("user navigates to the car registration webpage")
    public void user_navigates_to_the_car_registration_webpage() {
        // Access the HTML file path from "RunnerClass" class
        String filePath = "file:///" + TestRunner.htmlFilePath;
        driver.get(filePath);
        carRegistrationSubmission = new CarRegistrationSubmission(driver);
    }

    @When("user enters a valid car registration number {string}")
    public void user_enters_a_valid_car_registration_number(String carRegistrationNumber) {
    	carRegistrationSubmission.enterCarRegistration(carRegistrationNumber);
    }

    @And("user selects a year {string}")
    public void user_selects_a_year(String year) {
    	carRegistrationSubmission.selectAYear(year);
    }

    @And("user clicks on the Submit button")
    public void user_clicks_on_the_submit_button() {
    	carRegistrationSubmission.clickSubmitButton();
    }

    @Then("a success message is displayed saying {string}")
    public void a_success_message_is_displayed_saying(String expectedSuccessMessage) {
    	 String actualMessage = carRegistrationSubmission.getSuccessMessageElement().getText();
    	 Assert.assertEquals("Success message does not match!", expectedSuccessMessage, actualMessage);
    	 Boolean errorLabelIsHiddenWhenSuccessMessageIsDisplayed = !carRegistrationSubmission.getErrorMessageElement().isDisplayed();
    	 Assert.assertTrue("The error message should be hidden when a success message is displayed.", errorLabelIsHiddenWhenSuccessMessageIsDisplayed);
   
    	// Demonstration purpose: Add a 2 seconds sleep after the test validation to visually check the result
 	    try {
 	        Thread.sleep(2000); // Wait for 2 seconds
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
    }

    @When("user selects one year {string}")
    public void user_selects_one_year(String year) {
    	carRegistrationSubmission.selectAYear(year);
    }

    @Then("an error message is displayed saying {string}")
    public void an_error_message_is_displayed_saying(String expectedErrorMessage) {
    	 String actualMessage = carRegistrationSubmission.getErrorMessageElement().getText();
    	 Assert.assertEquals("Error message does not match!", expectedErrorMessage, actualMessage);
    	 Boolean successLabelIsHiddenWhenErrorMessageIsDisplayed = !carRegistrationSubmission.getSuccessMessageElement().isDisplayed();
    	 Assert.assertTrue("The error message should be hidden when a success message is displayed.", successLabelIsHiddenWhenErrorMessageIsDisplayed);
    	 
    	// Demonstration purpose: Add a 2 seconds sleep after the test validation to visually check the result
    	    try {
    	        Thread.sleep(2000); // Wait for 2 seconds
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }
    }
    

    @When("user enters an invalid car registration number {string}")
    public void user_enters_an_invalid_car_registration_number(String carRegistrationNumber) {
    	carRegistrationSubmission.enterCarRegistration(carRegistrationNumber);
    }	
}
