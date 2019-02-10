package com.crm.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class Homepage extends Base {

	Actions action;
	

	// we will write all the elements present on the home page

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactslink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealslink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	@FindBy(xpath="//td[contains(text(),'User: Pankaj Shinde')]")
	WebElement usernamelable;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	

	public Homepage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyhomepagetitle() {

		return driver.getTitle();

	}

	public Contactspage clickoncontactslink() {

		contactslink.click();
		return new Contactspage();
	}

	public Dealspage clickondealslink() {

		dealslink.click();
		return new Dealspage();
	}
	
	public Taskpage clickontaskslink() {

		tasklink.click();
		return new Taskpage();
	}
	
	public boolean verifyusername() {
		
		return usernamelable.isDisplayed();
	}
	
	public Addnewcontactspage clickOnAddNewContact() {
		
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContact.click();
		return new Addnewcontactspage(); 
		
		
	}

}
