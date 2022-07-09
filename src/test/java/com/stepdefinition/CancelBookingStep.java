package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseLib;
import com.pagemanage.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @author Muthumani
 * @Description Cancel Booking page steps
 * @created Date 06/29/2022
 */
public class CancelBookingStep extends BaseLib{
	PageObjectManager pom = new PageObjectManager();
/**
 * @Description Cancel Booking page step User should cancel the generated order Id
 * @created Date 06/29/2022
 */
	@Then("User should cancel the generated order Id")
	public void userShouldCancelTheGeneratedOrderId() {
		BaseLib.implicitlyWait(30);
		pom.getCancelBookingPage().cancelBooking(pom.getBookingConfirmationPage().getOrderId());
	}
/**
 * @param cancel_Msg
 * @Description Cancel Booking page step User should verify the cancel message
 * @created Date 06/29/2022
 */
	@Then("User should verify the cancel message {string}")
	public void userShouldVerifyTheCancelMessage(String cancel_Msg) {
		
		Assert.assertEquals("verify cancel message", cancel_Msg, getText(pom.getCancelBookingPage().getCancelBookingErr()));

	}
/**
 * @param existing_OrderId
 * @Description Cancel Booking page step User should cancel the existing orderID
 * @created Date 06/29/2022
 */
	@Then("User should cancel the existing orderID {string}")
	public void userShouldCancelTheExistingOrderID(String existing_OrderId) {
		pom.getCancelBookingPage().cancelBooking(existing_OrderId);
	}
}
