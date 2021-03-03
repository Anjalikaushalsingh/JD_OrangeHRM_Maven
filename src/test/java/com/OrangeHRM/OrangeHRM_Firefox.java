package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
// to be checked 
public class OrangeHRM_Firefox {
	EdgeDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void AddUser() throws InterruptedException {
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		WebElement userMangement = driver.findElementByLinkText("User Management");
		action.moveToElement(userMangement).build().perform();

		driver.findElementByLinkText("Users").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='head']")));

		driver.findElement(By.id("btnAdd")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_userType")));
		Select select = new Select(driver.findElementById("systemUser_userType"));
		select.selectByVisibleText("Admin");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		driver.findElement(By.id("systemUser_userName")).sendKeys("Fiona1111");
		driver.findElement(By.id("systemUser_password")).sendKeys("Fiona1234");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Fiona1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnDelete")).isDisplayed();
	}

	@Test(priority = 3)
	public void logOut() throws InterruptedException {
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
//		WebDriverManager.chromedriver().setup();
		// ChromeDriver driver = new ChromeDriver();
//		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 30);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
