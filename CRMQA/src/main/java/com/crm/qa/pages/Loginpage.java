package com.crm.qa.pages;

import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class Loginpage extends Base {

	// String url="";
	// we have to define page factory(i.e object repository)
	// below definitions are called page factories

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbutton;

	@FindBy(linkText = "https://www.freecrm.com/register/")
	WebElement signup;

	@FindBy(className = "img-responsive")
	WebElement freecrmlogo;

	@FindBy(linkText = "https://www.freecrm.com/features.html")
	WebElement features;

	@FindBy(linkText = "https://www.freecrm.com/pricing.html")
	WebElement pricing;

	@FindBy(linkText = "https://www.freecrm.com/customers.html")
	WebElement customers;

	@FindBy(linkText = "https://www.freecrm.com/contact.html")
	WebElement contact;

	@FindBy(xpath = "//button[@class='left carousel-control skrollable skrollable-between']")
	WebElement leftcarousel;

	@FindBy(xpath = "//button[@class='right carousel-control skrollable skrollable-between']")
	WebElement rightcarousel;

	@FindBy(xpath = "//span[@class='mouse']")
	WebElement spanbutton;

	// After defining all the page factory elements or objects we have to initialize
	// those
	// for that we can use following method by creating a method

	public Loginpage() {

		PageFactory.initElements(driver, this);
	}

	// Now we are going to create action methods which will return output of method

	public String validateloginpagetitle() {
		return driver.getTitle();

	}

	public boolean validatecrmlogo() {

		return freecrmlogo.isDisplayed();

	}

	public boolean validatespanbutton() {
		return spanbutton.isDisplayed();
	}

	public boolean validateleftleftcarousel() {
		return leftcarousel.isDisplayed();
	}

	public boolean validaterightcarousel() {
		return rightcarousel.isDisplayed();
	}

	public Homepage login(String uname, String pwd) throws InterruptedException {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginbutton.click();

		// this method after clicking on login will go to homepage so it should
		// return object of homepage

		return new Homepage();
	}

	public void validatealllinks() {

		String homePage = "//www.freecrm.com/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
