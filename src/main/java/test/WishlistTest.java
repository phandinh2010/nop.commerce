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
import pageObject.ShoppingCartPageObject;
import pageObject.WishlistPageObject;

public class WishlistTest extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	ShoppingCartPageObject shoppingCartPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
		productPage = homePage.clickToAProduct("Apple MacBook Pro 13-inch");
	}

	@Test
	public void Wishlist_TC_01_Add_To_Wishlist() throws InterruptedException {
		productPage.clickToAddToWishlist();
		Assert.assertEquals(productPage.getMsgAddToWishlistSuccess(), "The product has been added to your wishlist");
		productPage.closeMsgAddToWishlistSuccess();
		wishlistPage = productPage.clickToWishlistLink(driver);
		Assert.assertTrue(wishlistPage.isDisplayProduct("Apple MacBook Pro 13-inch"));

		wishlistPage.clickToLinkWishlistSharing();
		Assert.assertTrue(wishlistPage.isDisplayProduct("Apple MacBook Pro 13-inch"));

	}

	@Test
	public void Wishlist_TC_02_Add_To_Cart() throws InterruptedException {
		wishlistPage.clickToWishlistLink(driver);
		wishlistPage.checkToCheckboxAddToCart();
		shoppingCartPage = wishlistPage.clickToButtonAddToCart();
		Assert.assertTrue(shoppingCartPage.isDisplayProduct("Apple MacBook Pro 13-inch"));
		Thread.sleep(3000);
		//shoppingCartPage.waitForWishlistReturnToZero();
		wishlistPage = shoppingCartPage.clickToWishlistLink(driver);
		Assert.assertTrue(wishlistPage.isNotDisplayProduct("Apple MacBook Pro 13-inch"));
		
	}

	@Test
	public void Wishlist_TC_03_Remove_Product_From_Wishlist() throws InterruptedException {
		homePage = wishlistPage.clickToLogoWeb(driver);
		productPage = homePage.clickToAProduct("Apple MacBook Pro 13-inch");
		productPage.clickToAddToWishlist();
		productPage.closeMsgAddToWishlistSuccess();
		wishlistPage = productPage.clickToWishlistLink(driver);
		wishlistPage.clickToRemoveProductCheckbox();
		Assert.assertEquals(wishlistPage.getMsgWhenWishlistEmpty(), "The wishlist is empty!");
		Assert.assertTrue(wishlistPage.isNotDisplayProduct("Apple MacBook Pro 13-inch"));
	}

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
