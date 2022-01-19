package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);
	}

	public void enterToPasswordTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
	}

	public HomePageObject clickToLoginBtn() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);

	}

	public String getEmailEmptyMsg() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_EMPTY_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_EMPTY_MSG);
	}

	public String getEmailInvalidMsg() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_INVALID_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_INVALID_MSG);
	}

	public String getLoginFailMsg() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_NOT_EXITS_LOGIN_FAIL_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_NOT_EXITS_LOGIN_FAIL_MSG);
	}

	public String getCustomerNotFoundMsg() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_NOT_EXIST_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_NOT_EXIST_MSG);
	}

	public String getPasswordEmptyMsg() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_EMPTY_MSG);
		return getElementText(driver, LoginPageUI.PASSWORD_EMPTY_MSG);
	}

	public String getPasswordEmptyLoginFailMsg() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_EMPTY_LOGIN_FAIL_MSG);
		return getElementText(driver, LoginPageUI.PASSWORD_EMPTY_LOGIN_FAIL_MSG);
	}

	public String getPasswordwrongMsg() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_WRONG_MSG);
		return getElementText(driver, LoginPageUI.PASSWORD_WRONG_MSG);
	}
}
