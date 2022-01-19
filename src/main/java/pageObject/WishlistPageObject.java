package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
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
		waitForElementClickable(driver, WishlistPageUI.DYAMIC_PRODUCT, productName);
		return isElementDisplayed(driver, WishlistPageUI.DYAMIC_PRODUCT, productName);
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

	public boolean isNotDisplayProduct(String string) {
		waitForElementInvisible(driver, WishlistPageUI.DYAMIC_PRODUCT);
		return isElementUndisplayed(driver, WishlistPageUI.DYAMIC_PRODUCT);
	
	}

	public void clickToRemoveProductCheckbox() {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_PRODUCT_CHECKBOX);
		checkToCheckboxOrRadio(driver, WishlistPageUI.REMOVE_PRODUCT_CHECKBOX);
	}

	public void clickToUpdateWishlist() {
		waitForElementClickable(driver, WishlistPageUI.UPDATE_WISHLIST_BUTTON);
		clickToElement(driver, WishlistPageUI.UPDATE_WISHLIST_BUTTON);
	}

	public String getMsgWhenWishlistEmpty() {
		waitForElementVisible(driver, WishlistPageUI.MSG_WARNING_WISHLIST_EMPTY);
		return getElementText(driver, WishlistPageUI.MSG_WARNING_WISHLIST_EMPTY);
	}

	
	

}
