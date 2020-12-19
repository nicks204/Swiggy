package stepdef;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SwiggySignUp {
	
	WebDriver driver = SetUP.driver;
	
	ExtentReports extent;
	ExtentTest logger;
	
	@Given("^The user is on the Swiggy Home Page$")
    public void the_user_is_already_on_the_swiggy_home_page() throws Throwable {
		driver.get("https://www.swiggy.com/");
    }

    @When("^User click on SignUp$")
    public void user_click_on_signup() throws Throwable {
    	WebElement SingUp = driver.findElement(By.linkText("Sign up"));
    	SingUp.click();
    	
    	
    	Thread.sleep(5000);
    	
    	extent = new ExtentReports (System.getProperty("user.dir") +"/SwiggyTestReport.html", false);
		
 		logger = extent.startTest("Test01");
 		
 		logger.log(LogStatus.PASS, "Click on the Signup button");
    }

    @Then("^User should be redirected to SignUp Page$")
    public void user_should_be_redirected_to_signup_page() throws Throwable {
    	System.out.println("Then");
    	
    	WebElement Logo = driver.findElement(By.xpath("//*[@class='_1Tg1D']"));
    
    	Assert.assertTrue(Logo.isDisplayed());
    	
    	logger.log(LogStatus.PASS, "Validate the signup is appearing");
    	
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
    	
    }
    
    @Given("^The user is already on the Signup page$")
    public void the_user_is_already_on_the_signup_page() throws Throwable {
    	
    	driver.get("https://www.swiggy.com/");
    	WebElement SingUp = driver.findElement(By.linkText("Sign up"));
    	SingUp.click();
    	
    	extent = new ExtentReports (System.getProperty("user.dir") +"/SwiggyTestReport.html", false);
    	
    	logger = extent.startTest("Test02");
    	logger.log(LogStatus.PASS, "Click on the Signup button");
    	
      
    }

    @When("^User enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_something_something_something_and_something(String phone, String name, String email, String password) throws Throwable {
        
    	WebElement tbPhone = driver.findElement(By.id("mobile"));
    	WebElement tbName = driver.findElement(By.id("name"));
    	WebElement tbEmail = driver.findElement(By.id("email"));
    	WebElement tbPwd = driver.findElement(By.id("password"));
    	
    	tbPhone.sendKeys(phone);
    	tbName.sendKeys(name);
    	tbEmail.sendKeys(email);
    	tbPwd.sendKeys(password);
    	
    	Thread.sleep(5000);
    	
    	logger.log(LogStatus.PASS, "Enter the user details");
    }
    
    @And("^User Click Continue button$")
    public void user_click_continue_button() throws Throwable {
       
    }

    @Then("^User should be able to SignUp$")
    public void user_should_be_able_to_signup() throws Throwable {
    	
    	extent.endTest(logger);
    	extent.flush();
    	extent.close();
        
    }

  

    
}
