//package com.OrangeHRM_2ndMarch;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Sikuli_Integration_Example {
//	WebDriver driver;
//	@Test
//	public void FileUpload_UsingSikuli() throws Exception {
//		WebDriverManager.chromedriver().setup();
//		
////		C:\Workspaces\SeleniumTraining\JD_OrangeHRM_Maven
////		String filepath = "C:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\Sikuli_Objects\\";
//		String filepath = System.getProperty("user.dir")+"\\Sikuli_Objects\\";
//		System.out.println("filepath ::"+filepath);
//		//String inputFilePath = "D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\Sikuli_Scripts\\";
//		Screen s = new Screen();
//		Pattern fileInputTextBox = new Pattern(filepath+"FileTextBox.PNG");
//		Pattern openButton = new Pattern(filepath+"OpenButton.png");
//
//		// Open Chrome browser	
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://gofile.io/uploadFiles");
//		Thread.sleep(10000);
//		// Click on Browse button and handle windows pop up using Sikuli
//		driver.findElement(By.xpath("//button[@id='dropZoneBtnSelect']")).click();
//		s.wait(fileInputTextBox, 20);
//		s.type(fileInputTextBox,filepath+"Fuel_Bill.jpg");
//		s.click(openButton);
//
//		// Close the browser
//		//driver.close();
//
//	}
//}
