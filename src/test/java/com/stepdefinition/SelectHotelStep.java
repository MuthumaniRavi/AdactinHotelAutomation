package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseLib;
import com.pagemanage.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Muthumani
 * @Description select hotel steps
 * @created Date 06/29/2022
 *
 */
public class SelectHotelStep extends BaseLib{
	PageObjectManager pom = new PageObjectManager();
/**
 * @Description selecct hotel step User should select the hotel and continue
 * @created Date 06/29/2022
 */
	@Then("User should select the hotel and continue")
	public void userShouldSelectTheHotelAndContinue() {
		pom.getSelectHotelPage().selectHotel();
	}
/**
 * 
 * @param selectVerify
 * @Description selecct hotel step User verify message after select
 * @created Date 06/29/2022
 */
	@Then("User verify message after select {string}")
	public void userVerifyMessageAfterSelect(String selectVerify) {
		Assert.assertEquals("verify book a hotel message", selectVerify, getText(pom.getSelectHotelPage().getBookAHotelVerify()));
	}
/**
 * @Description selecct hotel step User click Continue without select
 * @created Date 06/29/2022
 */
	@Then("User click Continue without select")
	public void userClickContinueWithoutSelect() {
		pom.getSelectHotelPage().withoutSelectHotel();
	}
/**
 * 
 * @param select_HotelErr
 * @Description selecct hotel step User verify error message of without select the hotel
 * @created Date 06/29/2022
 */
	@Then("User verify error message of without select the hotel {string}")
	public void userVerifyErrorMessageOfWithoutSelectTheHotel(String select_HotelErr) {
		Assert.assertEquals("verify error message", select_HotelErr, getText(pom.getSelectHotelPage().getSelectHotelErr()));
	}
}
