package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseLib;

/**
 * 
 * @author Muthumani
 * @Description Login page POM which holds all the locators tends to a
 *              WebElement, and use Getters to accessing the elements
 * 
 * @created Date 06/29/2022
 */
public class LoginPage extends BaseLib {
	/**
	 * Default constructor holds the PageFactory and it initialize the WebElement
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "//div[@class=\"auth_error\"]")
	private WebElement errorMessage;
	@FindBy(id = "username")
	private WebElement txtUsername;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;

	/**
	 * Getters
	 */
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @param user
	 * @param pass
	 * @Description Login with valid credentials
	 * @created Date 06/29/2022
	 */
	public void login(String user, String pass) {
		sendData(getTxtUsername(), user);
		sendData(getTxtPassword(), pass);
		click(getBtnLogin());
	}

	/**
	 * @param user
	 * @param pass
	 * @throws AWTException
	 * @Description Login with help of keys
	 * @created Date 06/29/2022
	 */
	public void loginWithKeys(String user, String pass) throws AWTException {
		sendData(getTxtUsername(), user);
		sendData(getTxtPassword(), pass);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		int a=10;
		int b =20;
		int c = 30;
		System.out.println(a-b+c);
		System.out.println("login by using keys");
		
	}

	

}
