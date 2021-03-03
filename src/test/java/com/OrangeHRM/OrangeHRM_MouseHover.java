package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_MouseHover {
	ChromeDriver driver;
	WebDriverWait wait;
	
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			Thread.sleep(1000);
			WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
			Actions action = new Actions(driver);
			action.moveToElement(admin).build().perform();
//			Thread.sleep(5000);
//			WebElement userMangement = driver.findElement(By.id("menu_admin_viewAdminModule"));
			  WebElement userMangement = driver.findElementByLinkText("User Management");
			action.moveToElement(userMangement).build().perform();
//			Thread.sleep(5000);
			
			 driver.findElementByLinkText("Users").click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='head']")));
  }
  
  @Test(priority =2)
  public void logOut() throws InterruptedException {
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Logout")).click();
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		// ChromeDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(5000);
		wait =new WebDriverWait(driver, 30);

  }

//  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
