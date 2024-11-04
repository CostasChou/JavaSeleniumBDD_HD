package web_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CarRegistrationSubmission {
	
	WebDriver driver;
	
	// WEB PAGE LOCATORS
	private By textField_CarRegistration = By.id("input-number-plates");
	private By dropDownList_YearSelection = By.id("select-year");
	private By button_Submit = By.id("btn-submit");
	private By label_successMessage = By.cssSelector(".alert.alert-success");
	private By label_errorMessage = By.cssSelector(".alert.alert-danger");
	
	/* 
	   Ensures that the WebDriver instance is passed when creating the page object,
	   allowing the same WebDriver session to be reused across different page actions,
	   so the browser state is maintained throughout the test. 
	 */
	public CarRegistrationSubmission(WebDriver driver){
		this.driver = driver;
	}
	
	// ACTIONS
	public void enterCarRegistration(String carRegistration) {
		driver.findElement(textField_CarRegistration).sendKeys(carRegistration);
	}
	
	public void selectAYear(String year) {
		WebElement yearDropDown = driver.findElement(dropDownList_YearSelection);
		Select selection = new Select(yearDropDown);
		selection.selectByVisibleText(year);
	}
	
	public void clickSubmitButton() {
		driver.findElement(button_Submit).click();
	}
	
    	// GETTERS
    	public WebElement getSuccessMessageElement() {
        	return driver.findElement(label_successMessage);
    	}
    
    	public WebElement getErrorMessageElement() {
        	return driver.findElement(label_errorMessage);
    	}
}
