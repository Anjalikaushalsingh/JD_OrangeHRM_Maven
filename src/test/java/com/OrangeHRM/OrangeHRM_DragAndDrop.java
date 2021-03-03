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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_DragAndDrop {
	ChromeDriver driver;
	 WebDriverWait wait;
	
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
			
			WebDriverManager.chromedriver().setup();
			// ChromeDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 60);
			driver.manage().window().maximize();
			driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
			Thread.sleep(3000);

	  }
	
  @Test(priority= 1)
  public void Login() throws InterruptedException {
	  Actions action = new Actions(driver);
	  WebElement drag=driver.findElement(By.id("draggable"));
//	  WebElement drop=driver.findElementById("droppable");
	  WebElement drop=driver.findElement(By.id("droppable"));
	  action.dragAndDrop(drag, drop).build().perform();
	  Thread.sleep(5000);
  }
  
//  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
