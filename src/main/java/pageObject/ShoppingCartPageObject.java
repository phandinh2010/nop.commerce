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

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayProduct(String productName) {
		waitForElementVisible(driver, GlobalConstants.DYNAMIC_A_PRODUCT, productName);
		return isElementDisplayed(driver, GlobalConstants.DYNAMIC_A_PRODUCT, productName);
	}

	
}
