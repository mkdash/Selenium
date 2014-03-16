package com.learn.selenium.gmail.sentmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySentMailTest {
	WebDriver driver;
	Actions act;
	
	@BeforeClass
	public void configBeforeClass(){
		driver = new FirefoxDriver();
		act = new Actions(driver);
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
	public void verifySentMailTest(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		act.moveToElement(driver.findElement(By.linkText("Important"))).perform();
		driver.findElement(By.linkText("Sent Mail")).click();
		//driver.findElement(By.xpath("//a[text()='Sent Mail']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Regarding Selenium Openings')]")).click();
	}

}
