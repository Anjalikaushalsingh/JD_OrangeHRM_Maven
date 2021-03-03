package com.OrangeHRM_1stMarch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_Down_WebPage_From_Bottom_To_Top {
	ChromeDriver driver;
    @Test
    public void ByPage() throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("https://stackoverflow.com/");
		Thread.sleep(3000);
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
//        driver.findElementByLinkText("About").click();
//        driver.findElement(By.xpath("//a[@class='js-gps-track -link'][normalize-space()='About']")).click();
        //This will scroll the web page till top.		
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='For businesses']")).click();
    }
}
