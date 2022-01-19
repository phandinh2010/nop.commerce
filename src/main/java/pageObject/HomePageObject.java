package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.GlobalConstants;
import pageUI.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, GlobalConstants.REGISTER_LINK);
		clickToElement(driver, GlobalConstants.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, GlobalConstants.LOGIN_LINK);
		clickToElement(driver, GlobalConstants.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);

	}

	public ProductPageObject clickToAProduct(String nameProduct) {
		waitForElementClickable(driver, HomePageUI.SELECt_A_PRODUCT, nameProduct);
		clickToElement(driver, HomePageUI.SELECt_A_PRODUCT, nameProduct);
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
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON_AT_HOME_PAGE);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON_AT_HOME_PAGE);
	}

	public void clickToSearchButtonAtSearchPage() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON_AT_SEARCH_PAGE);
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
		waitForElementVisible(driver, HomePageUI.MENU_HEADER, parentMenu);
		hoverToElement(driver, HomePageUI.MENU_HEADER, parentMenu);
		waitForElementClickable(driver, HomePageUI.SUBMENU_HEADER, subMenu);
		clickToElement(driver, HomePageUI.SUBMENU_HEADER, subMenu);
	}

	public void selectSortbyDropdown(String string) {
		waitForElementVisible(driver, HomePageUI.SORT_ITEM_DROPDOWN);
		selectItemInDropdown(driver, HomePageUI.SORT_ITEM_DROPDOWN, string);

	}

	public List<String> getListProduct() {
		waitForListElementVisiable(driver, HomePageUI.LIST_PRODUCT_SORT);
		List<WebElement> elements = getListWebElement(driver, HomePageUI.LIST_PRODUCT_SORT);
		List<String> listProduct = new ArrayList<String>();
		for (WebElement webElement : elements) {
			String a = getElementText(driver, webElement);
			listProduct.add(a);
		}
		return listProduct;
	}

	public List<String> getListPrice() {
		waitForListElementVisiable(driver, HomePageUI.LIST_OF_PRICET_SORT);
		List<WebElement> elements = getListWebElement(driver, HomePageUI.LIST_OF_PRICET_SORT);
		List<String> listPrice = new ArrayList<String>();
		for (WebElement webElement : elements) {
			String a = getElementText(driver, webElement);
			System.out.println(a);
			listPrice.add(a);
		}

		return listPrice;
	}

	public void selectDisplayPerPage(String value) {
		waitForElementVisible(driver, HomePageUI.DISPLAY_DROPLIST);
		selectItemInDropdown(driver, HomePageUI.DISPLAY_DROPLIST, value);
	}

	public int numberProductPerPage() {
		waitForListElementVisiable(driver, HomePageUI.NUMBER_OF_PRODUCT_PER_PAGE);
		return getListWebElement(driver, HomePageUI.NUMBER_OF_PRODUCT_PER_PAGE).size();

	}

	public int getCurrentPage() {
		waitForElementVisible(driver, HomePageUI.PAGE_CURRENT);
		String str = getElementText(driver, HomePageUI.PAGE_CURRENT);
		return Integer.valueOf(str);
	}

	public boolean isDisplayNextPage() {
		waitForElementVisible(driver, HomePageUI.NEXT_PAGE_BUTTON);
		return isElementDisplayed(driver, HomePageUI.NEXT_PAGE_BUTTON);
	}

	public boolean isDisplayPreviousPage() {
		waitForElementVisible(driver, HomePageUI.PREV_PAGE_BUTTON);
		return isElementDisplayed(driver, HomePageUI.PREV_PAGE_BUTTON);
	}

	public boolean isUndisplayPaging() {
		return isElementUndisplayed(driver, HomePageUI.PAGING_FUNCTION);
	}

	public boolean isDisplayMyAccountLink() {
		waitForElementVisible(driver, GlobalConstants.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, GlobalConstants.MY_ACCOUNT_LINK);
	}
}
