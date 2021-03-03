package com.OrangeHRM_1stMarch;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Robot_To_Upload {
	String URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	EdgeDriver  driver;
	//WebDriverWait wait = new WebDriverWait(driver,10);
	@BeforeTest
	public void setUp() throws Exception {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new  ChromeOptions();
//		driver = new ChromeDriver();
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

//	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testUpload() throws InterruptedException{		
		driver.get(URL);
		Thread.sleep(3000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(3000);
		WebElement admin = driver.findElementById("menu_pim_viewPimModule");

        Actions action = new Actions(driver);
        action.moveToElement(admin).build().perform();
        driver.findElementByLinkText("Add Employee").click();
        Thread.sleep(3000);
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\Images\\Image0019.jpg";
		System.out.println(filepath);
		
		Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//li/input[@class='duplexBox']")).click();
////		driver.findElement(By.xpath("//input[@id='photofile']")).sendKeys(Keys.ENTER);
		driver.navigate().refresh();
		driver.findElement(By.id("firstName")).sendKeys("Anjali");
		driver.findElement(By.id("lastName")).sendKeys("lastName");
		
		
		/// used java scripts 
		WebElement element = driver.findElement(By.id("photofile"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		
		
//		driver.findElement(By.id("photofile")).click();
		uploadFile(filepath);
        Thread.sleep(3000);
        driver.findElementById("firstName").sendKeys("Abhi");
        driver.findElementById("lastName").sendKeys("Dixit");
		driver.findElementById("btnSave").click();
	}

	public static void uploadFile(String fileLocation) {
		try {
			//Upload file through Robot API
			StringSelection ss = new StringSelection(fileLocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			//native key strokes for CTRL, V and ENTER kxeys
			Robot robot = new Robot();
			robot.delay(1000);     
			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);    
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			//Press Enter
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);	
			robot.delay(1000);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
