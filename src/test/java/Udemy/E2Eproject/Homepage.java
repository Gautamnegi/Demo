package Udemy.E2Eproject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjext.Landingpage;
import pageObjext.LoginPage;

public class Homepage extends Base {
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(Homepage.class.getName());
	
	@BeforeTest
	
	public void opensite() throws IOException
	{
		driver= initializeDriver();
		log.info("initializing driver");
		
		
	}
	
	public void print() {
		System.out.println("Changes made");
		System.out.println("Changes made again");
		System.out.println("New branch created");
	}
	
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String name, String pass) throws IOException
	{
		
		driver.get(geturl());
		log.info("opening website");
		
		
		//code for landing page
		Landingpage land= new Landingpage(driver);
		land.getLogin().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//code for login page
		LoginPage logn = new LoginPage(driver);
		logn.getEmail().sendKeys(name);
		logn.getPass().sendKeys(pass);
		logn.loginButton().click();
		
		log.info("entering credentials");
		
	}
	
	
	@DataProvider                                                //we use dataprovider for parameterization of testcase
																//so we can provide more than 1 types of data for same testcase
	
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];                     //here row represent how many diff times we want to run testcase for diff data
															   //and column rep. number of data in each set
		obj[0][0]="gautam";
		obj[0][1]="123";
		
		obj[1][0]="akshat";
		obj[1][1]="890";
		
		return obj;
	}
	
	@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
	}

}
