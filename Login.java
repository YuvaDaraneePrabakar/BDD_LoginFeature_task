package Features;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Login {

    WebDriver driver;

    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @When("User navigate to Login Page")
    public void user_navigate_to_login_page() {
    	WebElement person = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
        person.click();
        WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        loginbtn.click();
    }

    @When("User enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
    	
    	WebElement mail=driver.findElement(By.xpath("//*[@id=\"input-email\"]"));  
        mail.sendKeys(username);
        
        WebElement pass=driver.findElement(By.xpath("//*[@id=\"input-password\"]"));  
        pass.sendKeys(password);
        
        
    }

    @When("Keeping {string} as {string}")
    public void keeping_case_as_valid(String caseType,String value) {
        
    	if(caseType.equals(value))
    	{
    		WebElement submit=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));  
            submit.click();
            
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/h2[1]")));
            assertEquals("My Account", messageElement.getText());
    	}
    	else
    	{
    		WebElement submit=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));  
            submit.click();
            
            WebDriverWait ewait = new WebDriverWait(driver, 10);
            WebElement errorMessage = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/text()")));
            assertEquals("Warning: No match for E-Mail Address and/or Password.", errorMessage.getText());
    	}
    	
    }

    @Then("User should get logged in")
    public void user_should_get_logged_in() {
    }

    @Then("Message {string} is displayed")
    public void message_is_displayed(String message) {
    }

/*    @But("Keeping {string} as InValid")
    public void keeping_case_as_invalid(String caseType) {
    	
    }*/
    
    @Then("User will be asked to go back to login page")
    public void user_will_be_asked_to_go_back_to_login_page() {
    }

    @Then("Provide correct credentials")
    public void provide_correct_credentials() {
        // Add logic to provide correct credentials if needed
    }

    @Then("Close the browser")
    public void close_the_browser() {
    	//Thread.sleep(1000);
        driver.quit();
    }
}
