package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseLib;

/**
 * 
 * @author Muthumani
 * @Description Cancek Booking Hotel POM which holds all the locators tends to a
 *              WebElement, and use Getters to accessing the elements
 * 
 * @created Date 06/29/2022
 */
public class CancelBookingPage extends BaseLib {
	/**
	 * Default constructor holds the PageFactory and it initialize the WebElement
	 */
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
/**
 * Locators
 */
	public static String orderNum;
	@FindBy(id = "search_result_error")
	private WebElement cancelBookingErr;
	@FindBy(id = "order_no")
	private WebElement orderNo;
	@FindBy(id = "my_itinerary")
	private WebElement btnMyItinerary;
	@FindBy(id = "order_id_text")
	private WebElement orderSearch;
	@FindBy(id = "search_hotel_id")
	private WebElement btnOrderSearch;

	@FindBy(xpath = "//a[text()=\"Booked Itinerary\"]")
	private WebElement Booked_Itinerary;

	@FindBy(id = "check_all")
	private WebElement checkAll;

	@FindBy(xpath = "//input[contains(@value,'Cancel ')]")
	private WebElement cancelOrder;
/**
 * Getters
 */
	public WebElement getCancelBookingErr() {
		return cancelBookingErr;
	}
	
	public static String getOrderNum() {
		return orderNum;
	}

	public WebElement getBooked_Itinerary() {
		return Booked_Itinerary;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getBtnMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getCheckAll() {
		return checkAll;
	}

	public WebElement getMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getOrderSearch() {
		return orderSearch;
	}

	public WebElement getBtnOrderSearch() {

		return btnOrderSearch;
	}

	public WebElement getCancelOrder() {
		return cancelOrder;
	}
/**
 * 
 * @param orderNo
 * @Description Cancel Booking order after the order
 * @created Date 06/29/2022
 */
	public void cancelBooking(String orderNo) {
		click(getBooked_Itinerary());
		sendData(getOrderSearch(), orderNo);
		click(getBtnOrderSearch());
		click(getCheckAll());
		click(getCancelOrder());
		acceptAlert();
	}

}
