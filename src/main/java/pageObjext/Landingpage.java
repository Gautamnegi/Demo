package pageObjext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By loginpage = By.cssSelector("a[href*='sign_in']");
	
	public WebElement getLogin()
	{
		return (driver.findElement(loginpage));
		
	}
	
	By feature= By.cssSelector("div[class='text-center']");
	public WebElement feature()
	{
		return (driver.findElement(feature));
	}
	

}
