package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseLib;
import com.pagemanage.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Muthumani
 * @Description search hotel steps
 * @created Date 06/29/2022
 *
 */
public class SearchHotelStep extends BaseLib{
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param roomNo
	 * @param dateIn
	 * @param dateOut
	 * @param adultRoom
	 * @param childRomm
	 * @Description search hotel step User should search and enter the all fields
	 * @created Date 06/29/2022
	 */
	@Then("User should search and enter the all fields{string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchAndEnterTheAllFieldsAnd(String location, String hotels, String roomType, String roomNo,
			String dateIn, String dateOut, String adultRoom, String childRomm) {
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, roomNo, dateIn, dateOut, adultRoom, childRomm);
	}

	/**
	 * @param select_hotel
	 * @Description search hotel step User should verify message after search
	 * @created Date 06/29/2022
	 */
	@Then("User should verify message after search {string}")
	public void userShouldVerifyAfterSearch(String select_hotel) {
		Assert.assertEquals("Verify Select Hotel", select_hotel, getText(pom.getSearchHotelPage().getSelectHotelverify()));
	}

	/**
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param roomNo
	 * @param dateIn
	 * @param dateOut
	 * @param adultRoom
	 * @param childRomm
	 * @Description search hotel step User should search and enter the fields
	 * @created Date 06/29/2022
	 */
	@Then("User should search and enter the fields{string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchAndEnterTheFieldsAnd(String location, String hotels, String roomType, String roomNo,
			String dateIn, String dateOut, String adultRoom, String childRomm) {
		pom.getSearchHotelPage().searchHotel(location, roomNo, dateIn, dateOut, adultRoom);
	}

	/**
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param roomNo
	 * @param dateIn
	 * @param dateOut
	 * @param adultRoom
	 * @param childRomm
	 * @Description search hotel step User should search and enter the all fields
	 *              with existing date
	 * @created Date 06/29/2022
	 */
	@Then("User should search and enter the all fields with existing date{string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchAndEnterTheAllFieldsWithExistingDateAnd(String location, String hotels, String roomType,
			String roomNo, String dateIn, String dateOut, String adultRoom, String childRomm) {
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, roomNo, dateIn, dateOut, adultRoom, childRomm);
	}

	/**
	 * @param checkInDateErr
	 * @param checkOutDateErr
	 * @Description search hotel step User verify error message dateCheckingIn Out
	 *              after search
	 * @created Date 06/29/2022
	 */
	@Then("User verify error message dateCheckingIn Out after search {string},{string}")
	public void userVerifyErrorMessageDateCheckingInOutAfterSearch(String checkInDateErr, String checkOutDateErr) {
		Assert.assertEquals("Verify Check in date Error", checkInDateErr, getText(pom.getSearchHotelPage().getCheckInDateError()));
		Assert.assertEquals("Verify Check Out date Error", checkOutDateErr, getText(pom.getSearchHotelPage().getCheckOutDateError()));
	}

	/**
	 * @param LocationErr
	 * @Description search hotel step User verify error message after search
	 * @created Date 06/29/2022
	 */
	@Then("User verify error message after search {string}")
	public void userVerifyErrorMessageAfterSearch(String LocationErr) {
		pom.getSearchHotelPage().searchHotel();
		Assert.assertEquals("Verify location select Error", LocationErr, getText(pom.getSearchHotelPage().getLocationErr()));
	}

}
