package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseLib;

/**
 * 
 * @author Muthumani
 * @Description Search Hotel page POM which holds all the locators tends to a
 *              WebElement, and use Getters to accessing the elements
 * 
 * @created Date 06/29/2022
 */
public class SearchHotelPage extends BaseLib {
	/**
	 * Default constructor holds the PageFactory and it initialize the WebElement
	 */
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(id = "location_span")
	private WebElement locationErr;
	@FindBy(id = "checkin_span")
	private WebElement checkInDateError;
	@FindBy(id = "checkout_span")
	private WebElement checkOutDateError;
	@FindBy(xpath = "//td[text()=\"Select Hotel \"]")
	private WebElement selectHotelverify;

	@FindBy(id = "username_show")
	private WebElement welcomeMessage;

	@FindBy(name = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement roomNo;

	@FindBy(id = "datepick_in")
	private WebElement dateIn;

	@FindBy(id = "datepick_out")
	private WebElement dateout;

	@FindBy(id = "adult_room")
	private WebElement adultRoom;

	@FindBy(id = "child_room")
	private WebElement childRoom;

	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	/**
	 * Getters
	 */
	public WebElement getLocationErr() {
		return locationErr;
	}

	public WebElement getSelectHotelverify() {
		return selectHotelverify;
	}

	public WebElement getCheckInDateError() {
		return checkInDateError;
	}

	public WebElement getCheckOutDateError() {
		return checkOutDateError;
	}

	public WebElement getWelcomeMessage() {
		return welcomeMessage;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNo() {
		return roomNo;
	}

	public WebElement getDateIn() {
		return dateIn;
	}

	public WebElement getDateout() {
		return dateout;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	/**
	 * 
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param roomNo
	 * @param dateIn
	 * @param dateOut
	 * @param adultRoom
	 * @param childRomm
	 * @Description Search Hotel for user requirement
	 * @created Date 06/29/2022
	 */
	public void searchHotel(String location, String hotels, String roomType, String roomNo, String dateIn,
			String dateOut, String adultRoom, String childRomm) {
		selectByValue(getLocation(), location);
		selectByValue(getHotels(), hotels);
		selectByValue(getRoomType(), roomType);
		selectByValue(getRoomNo(), roomNo);
		clear(getDateIn());
		sendData(getDateIn(), dateIn);
		clear(getDateout());
		sendData(getDateout(), dateOut);
		selectByValue(getAdultRoom(), adultRoom);
		selectByValue(getChildRoom(), childRomm);
		click(getBtnSubmit());
	}

	/**
	 * 
	 * @param location
	 * @param roomNo
	 * @param dateIn
	 * @param dateOut
	 * @param adultRoom
	 * @Description Search Hotel with mandatory fields
	 * @created Date 06/29/2022
	 */
	public void searchHotel(String location, String roomNo, String dateIn, String dateOut, String adultRoom) {
		selectByValue(getLocation(), location);
		selectByValue(getRoomNo(), roomNo);
		clear(getDateIn());
		sendData(getDateIn(), dateIn);
		clear(getDateout());
		sendData(getDateout(), dateOut);
		selectByValue(getAdultRoom(), adultRoom);
		click(getBtnSubmit());
	}

	/**
	 * @Description To submit the search hotel page with pointing the location of
	 *              the hotel
	 * @created Date 06/29/2022
	 */
	public void searchHotel() {
		click(getBtnSubmit());
	}

}
