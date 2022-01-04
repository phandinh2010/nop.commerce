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

public class MyAccountTest extends BaseTest {

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
		emailRegister = generalEmail();	
		registerAccount(homePage, driver, emailRegister);
		myAccountPage = homePage.clickToMyAccountLink(driver);
		System.out.println(emailRegister);		
	}

	@Test
	public void Login_TC_01_My_Account_Update_Info_Customer() throws InterruptedException {
		myAccountPage.selectGenderFemale();
		myAccountPage.enterToFirstNameTextbox("Automation");
		myAccountPage.enterToLastNameTextbox("FC");
		myAccountPage.SelectBirthDay("1", "January", "1999");
		myAccountPage.enterToEmailTextbox("automationfc.vn@gmail.com");
		myAccountPage.enterToCompanyNameTextbox("Automation FC");
		myAccountPage.clickToSaveButton();
		
		Assert.assertTrue(myAccountPage.isElementSelected(driver,MyAccountPageUI.FEMALE_RADIO_BUTTON));
		Assert.assertEquals(myAccountPage.getFirstNameTextboxValue(), "Automation");
		Assert.assertEquals(myAccountPage.getLastNameTextboxValue(), "FC");
		Assert.assertEquals(myAccountPage.getDayOfBirthDroplistValue(), "1");
		Assert.assertEquals(myAccountPage.getMonthOfBirthDroplistValue(), "January");
		Assert.assertEquals(myAccountPage.getYearOfBirthDroplistValue(), "1999");
		Assert.assertEquals(myAccountPage.getEmailTextboxValue(), "automationfc.vn@gmail.com");
		Assert.assertEquals(myAccountPage.getCompanyNameTextboxValue(), "Automation FC");		
	}

	@Test
	public void Login_TC_02_My_Account_Update_Address() {
		myAccountPage.clickToAddressLink();
		myAccountPage.clickToAddnewButton();
		myAccountPage.enterToAddressFirstNameTextbox("Automation");
		myAccountPage.enterToAddressLastNameTextbox("FC");
		myAccountPage.enterToAddressEmailTextbox("automationfc@gmail.com");
		myAccountPage.enterToAddressCompanyTextbox("Automation FC");
		myAccountPage.selectCountryDroplist("Viet Nam");
		myAccountPage.selectProvinceDroplist("Other");
		myAccountPage.enterToCityTextbox("Da Nang");
		myAccountPage.enterToAddress1Textbox("123/04 Le Lai");
		myAccountPage.enterToAddress2Textbox("234/ 05 Hai Phong");
		myAccountPage.entertoZipPostalCodeTextbox("550000");
		myAccountPage.enterPhoneNumberTextbox("0123456789");
		myAccountPage.enterFaxNumberTextbox("0987654321");
		myAccountPage.clickToSaveAddressButton();		
		
		Assert.assertEquals(myAccountPage.getAddressNameValue(), "Automation FC");
		Assert.assertTrue(myAccountPage.getAddressEmailValue().contains("automationfc@gmail.com"));
		Assert.assertTrue(myAccountPage.getAddressPhoneNumberValue().contains("0123456789"));
		Assert.assertTrue(myAccountPage.getAddressFaxNumberValue().contains("0987654321"));
		Assert.assertTrue(myAccountPage.getAddressCompanyValue().contains("Automation FC"));
		Assert.assertTrue(myAccountPage.getAddressAddress1Value().contains("123/04 Le Lai"));
		Assert.assertTrue(myAccountPage.getAddressAddress2Value().contains("234/ 05 Hai Phong"));
		Assert.assertTrue(myAccountPage.getAddressZipCodeValue().contains("Da Nang, 550000"));
		Assert.assertTrue(myAccountPage.getAddressCountryValue().contains("Viet Nam"));	
		
	}

	@Test
	public void Login_TC_03_My_Account_Change_Password(){
		myAccountPage.clickChangePasswordLink();
		myAccountPage.enterOldPassword("123456");
		myAccountPage.enterNewPassword("1234567");
		myAccountPage.enterConfirmPassword("1234567");
		myAccountPage.clickChangePasswordButton();
		myAccountPage.clickToCloseMsgChangePasswordSuccess();
		homePage = myAccountPage.clickLogoutLink();
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailRegister);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginBtn();
		System.out.println(loginPage.getLoginFailMsg());
		Assert.assertTrue(loginPage.getLoginFailMsg().contains("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.getLoginFailMsg().contains("The credentials provided are incorrect"));
		
		loginPage.enterToPasswordTextbox("1234567");
		loginPage.clickToLoginBtn();
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(myAccountPage.isLoginSuccess());		
		
	}

	@Test
	public void Login_TC_04_My_Account_Add_Review_Product() {
		productPage = homePage.clickToAProduct("Apple MacBook Pro 13-inch");		
		productPage.clickToAddYourReviewLink();
		
		productPage.enterReviewTitleTextbox("Test title");
		productPage.enterContentReivewTextarea("Test content");
		productPage.clickToSubmitReviewButton();	
		myAccountPage = productPage.clickToMyAccountLink(driver);
		myAccountPage.clickToMyProductReviews();
		Assert.assertEquals(myAccountPage.getTitleReview(), "Test title");
		Assert.assertEquals(myAccountPage.getContentReview(), "Test content");
		Assert.assertEquals(myAccountPage.getProductReview(), "Apple MacBook Pro 13-inch");			
	}

	
	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

	
}
