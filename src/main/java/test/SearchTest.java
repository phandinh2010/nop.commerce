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
import pageUI.MyAccountPageUI;

public class SearchTest extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	ProductPageObject productPage;
	String emailRegister;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		// driver.get("https://demo.nopcommerce.com");
		homePage = new HomePageObject(driver);
		// emailRegister = generalEmail();
		// registerAccount(homePage, driver, emailRegister);
		// myAccountPage = homePage.clickToMyAccountLink(driver);
		// System.out.println(emailRegister);
	}

	@Test
	public void Login_TC_01_Search_With_Empty_Data() {
	homePage.enterKeywordSearchTextboxAtHomePage(" ");
	homePage.clickToSearchButton();
	Assert.assertEquals(homePage.getErrorMgsNotEnoughCharactor(), "Search term minimum length is 3 characters");	
	}

	@Test
	public void Login_TC_02_Search_With_Note_Exist_Data() {
		homePage.enterKeywordSearchTextboxAtHomePage("test xxx");
		homePage.clickToSearchButton();
		Assert.assertEquals(homePage.getErrorMgsNoDataFound(), "No products were found that matched your criteria.");
	}

	@Test
	public void Login_TC_03_Search_With_Product_Name() {
		homePage.enterKeywordSearchTextboxAtHomePage("Lenovo");
		homePage.clickToSearchButton();
		Assert.assertTrue( homePage.isDisplayProductFirst());
		Assert.assertTrue(homePage.isDisplayProductSecond());
	}

	@Test
	public void Login_TC_04_Search_With_Product_Name() {
		homePage.enterKeywordSearchTextboxAtHomePage("Thinkpad X1 Carbon Laptop");
		homePage.clickToSearchButton();
		Assert.assertTrue(homePage.isDisplayProductSOnly());
	}

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
