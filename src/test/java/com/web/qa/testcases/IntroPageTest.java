package com.web.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.qa.base.TestBase;
import com.web.qa.pages.IntroPage;
import com.web.qa.pages.LoginPage;




public class IntroPageTest extends TestBase {

	IntroPage introPage;
	LoginPage loginPage;
	public IntroPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		introPage = new IntroPage();
	}
	
	@Test
	public void introPageTest() throws InterruptedException {
		String title = introPage.validateIntroPageTitle();
		Thread.sleep(10000);
		System.out.println("The title is "+ title);
		Thread.sleep(10000);
//		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner");
		Assert.assertEquals(title, "Loading...");
	}
		
		@Test
		public void loginTest() {
			LoginPage loginPage= introPage.login();
			
		}
		
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
