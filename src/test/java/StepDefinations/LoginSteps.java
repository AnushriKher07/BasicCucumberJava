package StepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	static WebDriver driver;


	@Given("user is on login page")
	public void user_is_on_login_page() 
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}
	//@When("user enters username and password")

	@When("user enters: {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
		


	}
	@And("clicks on login page")
	public void clicks_on_login_page() throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		Thread.sleep(2000);



	}
	
	@Then("User is navigated to Homepage")
	public void User_is_navigated_to_Homepage()
	{
		WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
		Assert.assertTrue(pageTitle.isDisplayed());	
		}

	@Then("close the browser")

	public void close_the_browser() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(0));

		driver.close();

	}

}
	
