package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUI.WishlistPageUI;

public class WishlistPageObject extends BasePage {

	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLinkWishlistSharing() {
		waitForElementClickable(driver, WishlistPageUI.LINK_SHARING);
		clickToElement(driver, WishlistPageUI.LINK_SHARING);

	}

	public boolean isDisplayProduct(String productName) {
		waitForElementClickable(driver, GlobalConstants.DYNAMIC_A_PRODUCT, productName);
		return isElementDisplayed(driver, GlobalConstants.DYNAMIC_A_PRODUCT, productName);
	}

	public void checkToCheckboxAddToCart() {
		waitForElementVisible(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		checkToCheckboxOrRadio(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}

	public ShoppingCartPageObject clickToButtonAddToCart() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public boolean isNotDisplayProduct(String productName) {
		waitForElementInvisible(driver, GlobalConstants.DYNAMIC_A_PRODUCT, productName);
		return isElementUndisplayed(driver, GlobalConstants.DYNAMIC_A_PRODUCT, productName);
	
	}

	public void clickToRemoveProductCheckbox() {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_PRODUCT_ICON);
		clickToElement(driver, WishlistPageUI.REMOVE_PRODUCT_ICON);
	}

//	public void clickToUpdateWishlist() {
//		waitForElementClickable(driver, WishlistPageUI.UPDATE_WISHLIST_BUTTON);
//		clickToElement(driver, WishlistPageUI.UPDATE_WISHLIST_BUTTON);
//	}

	public String getMsgWhenWishlistEmpty() {
		waitForElementVisible(driver, WishlistPageUI.MSG_WARNING_WISHLIST_EMPTY);
		return getElementText(driver, WishlistPageUI.MSG_WARNING_WISHLIST_EMPTY);
	}

	
	

}
