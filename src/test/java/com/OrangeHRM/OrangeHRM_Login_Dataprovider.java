package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Dataprovider  extends OrangeHRMTestData{
	WebDriver driver;

	@Test(dataProvider="Login")
	public void Login_Successful_Scenario(String uName,String Upwd) throws InterruptedException {

//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
//	    Thread.sleep(5000);
//		driver.findElement(By.name("txtUsername")).sendKeys(uName);
//	    driver.findElement(By.id("txtPassword")).sendKeys(Upwd);
//		driver.findElement(By.id("btnLogin")).click();
//		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		
		
		// driver.manage().window().fullscreen();
				// This will wait for Page to load
				// driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
				// This will store or rememember the cookies or navigation in terms of
				// back and forward
				driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
				Thread.sleep(3000);
				driver.findElement(By.name("txtUsername")).sendKeys(uName);
				driver.findElement(By.name("txtPassword")).sendKeys(Upwd);
				driver.findElement(By.id("btnLogin")).click();
				// Verify that Dashboard page displayed
				String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
				String ExpElement = "Dashboard";
				Assert.assertEquals(ActElement, ExpElement);
				System.out.println(ActElement);
				// ----------------To Verify Logout Function----------------

				/*
				 * driver.findElement(By.id("welcome")).click(); Thread.sleep(3000);
				 * driver.findElement(By.linkText("Logout")).click(); String ActLogpanel
				 * = driver.findElement(By.id("logInPanelHeading")).getText(); String
				 * ExpLogpanel="LOGIN Panel"; Assert.assertEquals(ActLogpanel,
				 * ExpLogpanel); System.out.println(ActLogpanel);
				 */
				// ----------------To Verify Logout Function without using
				// Assert----------------
				Thread.sleep(3000);
				driver.findElement(By.id("welcome")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Logout")).click();
				driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	}
	
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
