
package com.travelagileway.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlight {
	
	  WebElement Usertriptype; 
	  WebElement dropdown,dropdown1;
	  WebElement Depday,DepMonth,Retday,RetMonth;
	  WebElement conti;
	
	  public SelectFlight(WebDriver chrome) {
		  
	  Usertriptype =chrome.findElement((By.xpath("//tbody/tr[1]/td[2]/input[1]")));
	  
	  dropdown = chrome.findElement(By.xpath("//tbody/tr[2]/td[2]/select[1]"));
	  dropdown1 = chrome.findElement(By.xpath("//tbody/tr[3]/td[2]/select[1]"));
	  
	  Depday = chrome.findElement(By.xpath("//select[@id='departDay']"));
	  DepMonth = chrome.findElement(By.xpath("//select[@id='departMonth']"));
	  
	  Retday = chrome.findElement(By.xpath("//select[@id='returnDay']")); 
	  RetMonth  = chrome.findElement(By.xpath("//select[@id='returnMonth']"));
	  
	  conti = chrome.findElement(By.xpath("//body/div[@id='container']/form[1]/input[1]"));
	  }
	 
    public void setusertrip() {
    	Usertriptype.click(); 
    	}
		 
	public void setdropdown() {
		dropdown.sendKeys("Newyork");
	}
	public void setdropdown1() {
		dropdown1.sendKeys("Sydney");
	}
	public void setDepday() {
		Depday.sendKeys("03");
	}
	public void setDepMonth() {
		DepMonth.sendKeys("January 2021");
	}
	public void setRetday() {
		Retday.sendKeys("07");
	}
	public void setRetMonth() {
		RetMonth.sendKeys("March 2021");
	}
	public void userconti() {
		conti.click();
	}
	
	public void userinfo() {
		this.setusertrip();
		this.setdropdown();
		this.setdropdown1(); 
		this.setDepday();
		this.setRetday();
		this.setRetMonth();
		this.userconti();
	}
}

