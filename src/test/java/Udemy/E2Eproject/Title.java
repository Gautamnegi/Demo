package Udemy.E2Eproject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjext.Landingpage;


public class Title extends Base {
	
	public WebDriver driver;
	
	
	@BeforeTest
	
	public void opensite() throws IOException
	{
		driver= initializeDriver();
		driver.get(geturl());
		
	}
	

	@Test
	
	public void getFeature() throws IOException
	{
		
		Landingpage land= new Landingpage(driver);
		String title=(land.feature()).getText();
		Assert.assertEquals("LEATURED COURSES", title);
		
	}
	
	@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
	}
}
