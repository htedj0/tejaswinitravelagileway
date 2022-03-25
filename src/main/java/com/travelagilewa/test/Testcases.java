package com.travelagilewa.test;

import org.testng.annotations.Test;

import com.travelagileway.pageobject.LoginObject;
import com.travelagileway.pageobject.SelectFlight;
import com.travelagileway.pageobject.userCreditInfo;
import com.travelagileway.pageobject.userPersonalInfo;

public class Testcases extends BaseClass {
	@Test(priority = 0)
	public void loginTest() throws InterruptedException {
		chrome.get("http://travel.agileway.net/login");
		// calling LoginObject
		// LoginObject loginobj = PageFactory.initElements(chrome, LoginObject.class);
		// loginobj.login();
		LoginObject lobj = new LoginObject(chrome);
		lobj.login();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void userflight() throws InterruptedException {
		// calling SelectFlight object
		SelectFlight sf = new SelectFlight(chrome);
		sf.userinfo();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void userinfo() throws InterruptedException {
		// call userPersonalInfo
		userPersonalInfo upi = new userPersonalInfo(chrome);
		upi.personalinfo();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void pay() throws InterruptedException {
		// call userCreditInfo
		userCreditInfo uci = new userCreditInfo(chrome);
		uci.userCredit();
		Thread.sleep(3000);
	}

}
