package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseLib;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Muthumani
 * @Description Hooks class it was executed before and after the execution each
 *              snippet execution and takes the screenshot after the each
 *              scenario completed
 * @created Date 06/29/2022
 */
public class HooksClass extends BaseLib {
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description Execute before the each scenario, load the browser and pass the URL
	 * @created Date 06/29/2022
	 */
	@Before
	public void beforeClass() throws FileNotFoundException, IOException {
		browse(getPropertyFileValue("browserType"), getPropertyFileValue("url"));
		implicitlyWait(10);
	}

	/**
	 * @param scenario
	 * @Description Execute after the each scenario and takes screenshot 
	 * @created Date 06/29/2022
	 */
	@After
	public void afterClass(Scenario scenario) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshotAs, "Every Scenario");
		closeCurrentWindow();
	}
}
