package com.travelagileway.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class userCreditInfo {
	
	WebElement cardtyperadiomaster;
	WebElement cardnum;
	Select ExpiryMonth;
	Select ExpiryYear;
	WebElement userpay;
	
	public userCreditInfo(WebDriver chrome) {
		cardtyperadiomaster = chrome.findElement(By.xpath(" //tbody/tr[1]/td[2]/input[2]"));
	    cardnum = chrome.findElement(By.name("card_number"));
	    ExpiryMonth = new Select(chrome.findElement(By.name("expiry_month")));
	    ExpiryYear = new Select(chrome.findElement(By.name("expiry_year")));
	    userpay = chrome.findElement(By.cssSelector("input[value='Pay now'"));
	}
	
	public void setcardtyperadiomaster() {
		cardtyperadiomaster.click();
	}
	public void setcardnum() {
		cardnum.sendKeys("1234567890");
	}
	public void setExpiryMonth() {
		ExpiryMonth.selectByVisibleText("08");
	}
	public void setExpiryYear() {
		ExpiryYear.selectByVisibleText("2025");
	}
	public void setuserpay() {
		userpay.click();
		
	}
	
	public void userCredit(){
		this.setcardtyperadiomaster();
		this.setcardnum();
		this.setExpiryMonth();
		this.setExpiryYear();
		this.setuserpay();
		
	}

}
