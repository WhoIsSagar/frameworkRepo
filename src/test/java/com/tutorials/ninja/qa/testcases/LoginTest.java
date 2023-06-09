package com.tutorials.ninja.qa.testcases;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

	public WebDriver driver;
	public SoftAssert softassert;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	
	@Test(priority =1 )
	public void LoginWithCorrectCredentials() {
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("sagarhanjhra97@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		softassert = new SoftAssert();
		softassert.assertTrue(driver.findElement(By.linkText("Edit Yoyr Account Information")).isDisplayed());
		softassert.assertAll();
		driver.quit();
		
	}
	@Test (priority=2)
	public void verifyLoginWithValidEmailInvalidPassword() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("sagarhanjhra97@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(driver.findElement(By.linkText("Edit Yoyr Account Information")).isDisplayed());
		softassert.assertAll();
		driver.quit();
		String expectedWarning = "Warning: No match ";
		String actualWarning = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible")).getText();
		softassert.assertTrue(actualWarning.contains(expectedWarning));
		
		
	}
	
	@Test(priority = 3 )
	public void verifyLoginWithInValidEmailvalidPassword(){
		
	}
	@Test(priority=4 )
	public void verifyLoginWithInValidEmailInvalidPassword() {
		
	}
	@Test(priority =5 )
	public void verifyLoginWithoutEnteringDetails() {
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
}

