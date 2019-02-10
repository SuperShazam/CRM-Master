package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.Testutil;

public class Base {

	// declare webdriver variable as static
	public static WebDriver driver;

	// create property variable prop declare static as it can be used in child
	// classes and test classes also
	public static Properties prop;

	// 1. create constructor of class base
	public Base() {
		// we will read properties in constructor
		// go through how to read the properties file
		try {
			prop = new Properties();

			// provide the path of the properties file as the argument
			FileInputStream ip = new FileInputStream(
					"F:\\Selenium\\Eclipse-Selenium-Workspace\\CRMQA\\src\\main\\java\\com\\crm\\qa"
							+ "\\config\\congif.properties");
			prop.load(ip);
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 2 create initialization method for opening browser
	public void initialization() {
		// we have to read a property value for browser here
		// use prop object to access the property file
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// declare other browser things
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// instead of hardcoding page load time and implicit wait we can take it from
		// util
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// now get the url
		driver.get(prop.getProperty("url"));
	}

}
