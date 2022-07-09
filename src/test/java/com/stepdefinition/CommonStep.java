package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseLib;
import com.pagemanage.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Muthumani
 * @Description common step for all scenarios
 * @created Date 06/29/2022
 *
 */
public class CommonStep extends BaseLib {
	PageObjectManager pom = new PageObjectManager();
/**
 * 
 * @param welcome_msg
 * @Description common step for all scenarios and User verify success message after login
 * @created Date 06/29/2022
 */
	@Then("User verify success message after login {string}")
	public void userVerifySuccessMessageAfterLogin(String welcome_msg) {
		Assert.assertEquals("Verify welcome message", welcome_msg, getAttribute(pom.getSearchHotelPage().getWelcomeMessage()));
	}
}
