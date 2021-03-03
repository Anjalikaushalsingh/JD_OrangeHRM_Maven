package com.SingleExtentReport_Example;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DoubleClick {
	ChromeDriver driver;
	 WebDriverWait wait;
	
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
			
			WebDriverManager.chromedriver().setup();
			// ChromeDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 60);
			driver.manage().window().maximize();
			driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
			Thread.sleep(1000);

	  }
	
  @Test(priority= 1)
  public void LoginDOubleClick() throws InterruptedException {
	  Actions action = new Actions(driver);
	  
	  WebElement doubleClickbutton =driver.findElement(By.id("dblClkBtn"));
	  
	  action.doubleClick(doubleClickbutton).build().perform();
//	  action.dragAndDrop(drag, drop).build().perform();
	  Thread.sleep(2000);
	  
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  alert.accept();
	  
	  
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
