package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);

	}		

	public ProductPageObject clickToAProduct(String nameProduct) {
		waitForElementVisible(driver, HomePageUI.SELECT_A_PRODUCT, nameProduct);
		clickToElement(driver, HomePageUI.SELECT_A_PRODUCT, nameProduct);
		return PageGeneratorManager.getProductPage(driver);
	}

	
	public void enterKeywordSearchTextboxAtHomePage(String string) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX_AT_HOME_PAGE);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX_AT_HOME_PAGE, string);
	}
	
//	public void enterKeywordSearchTextboxAtSearchPage(String string) {
//		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX_AT_SEARCH_PAGE);
//		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX_AT_SEARCH_PAGE, string);
//	}
	
	public void clickToSearchButton() {
		waitForElementVisible(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
	}

	public String getErrorMgsNotEnoughCharactor() {
		waitForElementVisible(driver, HomePageUI.ERROR_MSG_NOT_ENOUGH_CHARACTOR);
		return getElementText(driver, HomePageUI.ERROR_MSG_NOT_ENOUGH_CHARACTOR);
	}

	public String getErrorMgsNoDataFound() {
		waitForElementVisible(driver, HomePageUI.ERROR_MSG_NO_DATA_FOUND);
		return getElementText(driver, HomePageUI.ERROR_MSG_NO_DATA_FOUND);
	}

	public boolean isDisplayProductFirst() {
		waitForElementVisible(driver, HomePageUI.RESULT_SEARCH_PRODUCT_FIRST);
		return isElementDisplayed(driver, HomePageUI.RESULT_SEARCH_PRODUCT_FIRST);
	}

	public boolean isDisplayProductSecond() {
		waitForElementVisible(driver, HomePageUI.RESULT_SEARCH_PRODUCT_SECOND);
		return isElementDisplayed(driver, HomePageUI.RESULT_SEARCH_PRODUCT_SECOND);
	}

	public boolean isDisplayProductSOnly() {
		waitForElementVisible(driver, HomePageUI.RESULT_SEARCH_PRODUCT_ONLY);
		return isElementDisplayed(driver, HomePageUI.RESULT_SEARCH_PRODUCT_ONLY);
	}

	
	

}
