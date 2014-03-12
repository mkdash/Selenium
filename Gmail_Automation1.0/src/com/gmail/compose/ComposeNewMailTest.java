package com.gmail.compose;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComposeNewMailTest {
	WebDriver driver;
	
	@BeforeClass
	public void configBeforeClass(){
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public void configAfterClass() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
	
	@BeforeMethod
	public void configBeforeMethod(){
		driver.navigate().to("http://gmail.com");
		
		driver.findElement(By.id("Email")).sendKeys("binayaranjan.jena");
		driver.findElement(By.id("Passwd")).sendKeys("#emerge12345");
		driver.findElement(By.id("signIn")).click();
	}
	
	@AfterMethod
	public void configAfterMethod() throws InterruptedException{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(@class,'gbii')]")).click();
		driver.findElement(By.id("gb_71")).click();
	}
	@Test
	public void composeNewMailTest() throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.name("to")).sendKeys("jena.binayaranjan@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Regarding Selenium Openings");
		Thread.sleep(3000);
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@tabindex='1']"));
	    driver.switchTo().frame(frame1);
	    WebElement msgBody = driver.switchTo().activeElement();
	    msgBody.sendKeys("Hi" + '\n' + "This mail sent while automating the compose feature in gmail");
	    driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

}
