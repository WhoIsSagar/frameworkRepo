package com.tutorials.ninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest {
public WebDriver driver;
public SoftAssert softassert;

	@Test(priority = 1)
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.get("https://tutorialsninja.com/demo/");
	
	}
	
	
}
