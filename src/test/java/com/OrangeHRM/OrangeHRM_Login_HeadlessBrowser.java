package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_HeadlessBrowser {
	ChromeDriver driver;
	 WebDriverWait wait;
	
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new  ChromeOptions();
//			options.setHeadless(true); // behave as headless
			options.setHeadless(false); // behave as head
			
			// ChromeDriver driver = new ChromeDriver();
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, 60);
			driver.manage().window().maximize();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

	  }
	
  @Test(priority= 1)
  public void Login() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			
  }
  
  @Test(priority =2)
  public void logOut() throws InterruptedException {
	  WebElement welcome = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Welcome")));
	  welcome.click();
//	  driver.findElement(By.partialLinkText("Welcome")).click();
//	  Thread.sleep(10000);
	  
	 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		String ActText=element.getText();
		System.out.println(ActText);
		element.click();
//	  driver.findElement(By.linkText("Logout")).click();
	  
	  String actualText = driver.findElement(By.id("logInPanelHeading")).getText();
	  String expectedText = "LOGIN Panel";
	  Assert.assertEquals(actualText, expectedText);
	  
	  String actualUrl = driver.getCurrentUrl();
	  String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	  Assert.assertEquals(expectedUrl, actualUrl);
	  
	  
	  String expectedTitle = "OrangeHRM";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(expectedTitle, actualTitle);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
