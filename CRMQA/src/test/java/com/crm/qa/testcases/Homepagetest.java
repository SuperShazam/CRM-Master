package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.Addnewcontactspage;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class Homepagetest extends Base {

	Loginpage objloginpage;
	Homepage objhomepage;
	Testutil objtestutil;
	Contactspage objcontactspage;
	Addnewcontactspage objAddNewContactsPage;

	public Homepagetest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		objloginpage = new Loginpage();
		objhomepage = objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		objtestutil = new Testutil();
		objcontactspage= new Contactspage();
		objAddNewContactsPage= new Addnewcontactspage();
	}

	@Test //(enabled=false)//(priority=1)
	public void verifyhomepagetitletest() {
		String homepagetitle = objhomepage.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepage title not matched");
	}

	@Test//(enabled=false)//(priority = 2)
	public void verifyusernametest() {
		objtestutil.switchtoframe();
		Assert.assertTrue(objhomepage.verifyusername());

	}
	
	@Test//(enabled=false)//(priority=3)
	public void verifycontactslinkTest() {
		objtestutil.switchtoframe();
		objcontactspage= objhomepage.clickoncontactslink();
	}
	
	@Test
	public void clickOnAddNewContact() {
		objtestutil.switchtoframe();
		objAddNewContactsPage=objhomepage.clickOnAddNewContact();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
