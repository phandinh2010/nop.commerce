package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	
	public RegisterPageObject (WebDriver driver) {
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

	public boolean isFistNameErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLastNameErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPaswordErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailEmptyErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailInvalidErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailExistErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPassworInvaliddErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isConfirmPassworInvaliddErrorMsgDisplay() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
