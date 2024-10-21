package StepDefinitions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import webpages.CarRegistrationSubmission;
import org.junit.Assert;

public class CarRegistrationSubmissionSteps {
	
	WebDriver driver;
    CarRegistrationSubmission carRegistrationSubmission;
    
    // Path to the local HTML file
    File htmlFile = new File("C:/Users/choul/Downloads/QA Programming Exercise.html");

    // Get the absolute path of the file and prepend "file://" to the path
    String filePath = "file:///" + htmlFile.getAbsolutePath();
	
    @Given("user navigates to the car registration webpage")
    public void user_navigates_to_the_car_registration_webpage() {
		// Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Open the car registration local page
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
   
    	// Demonstration purpose: Add a 2 seconds sleep after the test validation to visually check the result
 	    try {
 	        Thread.sleep(2000); // Wait for 2 seconds
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
    	 driver.close();
    	 driver.quit();
    }

    @When("user selects one year {string}")
    public void user_selects_one_year(String year) {
    	carRegistrationSubmission.selectAYear(year);
    }

    @Then("an error message is displayed saying {string}")
    public void an_error_message_is_displayed_saying(String expectedErrorMessage) {
    	 String actualMessage = carRegistrationSubmission.getErrorMessageElement().getText();
    	 Assert.assertEquals("Success message does not match!", expectedErrorMessage, actualMessage);
    	 
    	// Demonstration purpose: Add a 2 seconds sleep after the test validation to visually check the result
    	    try {
    	        Thread.sleep(2000); // Wait for 2 seconds
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }
    	 driver.close();
    	 driver.quit();
    }
    

    @When("user enters an invalid car registration number {string}")
    public void user_enters_an_invalid_car_registration_number(String carRegistrationNumber) {
    	carRegistrationSubmission.enterCarRegistration(carRegistrationNumber);
    }	
}
