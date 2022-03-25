package com.travelagilewa.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	public static WebDriver chrome;
	public static Logger logger;
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		// Initial Extent Reports
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\Datta\\Desktop\\Eclipse_Global_Maven2\\travelagileway\\ExtentReport\\ExtentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Travel");

		// set up report configurations
		spark.config().setDocumentTitle("Test Reports");
		spark.config().setReportName("Selenium Automation");
		spark.config().setTheme(Theme.DARK);

		// add test detail
		extent.setSystemInfo("QA Name", "Tejaswini Surade");
		extent.setSystemInfo("Test Environement", "Development");
		// create test on this page
		test.info("http://travel.agileway.net/login");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Datta\\Desktop\\Eclipse_Global_Maven2\\TravelAgileWay\\drivers\\chromedriver_win32\\chromedriver.exe");
		chrome = new ChromeDriver();
		chrome.get("http://travel.agileway.net/login");
		chrome.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		chrome.manage().window().maximize();
		// Setup Log4j config property
		// logger = Logger.getLogger(Log.class.getName());
		logger = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("Log4j.properties");
		
		// take screenshot
				String screenshotName = "screenshot_for_travel_booking";
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) chrome;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// after execution, you could see a folder "FailedTestsScreenshots" under source
				// folder
				String destination = "C:\\Users\\Datta\\Desktop\\Eclipse_Global_Maven2\\travelagileway\\screenshot"
						+ screenshotName + dateName + ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);

				test.addScreenCaptureFromPath(destination);

				Thread.sleep(5000);
				// test pass status
				test.pass("Test Passed");
				// flush extent reports
				extent.flush();
	}

	@AfterClass
	public void cleanup(){
		chrome.close();
	}

}



//"C:\\Users\\Datta\\Desktop\\Eclipse_Global_Maven2\\TravelAgileWay
//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver_win32//chromedriver.exe");