package com.expedia.flightsbooking;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclasses.SearchPage;

public class TestNG_TestSuite {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(TestNG_TestSuite.class);

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "E://Development//workspace - Mariusz//Selenium//chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
	}

	@Test
	public void fillBasicInfo() throws Exception {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.fillDestinationTextBox(driver, "Chicago");
		SearchPage.fillDepartureDateTextBox(driver, "12/25/2015");
		SearchPage.fillReturnDateTextBox(driver, "12/31/2015");
		SearchPage.selectFlightAdults(driver, "2");
		SearchPage.clickOnSearchButton(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
