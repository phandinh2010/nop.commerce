package test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
//		driver.get("https://demo.nopcommerce.com");			
		homePage= new HomePageObject(driver);
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
			
		//Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		Assert.assertTrue(registerPage.isFistNameErrorMsgDisplay());
		Assert.assertTrue(registerPage.isLastNameErrorMsgDisplay());
		Assert.assertTrue(registerPage.isEmailEmptyErrorMsgDisplay());
		Assert.assertTrue(registerPage.isPaswordErrorMsgDisplay());
		Assert.assertTrue(registerPage.isPErrorMsgDisplay());
		
	}
	
	@Test
	public void Register_TC_02_Email_Invalid() {
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterBtn();
			
		
		Assert.assertTrue(registerPage.isEmailInvalidErrorMsgDisplay());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Register_TC_03_Data_Valid() {
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterBtn();
			
		
		Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		registerPage.clickToLogoutLink();		
	}
	
	@Test
	public void Register_TC_4_Email_Exist() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterBtn();
			
		
		Assert.assertTrue(registerPage.isEmailExistErrorMsgDisplay());		
	}
	
	@Test
	public void Register_TC_05_Password_NotEnough6Charactor() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterBtn();		
		Assert.assertTrue(registerPage.isPassworInvaliddErrorMsgDisplay());		
	}
	
	@Test
	public void Register_TC_06_ConfirmPassword_Invalid() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("");
		registerPage.enterToLastNameTextbox("");
		registerPage.enterToEmailTextbox("");
		registerPage.enterToPasswordTextbox("");
		registerPage.enterToConfirmPasswordTextbox("");
		registerPage.clickToRegisterBtn();		
		Assert.assertTrue(registerPage.isConfirmPassworInvaliddErrorMsgDisplay());		
	}
}
