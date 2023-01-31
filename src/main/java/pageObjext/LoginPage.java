package pageObjext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By email= By.cssSelector("input[id='user_email']");
	By pass = By.cssSelector("input[id='user_password']"); 
	By loginbtn= By.cssSelector("input[name='commit']");
	
	public WebElement getEmail()
	{
		return (driver.findElement(email));
		
	}

	public WebElement getPass()
	{
		return(driver.findElement(pass));
	}
	
	public WebElement loginButton()
	{
		return(driver.findElement(loginbtn));
	}
}

