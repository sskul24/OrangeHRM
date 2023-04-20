package com.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.IndexPage;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeTest()
	public void launchApplication()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0040S0744\\Downloads\\Selenium Notes\\drivers\\gecodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	
	@Test()
	public void verifyApplicationLaunchedSuccessfully()
	{
		IndexPage indexPage=new IndexPage(driver);
		Assert.assertTrue(indexPage.visibilityOfLoginText());
		
			
	}
	
	@Test
	public void verifyTitle()
	{
		IndexPage indexPage=new IndexPage(driver);
		indexPage.setUsername("Admin");
		indexPage.setPassword("admin123");
		indexPage.clickOnSubmit();
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@AfterTest()
	public void close()
	{
		driver.close();
	}
}
