package com.web.qa.pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.qa.base.TestBase;

public class IntroPage extends TestBase{

	

	@FindBy(id="dropdownCurrency")
	WebElement myaccount;
	
	@FindBy(linkText="Login")
	WebElement loginBtn;
	
	public IntroPage() throws IOException {
		
		PageFactory.initElements(driver,this);
	}

	public String validateIntroPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage login() {
		
		loginBtn.click();
		return new LoginPage();//After the click, the page jumps to HomePage so we have to change the void to HomePage
	}

}

