package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	
	
	WebDriver driver;

	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h5")
	WebElement loginText;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="[type='submit']")
	WebElement submitButton;
	
	public boolean visibilityOfLoginText()
	{
		return loginText.isDisplayed();
	}
	
	public void setUsername(String un)
	{
		username.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		username.sendKeys(pwd);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
}
