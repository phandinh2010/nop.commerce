package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.PageGeneratorManager;
import pageObject.ProductPageObject;
import pageObject.RegisterPageObject;
import pageObject.WishlistPageObject;
import pageUI.MyAccountPageUI;

public class WishlistTest extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	String emailRegister;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
		homePage = new HomePageObject(driver);
		productPage = homePage.clickToAProduct("");
	}

	@Test
	public void Search_TC_01_Search_With_Empty_Data() {
		productPage.clickToAddToWishlist();
		Assert.assertEquals(productPage.isMsgAddToWishlistSuccess(), "");
		wishlistPage= productPage.clickToWishlist();
		wishlistPage.clickToLinkWishlistSharing();
		Assert.assertTrue(wishlistPage.isDisplayProductSharing());	
	
	}	
	

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
