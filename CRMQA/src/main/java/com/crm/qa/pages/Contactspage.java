package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;
import com.crm.qa.util.Testutil;

public class Contactspage extends Base {
	
	Testutil objtestutil;
	
	//@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactslable;
	
	
	
	//initiating page factory elements
	public Contactspage() {
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	public boolean verifycontactslable() {
		//objtestutil = new Testutil();	
		//objtestutil.switchtoframe();
		return contactslable.isDisplayed();
		
	}
	
	public void selectcontactbyname(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
	+"preceding-sibling::td[@class='datalistrow']//input[@name=''contact_id]")).click();
	}

}
