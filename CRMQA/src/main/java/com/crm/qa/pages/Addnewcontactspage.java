package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Base;

public class Addnewcontactspage extends Base {
	
	//page elements
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement savebutton;
	
	//initiating page factory elements
		public Addnewcontactspage() {
			PageFactory.initElements(driver, this);
		}
		
		public void createNewContact(String titlename, String ftname, String ltname, String comp, String phon) {
			
			Select select= new Select(title);
			select.selectByVisibleText(titlename);
			firstname.sendKeys(ftname);
			lastname.sendKeys(ltname);
			company.sendKeys(comp);
			phone.sendKeys(phon);
			savebutton.click();
			
		}
}
