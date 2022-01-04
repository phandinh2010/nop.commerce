package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddYourReviewLink() {
		waitForElementVisible(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void enterReviewTitleTextbox(String string) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX, string);
	}

	public void enterContentReivewTextarea(String string) {
		waitForElementVisible(driver, ProductPageUI.CONTENT_REVIEW_AREA);
		sendkeyToElement(driver, ProductPageUI.CONTENT_REVIEW_AREA, string);
	}

	public void clickToSubmitReviewButton() {
		waitForElementVisible(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

}
