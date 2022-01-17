package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Register;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.PageGeneratorManager;
import pageObject.ProductPageObject;
import pageObject.RegisterPageObject;
import pageUI.MyAccountPageUI;

public class WishlistCompareViewTest extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	ProductPageObject productPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		// driver.get("https://demo.nopcommerce.com");
		homePage = new HomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(Register.email);
		loginPage.enterToEmailTextbox(Register.password);
		loginPage.clickToLoginBtn();
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Login_TC_01_My_Account_Update_Info_Customer() {
		
	}

	@Test
	public void Login_TC_02_My_Account_Update_Address() {
		
	}

	@Test
	public void Login_TC_03_My_Account_Change_Password() {
		

	}

	@Test
	public void Login_TC_04_My_Account_Add_Review_Product() {
		
	}

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
