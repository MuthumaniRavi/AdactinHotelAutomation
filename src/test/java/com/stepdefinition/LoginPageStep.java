package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseLib;
import com.pagemanage.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Muthumani
 * @Description login page steps
 * @created Date 06/29/2022
 */
public class LoginPageStep extends BaseLib {
	PageObjectManager pom = new PageObjectManager();
/**
 * @throws FileNotFoundException
 * @throws IOException
 * @Description login page step User is on adactin Hotel page
 * @created Date 06/29/2022
 */
	@Given("User is on adactin Hotel page")
	public void userIsOnAdactinHotelPage() throws FileNotFoundException, IOException {
	}
/**
 * @param username
 * @param password
 * @Description login page step User perform login
 * @created Date 06/29/2022
 */
	@When("User perform login {string} , {string}")
	public void userPerformLogin(String username, String password) {
		pom.getLoginPage().login(username, password);
	}
/**
 * 
 * @param username
 * @param password
 * @throws AWTException
 * @Description login page step User perform login with keys
 * @created Date 06/29/2022
 */
	@When("User perform login with keys {string} , {string}")
	public void userPerformLoginWithKeys(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithKeys(username, password);
	}
/**
 * @param expected
 * @Description login page step User verify error contains after login
 * @created Date 06/29/2022
 */
	@Then("User verify error contains after login{string}")
	public void userVerifyErrorContainsAfterLogin(String expected) {
		Assert.assertTrue("Verify Error Message", getText(pom.getLoginPage().getErrorMessage()).contains(expected));

	}

}
