package Udemy.E2Eproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;                   //we define webdriver  as global variable

	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\Gautam\\eclipse-workspace\\E2Eproject\\src\\main\\java\\Udemy\\E2Eproject\\globaldata.properties");
		prop.load(fs);                    //connecting properties class to property file
		
		
		
		//fetching Browser value from property file and initilaizing browser
		
		if(prop.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver");
			driver= new FirefoxDriver();
		}
		
		else if(prop.getProperty("Browser").equalsIgnoreCase("edge"))
		{
			//edge browser invoking code
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public String geturl() throws IOException
	{
		Properties prop2= new Properties();
		FileInputStream fs2= new FileInputStream("C:\\Users\\Gautam\\eclipse-workspace\\E2Eproject\\src\\main\\java\\Udemy\\E2Eproject\\globaldata.properties");
		prop2.load(fs2);
		return prop2.getProperty("URL");
		
		
	}
	
	public String getScreenshot(String testname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testname+".png";
		FileUtils.copyFile(source,new File(destinationfile));
		return destinationfile;
	}
}

