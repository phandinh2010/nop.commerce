package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterBtn() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isSuccessMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isLastNameEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_EMPTY_MSG);
		return isElementDisplayed(driver, RegisterPageUI.LAST_NAME_EMPTY_MSG);
	}

	public boolean isPaswordEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_EMPTY_MSG);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_EMPTY_MSG);
	}

	public boolean isConfirmPasswordEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_MSG);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_MSG);
	}

//	public boolean isEmailErrorMsgDisplay() {
//		waitForElementVisible(driver, RegisterPageUI.EMAIL_INVALID_MSG);
//		return isElementDisplayed(driver, RegisterPageUI.EMAIL_INVALID_MSG);
//	}

	public boolean isEmailEmptyEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EMPTY_MSG);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EMPTY_MSG);
	}

	public String getEmailEmptyEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EMPTY_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_EMPTY_MSG);
	}

	
	public boolean isEmailInvalidErrorMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_INVALID_MSG);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_INVALID_MSG);
	}

	public boolean isEmailExistErrorMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXIST_MSG);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EXIST_MSG);
	}

	public boolean isPassworInvaliddErrorMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_INVALID_MSG);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_INVALID_MSG);
	}

	public boolean isConfirmPassworInvaliddErrorMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_INVALID_MSG);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_INVALID_MSG);
	}

	public boolean isFistNameEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_EMPTY_MSG);
		return isElementDisplayed(driver, RegisterPageUI.FIRST_NAME_EMPTY_MSG);
	}
	public String getFistNameEmptyMsgDisplay() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_EMPTY_MSG);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_EMPTY_MSG);
	}

	public String getTextEmailExistErrorMsgDisplay() {		
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXIST_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_EXIST_MSG);
	}

	public void clickToContinueBtn() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);		
		
	}



}
