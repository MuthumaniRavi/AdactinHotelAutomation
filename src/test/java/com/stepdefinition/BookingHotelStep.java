package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseLib;
import com.pagemanage.PageObjectManager;
//import io.cucumber.datatable.DataTable;

import cucumber.api.java.en.Then;

/**
 * @author Muthumani
 * @Description Booking Hotel page steps
 * @created Date 06/29/2022
 */
public class BookingHotelStep extends BaseLib{
	PageObjectManager pom = new PageObjectManager();
/**
 * @param firstname
 * @param lastname
 * @param address
 * @param dataTable
 * @Description Booking Hotel page step User should enter all the fields and click Book Now
 * @created Date 06/29/2022
 */
	@Then("User should enter all the fields and click Book Now {string},{string},{string} and save generated orderID")
	public void userShouldEnterAllTheFieldsAndClickBookNowAndSaveGeneratedOrderID(String firstname, String lastname,
			String address, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> m = dataTable.asMaps();
		pom.getBookHotelPage().bookHotel(firstname, lastname, address, m.get(0).get("CreditCardNo"),
				m.get(0).get("CreditCardType"), m.get(0).get("ExpMonth"), m.get(0).get("ExpYear"),
				m.get(0).get("CVVNumber"));
	}
/**
 * @param bookNowVerify
 * @Description Booking Hotel page step User should verify message after click Book Now 
 * @created Date 06/29/2022
 */
	@Then("User should verify message after click Book Now {string}")
	public void userShouldVerifyMessageAfterClickBookNow(String bookNowVerify) {
		
		Assert.assertEquals("verify booking confirmation", bookNowVerify, getText(pom.getBookHotelPage().getConfirmationMessage()));
		
	}
/**
 * @param string
 * @param string2
 * @param string3
 * @param dataTable
 * @Description Booking Hotel page step User not enter all the fields and click Book Now
 * @created Date 06/29/2022
 */
	@Then("User not enter all the fields and click Book Now {string},{string}, {string} and save generated orderID")
	public void userNotEnterAllTheFieldsAndClickBookNowAndSaveGeneratedOrderID(String string, String string2,
			String string3, io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().bookHotel();
	}
/**
 * @param firstnameErr
 * @param lastnameErr
 * @param addressErr
 * @param ccNumErr
 * @param ccTypeErr
 * @param ccExpErr
 * @param ccvErr
 * @Description Booking Hotel page step User should verify error message after click Book Now
 * @created Date 06/29/2022
 */
	@Then("User should verify error message after click Book Now {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyErrorMessageAfterClickBookNowAnd(String firstnameErr, String lastnameErr,
			String addressErr, String ccNumErr, String ccTypeErr, String ccExpErr, String ccvErr) {
		Assert.assertEquals("verify firstname error", firstnameErr, getText(pom.getBookHotelPage().getFirstNameErr()));

		Assert.assertEquals("verify lastname error", lastnameErr, getText(pom.getBookHotelPage().getLastnameErr()));

		Assert.assertEquals("verify address error", addressErr, getText(pom.getBookHotelPage().getAddressErr()));

		Assert.assertEquals("verify ccNum error", ccNumErr, getText(pom.getBookHotelPage().getCreaditCardNumErr()));

		Assert.assertEquals("verify ccType error", ccTypeErr, getText(pom.getBookHotelPage().getCreditCardTypeErr()));

		Assert.assertEquals("verify expMontth error", ccExpErr, getText(pom.getBookHotelPage().getExpiryMonthErr()));

		Assert.assertEquals("verify ccv error", ccvErr, getText(pom.getBookHotelPage().getCc_ccvErr()));

		
		
	}

}
