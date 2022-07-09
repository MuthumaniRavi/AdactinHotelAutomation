package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseLib;

/**
 * @author Muthumani
 * @Description Book A Hotel POM which holds all the locators tends to a
 *              WebElement, and use Getters to accessing the elements
 * 
 * @created Date 06/29/2022
 */
public class BookHotelPage extends BaseLib {
	/**
	 * Default constructor holds the PageFactory and it initialize the WebElement
	 */
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//td[text()=\"Booking Confirmation \"]")
	private WebElement confirmationMessage;
	@FindBy(id = "first_name_span")
	private WebElement firstNameErr;
	@FindBy(id = "last_name_span")
	private WebElement lastnameErr;
	@FindBy(id = "address_span")
	private WebElement addressErr;
	@FindBy(id = "cc_num_span")
	private WebElement creaditCardNumErr;
	@FindBy(id = "cc_type_span")
	private WebElement creditCardTypeErr;
	@FindBy(id = "cc_expiry_span")
	private WebElement expiryMonthErr;
	@FindBy(id = "cc_cvv_span")
	private WebElement cc_ccvErr;
	@FindBy(xpath = "//td[text()=\"Book A Hotel \"]")
	private WebElement bookAHotelVerify;
	@FindBy(id = "first_name")
	private WebElement firstName;
	@FindBy(id = "last_name")
	private WebElement lastName;
	@FindBy(id = "address")
	private WebElement address;
	@FindBy(id = "cc_num")
	private WebElement ccNo;
	@FindBy(id = "cc_type")
	private WebElement ccType;
	@FindBy(id = "cc_exp_month")
	private WebElement ccExp;
	@FindBy(id = "cc_exp_year")
	private WebElement ccYear;
	@FindBy(id = "cc_cvv")
	private WebElement ccCvv;
	@FindBy(id = "book_now")
	private WebElement bookNow;

	/**
	 * Getters
	 */
	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}

	public WebElement getCreaditCardNumErr() {
		return creaditCardNumErr;
	}

	public WebElement getCreditCardTypeErr() {
		return creditCardTypeErr;
	}

	public WebElement getFirstNameErr() {
		return firstNameErr;
	}

	public WebElement getLastnameErr() {
		return lastnameErr;
	}

	public WebElement getAddressErr() {
		return addressErr;
	}

	public WebElement getExpiryMonthErr() {
		return expiryMonthErr;
	}

	public WebElement getCc_ccvErr() {
		return cc_ccvErr;
	}

	public WebElement getBookAHotelVerify() {
		return bookAHotelVerify;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcNo() {
		return ccNo;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcExp() {
		return ccExp;
	}

	public WebElement getCcYear() {
		return ccYear;
	}

	public WebElement getCcCvv() {
		return ccCvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param ccNo
	 * @param ccType
	 * @param ccExp
	 * @param ccYear
	 * @param ccCvv
	 * @Description book hotel verification
	 * @created Date 06/29/2022
	 */
	public void bookHotel(String firstname, String lastname, String address, String ccNo, String ccType, String ccExp,
			String ccYear, String ccCvv) {
		sendData(getFirstName(), firstname);
		sendData(getLastName(), lastname);
		sendData(getAddress(), address);
		sendData(getCcNo(), ccNo);
		selectByValue(getCcType(), ccType);
		selectByVisibleText(getCcExp(), ccExp);
		selectByVisibleText(getCcYear(), ccYear);
		sendData(getCcCvv(), ccCvv);
		click(getBookNow());

	}

	/**
	 * @Description click the book hotel without entering information
	 * @created Date 06/29/2022
	 */
	public void bookHotel() {
		click(getBookNow());
	}


}
