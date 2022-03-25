package com.travelagileway.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject {
	WebElement uid, pwd, signin ;
	
	public LoginObject(WebDriver chrome) {
		
		 uid = chrome.findElement(By.xpath("//input[@id='username']"));
		 pwd = chrome.findElement(By.xpath("//input[@id='password']"));
	     signin = chrome.findElement(By.xpath("//body/div[@id='container']/form[1]/div[1]/div[1]/p[4]/input[1]\r\n"));
	}
	
	public void setUsername() {
		uid.sendKeys("agileway");
	}

	public void setUserpassword() {
		pwd.sendKeys("testwise");
	}

	public void setUserloginbutton() {
		signin.click();
	}

	public void login() {
		this.setUsername();
		this.setUserpassword();
		this.setUserloginbutton();
	}
}



