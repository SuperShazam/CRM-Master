package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class Loginpagetest extends Base {

	Loginpage objloginpage;
	Homepage homepageobj;

	// we will create constructor and call the superclass constructor
	// as the class base constructor have all the code to read the properties file

	public Loginpagetest() {

		// calls superclass constructor in this case constructor of class base
		super();
	}

	// we will create setup method for doing things before test

	@BeforeMethod
	public void setup() {

		// call initialization method for reading properties
		initialization();

		// we will create object of Loginpage class as we will need it to access the
		// methods of loginpage class
		objloginpage = new Loginpage();

		// define the loginpage variable at class level so it can be used through out
		// the project

	}

	@Test  //(enabled = false)
	public void validateloginpagetitletest() {
		String title = objloginpage.validateloginpagetitle();
		//Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		Assert.assertEquals(title, "CRMPRO Log In Screen");
	}
	
	@Test  //(enabled = false)
	public void logintest() throws InterruptedException {
		homepageobj =objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void checkalllinks() {
		objloginpage.validatealllinks();
	}
	

	@AfterMethod
	public void teardown() {
		// this method will close the browser after every method execution
		driver.quit();
	}

}
