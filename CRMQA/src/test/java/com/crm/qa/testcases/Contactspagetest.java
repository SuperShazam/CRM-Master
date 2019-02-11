package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

class Contactspagetest extends Base {

	Loginpage objloginpage;
	Homepage objhomepage;
	Contactspage objcontactspage;
	Testutil objtestutil;

	public Contactspagetest() {

		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		objloginpage = new Loginpage();
		objhomepage = new Homepage();
		objcontactspage = new Contactspage();
		objtestutil = new Testutil();

		objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		objtestutil.switchtoframe();
		objhomepage.clickoncontactslink();
				

	}

	@Test
	public void verifycontactslabletest() throws InterruptedException {
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		objtestutil.switchtoframe();
		Assert.assertTrue(objcontactspage.verifycontactslable(),"contacts lable missing");
	}
	
	@Test//(enabled=false)
	public void selectcontactbynametest() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		objtestutil.switchtoframe();
		objcontactspage.selectcontactbyname("Pankaj Shinde");
		
	}

	@AfterMethod
	public void teardown() {

		driver.quit();

	}

}
