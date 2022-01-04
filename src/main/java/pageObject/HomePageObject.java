package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public void enterKeywordSearchTextboxAtSearchPage(String string) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX_AT_SEARCH_PAGE);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX_AT_SEARCH_PAGE, string);
	}
	
	public void clickToSearchButtonAtHomePage() {
		waitForElementVisible(driver, HomePageUI.SEARCH_BUTTON_AT_HOME_PAGE);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON_AT_HOME_PAGE);
	}
	
	public void clickToSearchButtonAtSearchPage() {
		waitForElementVisible(driver, HomePageUI.SEARCH_BUTTON_AT_SEARCH_PAGE);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON_AT_SEARCH_PAGE);
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

	public void selectCheckboxAdvanceSearch() {
		waitForElementVisible(driver, HomePageUI.SEARCH_ADVANCE_CHECKBOX);
		checkToCheckboxOrRadio(driver, HomePageUI.SEARCH_ADVANCE_CHECKBOX);
	}
	
	public void selectParentCategories(String string) {
		waitForElementVisible(driver, HomePageUI.PARENT_CATEGORIES_DROPDOWN);
		selectItemInDropdown(driver, HomePageUI.PARENT_CATEGORIES_DROPDOWN, string);
		
	}

	public void selectCheckboxAutomaticallySearchSubCategories() {
		waitForElementVisible(driver, HomePageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkToCheckboxOrRadio(driver, HomePageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
	}

	public boolean isDisplayProductSAppleMacBookPro() {
		waitForElementVisible(driver, HomePageUI.APPLE_MACBOOK_PRO_PRODUCT);
		return isElementDisplayed(driver, HomePageUI.APPLE_MACBOOK_PRO_PRODUCT);
	}

	public void selectManufaceturer(String string) {
		waitForElementVisible(driver, HomePageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, HomePageUI.MANUFACTURER_DROPDOWN, string);
		
	}

	public void clickSubMenu(String parentMenu, String subMenu) {
		waitForElementVisible(driver, HomePageUI.MENU_HEADER);
		hoverToElement(driver, HomePageUI.MENU_HEADER, parentMenu );
		waitForElementVisible(driver, HomePageUI.SUBMENU_HEADER);
		clickToElement(driver, HomePageUI.SUBMENU_HEADER, subMenu);		
	}

	public void selectSortbyDropdown(String string) {
		waitForElementVisible(driver, HomePageUI.SORT_ITEM_DROPDOWN);
		selectItemInDropdown(driver, HomePageUI.SORT_ITEM_DROPDOWN, string);		
	}	
	
	public List<String> listProduct() {
		waitForElementVisible(driver, HomePageUI.LIST_PRODUCT_SORT);
		List<WebElement> elements = getListWebElement(driver, HomePageUI.LIST_PRODUCT_SORT);
		List<String> listProduct = new ArrayList<String>();
		for (WebElement webElement : elements) {
			String a = getElementText(driver, webElement);
			listProduct.add(a);
		}
		return listProduct;
		
		
		
		
	}	
	

}
