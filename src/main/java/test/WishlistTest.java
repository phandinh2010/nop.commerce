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
		homePage = new HomePageObject(driver);
		productPage = homePage.clickToAProduct("Apple MacBook Pro 13-inch");
	}

	@Test
	public void Wishlist_TC_01_Add_To_Wishlist() {
		productPage.clickToAddToWishlist();
		Assert.assertEquals(productPage.getMsgAddToWishlistSuccess(), "The product has been added to your wishlist");
		productPage.closeMsgAddToWishlistSuccess();
		wishlistPage= productPage.clickToWishlistLink(driver);
		Assert.assertTrue(wishlistPage.isDisplayProduct("Apple MacBook Pro 13-inch"));
		
		wishlistPage.clickToLinkWishlistSharing();
		Assert.assertTrue(wishlistPage.isDisplayProduct("Apple MacBook Pro 13-inch"));	
		
	}	
	
	@Test
	public void Wishlist_TC_02_Add_To_Cart() {
		wishlistPage.checkToCheckboxAddToCart();
		shoppingCartPage = wishlistPage.clickToButtonAddToCart();
		Assert.assertTrue(shoppingCartPage.isDisplayProduct(""));
		
		wishlistPage= shoppingCartPage.clickToWishlistLink(driver);
		Assert.assertTrue(wishlistPage.isNotDisplayProduct(""));
	}	
	@Test
	public void Wishlist_TC_03_Remove_Product_From_Wishlist() {
		homePage = wishlistPage.clickToLogoWeb(driver);
		productPage = homePage.clickToAProduct("Apple MacBook Pro 13-inch");
		productPage.clickToAddToWishlist();
		productPage.closeMsgAddToWishlistSuccess();
		wishlistPage= productPage.clickToWishlistLink(driver);
		wishlistPage.clickToRemoveProductCheckbox();
		wishlistPage.clickToUpdateWishlist();
		Assert.assertEquals(wishlistPage.getMsgWhenWishlistEmpty(), "");
		Assert.assertTrue(wishlistPage.isNotDisplayProduct(""));
	}	
		
	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
