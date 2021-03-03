//package com.SingleExtentReport_Example;
//
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;
//
//import org.testng.annotations.BeforeTest;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//
//public class HDFC_Alert_Trial {
//	ChromeDriver driver;
//	 WebDriverWait wait;
//	
//	@BeforeTest
//	  public void beforeTest() throws InterruptedException {
//		
//			
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new  ChromeOptions();
////			options.setHeadless(true); // behave as headless
//			options.setHeadless(false); // behave as head
//			// ChromeDriver driver = new ChromeDriver();
//			driver = new ChromeDriver(options);
//			wait = new WebDriverWait(driver, 60);
//			driver.manage().window().maximize();
//			
//
//	  }
//	
//  @Test(priority= 1)
//  public void LoginToHDFC() throws InterruptedException {
//	  driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
//		driver.switchTo().frame("login_page");
////		driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
//		driver.findElement(By.xpath("//img[@alt='continue']")).click();
//		String errMessg = driver.switchTo().alert().getText();
//		String expectedMessg = "Customer ID  cannot be left blank.";
//		Assert.assertEquals(expectedMessg, errMessg);
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
//		Thread.sleep(2000);
//  }
//  
//
//
//  @AfterTest
//  public void afterTest() {
//	  driver.close();
//  }
//
//}
