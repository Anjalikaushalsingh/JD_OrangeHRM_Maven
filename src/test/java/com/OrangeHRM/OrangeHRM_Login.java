package com.OrangeHRM;

//import org.junit.Test;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {

	@Test
	public void Login_Successful_Scenario() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	    Thread.sleep(5000);
	    
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.close();
	
	}

}
