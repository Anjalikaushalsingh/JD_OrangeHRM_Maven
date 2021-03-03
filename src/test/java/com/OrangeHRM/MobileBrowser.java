package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class MobileBrowser {
	ChromeDriver driver;
	WebDriverWait wait;
	String enteredValue;
	Dimension d;

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.navigate().to("https://www.borrowlenses.com/");
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 30);
		
		 d = new Dimension(768, 1024); // ipad view
		driver.manage().window().maximize();  // maximiz window after url lauch
		driver.manage().window().setSize(d);  // // adjusting size b4 launching url to Ipad
		Thread.sleep(2000);
		
		d = new Dimension(375, 812);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().setSize(d);  // adjusting size b4 launching url to Iphone x
		Thread.sleep(2000);
		
		
		d = new Dimension(320, 568); // see emulator for sizes
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().setSize(d);  // adjusting size b4 launching url to Iphone 5 
		Thread.sleep(2000);

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions iphoneOptions = new ChromeOptions();
		driver = new ChromeDriver(iphoneOptions);

		 d = new Dimension(1024, 1366); // ipad view  // adjusting size b4 launching url
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().setSize(d);
		

	}

	// @AfterTest
	public void afterTest() {
		driver.close();
	}

}
