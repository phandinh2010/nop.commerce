package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class RegisterTest extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	static String emailRegister;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		// driver.get("https://demo.nopcommerce.com");
		homePage = new HomePageObject(driver);
		registerPage = homePage.clickToRegisterLink();
	}

	@Test
	public void Register_TC_01_Empty_Data() {
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterBtn();

		// Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		Assert.assertTrue(registerPage.isFistNameEmptyMsgDisplay());
		Assert.assertEquals(registerPage.getFistNameEmptyMsgDisplay(), "First name is required.");

		Assert.assertTrue(registerPage.isLastNameEmptyMsgDisplay());
		Assert.assertTrue(registerPage.isEmailEmptyEmptyMsgDisplay());
		Assert.assertTrue(registerPage.isPaswordEmptyMsgDisplay());
		Assert.assertTrue(registerPage.isConfirmPasswordEmptyMsgDisplay());

	}

	@Test
	public void Register_TC_02_Email_Invalid() {
		registerPage.enterToFirstNameTextbox("Test");
		registerPage.enterToLastNameTextbox("auto");
		registerPage.enterToEmailTextbox("test");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterBtn();

		Assert.assertTrue(registerPage.isEmailInvalidErrorMsgDisplay());
	}

	@Test
	public void Register_TC_03_Data_Valid() {
		registerPage.enterToFirstNameTextbox("test");
		registerPage.enterToLastNameTextbox("auto");
		emailRegister = generalEmail();
		System.out.println(emailRegister);
		registerPage.enterToEmailTextbox(emailRegister);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterBtn();

		Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Register_TC_04_Email_Exist() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("test");
		registerPage.enterToLastNameTextbox("auto");
		registerPage.enterToEmailTextbox(emailRegister);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterBtn();

		Assert.assertTrue(registerPage.isEmailExistErrorMsgDisplay());
		Assert.assertEquals(registerPage.getTextEmailExistErrorMsgDisplay(), "The specified email already exists");
	}

	@Test
	public void Register_TC_05_Password_NotEnough6Charactor() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("test");
		registerPage.enterToLastNameTextbox("auto");
		registerPage.enterToEmailTextbox(generalEmail());
		registerPage.enterToPasswordTextbox("12345");
		registerPage.enterToConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterBtn();
		Assert.assertTrue(registerPage.isPassworInvaliddErrorMsgDisplay());
	}

	@Test
	public void Register_TC_06_ConfirmPassword_Invalid() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("test");
		registerPage.enterToLastNameTextbox("auto");
		registerPage.enterToEmailTextbox(generalEmail());
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123457");
		registerPage.clickToRegisterBtn();
		Assert.assertTrue(registerPage.isConfirmPassworInvaliddErrorMsgDisplay());
	}

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}	
	
}
