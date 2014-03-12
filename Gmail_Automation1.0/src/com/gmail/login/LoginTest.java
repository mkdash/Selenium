package com.gmail.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	@Test
	public void loginTest() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("Email")).sendKeys("binayaranjan.jena");
		driver.findElement(By.id("Passwd")).sendKeys("#emerge12345");
		driver.findElement(By.id("signIn")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'gbii')]")).click();
		driver.findElement(By.id("gb_71")).click();
		
		driver.quit();
  }

}
