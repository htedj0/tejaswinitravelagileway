package com.travelagileway.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userPersonalInfo {

	WebElement ufname;
	WebElement ulname;
	WebElement usernext;
	
	
	public userPersonalInfo(WebDriver chrome) {
		ufname = chrome.findElement(By.name("passengerFirstName"));
		ulname = chrome.findElement(By.name("passengerLastName"));
		usernext =chrome.findElement(By.xpath("//body[1]/div[1]/form[1]/input[3]"));
	}
	
	
	public void setufname() {
		ufname.sendKeys("Tejaswini");
	}
	public void setulname() {
		ulname.sendKeys("Surade");
	}
	public void setusernext() {
	usernext.click();
	}
	
	public void personalinfo() {
		
		this.setufname();
		this.setulname();
		this.setusernext();
		
	}

}



