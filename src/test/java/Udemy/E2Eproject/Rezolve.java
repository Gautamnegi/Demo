package Udemy.E2Eproject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rezolve {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//initializing multiple chrome browser instances
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		for(int chromeInstance =1; chromeInstance <=2; chromeInstance++) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com%2F");
			
		}
		Thread.sleep(5000);
		//dev 2 changes
		
		//Get window  Handles of both browser window
		Set<String> windowHandleIds = driver.getWindowHandles();
		Iterator<String> i = windowHandleIds.iterator();
		String firstWindowId = driver.getWindowHandle();
		String secondWindowId = i.next();
		System.out.println(windowHandleIds);
		//System.out.println(firstWindowId);
		//System.out.println(secondWindowId);
		
		//login with 2 different credentials
		driver.switchTo().window(firstWindowId);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginUsername']")).sendKeys("mataugigen@gmail.com");
		driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("8630728362Reddit");
		
		driver.switchTo().window(secondWindowId);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginUsername']")).sendKeys("gautam261998@gmail.com");
		driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("8630728362Reddit");
		
		Thread.sleep(10000);
		//dev 1 changes
		//gautam changes
	}

}
