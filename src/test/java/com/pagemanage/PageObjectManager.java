package com.pagemanage;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

/**
 * 
 * @author Muthumani
 * @Description To maintain Page Object Model objects here, create a singleton
 *              class for all POM classes
 * @created Date 06/29/2022
 *
 */
public class PageObjectManager {

	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;
	BookHotelPage bookHotelPage;
	BookingConfirmationPage bookingConfirmationPage;
	CancelBookingPage cancelBookingPage;

	/**
	 * 
	 * @return LoginPage
	 * @Description singleton class for login page POM
	 * @created Date 06/29/2022
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	/**
	 * 
	 * @return SearchHotelPage
	 * @Description singleton class for search hotel page POM
	 * @created Date 06/29/2022
	 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}

	/**
	 * 
	 * @return SelectHotelPage
	 * @Description singleton class for select hotel page POM
	 * @created Date 06/29/2022
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	/**
	 * 
	 * @return BookHotelPage
	 * @Description singleton class for book hotel page POM
	 * @created Date 06/29/2022
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	/**
	 * 
	 * @return BookingConfirmationPage
	 * @Description singleton class for booking confirmation page POM
	 * @created Date 06/29/2022
	 */
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage == null) ? bookingConfirmationPage = new BookingConfirmationPage()
				: bookingConfirmationPage;
	}

	/**
	 * 
	 * @return CancelBookingPage
	 * @Description singleton class for cancel booking page POM
	 * @created Date 06/29/2022
	 * 
	 */
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage == null) ? cancelBookingPage = new CancelBookingPage() : cancelBookingPage;
	}

}
