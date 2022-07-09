package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseLib;
/**
 * 
 * @author Muthumani
 * @Description Booking Confirmation page POM which holds all the locators tends to a
 *              WebElement, and use Getters to accessing the elements
 * 
 * @created Date 06/29/2022
 */
public class BookingConfirmationPage extends BaseLib {
	/**
	 * Default constructor holds the PageFactory and it initialize the WebElement
	 */
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "order_no")
	private WebElement orderNo;
	
	@FindBy(xpath = "//td[text()=\"Booking Confirmation \"]")
	private WebElement confirmationMessage;

	public WebElement getOrderNo() {
		return orderNo;
	}
/**
 * 
 * @return WebElement
 * @Description To get the WebElement Confirmation message
 * @created Date 06/29/2022
 */
	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
/**
 * 
 * @return String
 * @Description to get the order Id
 * @created Date 06/29/2022
 */
	public String getOrderId() {
		 String orderId = getAttribute(getOrderNo());
		 return orderId;
	}

}
