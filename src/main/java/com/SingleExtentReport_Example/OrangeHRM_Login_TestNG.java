package com.SingleExtentReport_Example;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_TestNG {
	ChromeDriver driver;
	
  @Test
  public void OrangeHrmLogin() throws InterruptedException {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			
  }
  
  @Test
  public void TrialTest() throws InterruptedException {
			System.out.println("HI");
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		// ChromeDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(5000);

  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
