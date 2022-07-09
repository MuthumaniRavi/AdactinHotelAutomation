package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseLib;

/**
 * 
 * @author Muthumani
 * @Description Select Hotel POM which holds all the locators tends to a
 *              WebElement, and use Getters to accessing the elements
 * 
 * @created Date 06/29/2022
 */
public class SelectHotelPage extends BaseLib {
	/**
	 * Default constructor holds the PageFactory and it initialize the WebElement
	 */
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//td[text()=\"Book A Hotel \"]")
	private WebElement bookAHotelVerify;

	@FindBy(xpath = "//td[text()=\"Select Hotel \"]")
	private WebElement selectHotelverify;

	@FindBy(id = "radiobutton_0")
	private WebElement selectHotel;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(id = "radiobutton_span")
	private WebElement selectHotelErr;

	/**
	 * Getters
	 */
	public WebElement getBookAHotelVerify() {
		return bookAHotelVerify;
	}

	public WebElement getSelectHotelErr() {
		return selectHotelErr;
	}

	public WebElement getSelectHotelverify() {
		return selectHotelverify;
	}

	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	/**
	 * @Description select the hotel
	 * @created Date 06/29/2022
	 */
	public void selectHotel() {
		click(getSelectHotel());
		click(getBtnContinue());
	}

	/**
	 * @Description without selecting the hotel.
	 * @created Date 06/29/2022
	 */
	public void withoutSelectHotel() {
		click(getBtnContinue());
	}

}
