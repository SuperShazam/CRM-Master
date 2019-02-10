package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.Addnewcontactspage;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class Addnewcontactspagetest extends Base {
	
	Loginpage objloginpage;
	Homepage objhomepage;
	Contactspage objcontactspage;
	Testutil objtestutil;
	Addnewcontactspage objaddnewcontactspage;
	
	String sheetname = "NewContacts";
	
	public Addnewcontactspagetest() {
		
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		objloginpage = new Loginpage();
		objhomepage = new Homepage();
		objcontactspage = new Contactspage();
		objtestutil = new Testutil();
		objaddnewcontactspage= new Addnewcontactspage();

		objloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		objtestutil.switchtoframe();
		objhomepage.clickOnAddNewContact();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data= objtestutil.getTestData(sheetname);
		return data;
		
	}
	
	@Test(dataProvider="getCRMTestData")
	public void verifyAddNewContactspageTest(String title,String firstname,String lastname,String company,String phone) throws InterruptedException {
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		objtestutil.switchtoframe();
		objaddnewcontactspage.createNewContact(title, firstname, lastname, company, phone);
		//objaddnewcontactspage.createNewContact("Mr.", "Harry", "Potter", "Magic", "1234567899");
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
