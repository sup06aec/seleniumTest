package com.web.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.web.qa.util.TestUtil;
import com.web.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() throws IOException {
		try {
			prop= new Properties();
//			String prjpath = System.getProperty("user.DIR");
//			FileInputStream ip = new FileInputStream(prjpath+"/src/main/java/com/web/qa/config/config.properties");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/web"
					+ "/qa/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException exp) {
			
		}catch (IOException exp) {
			
		}
			

			
		}
	
	
	public static void initialization() throws IOException {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:/Supriya/driver/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
			else if(browserName.equals("FF")) {
			System.setProperty("webdriver.geko.driver", "C:/Supriya/driver/gekodriver");
			driver = new FirefoxDriver();	
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
