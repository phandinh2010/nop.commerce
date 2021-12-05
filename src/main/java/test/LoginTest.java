package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class LoginTest extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String emailRegister;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		// driver.get("https://demo.nopcommerce.com");
		homePage = new HomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void Login_TC_01_Empty_Data() {
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getEmailEmptyMsg(), "Please enter your email");
	}

	@Test
	public void Login_TC_02_Email_Invalid() {
		loginPage.enterToEmailTextbox("test");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getEmailInvalidMsg(), "Wrong email");
	}

	@Test
	public void Login_TC_03_Email_Not_Exist() {
		loginPage.enterToEmailTextbox("testa@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginBtn();
		System.out.println(loginPage.getLoginFailMsg());
		Assert.assertEquals(loginPage.getLoginFailMsg(), "Login was unsuccessful. Please correct the errors and try again.No customer account found");
		//Assert.assertEquals(loginPage.getCustomerNotFoundMsg(), "No customer account found");
	}

	@Test
	public void Login_TC_04_Email_Valid_Pass_Empty() {
		loginPage.enterToEmailTextbox(RegisterTest.emailRegister);
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getPasswordEmptyLoginFailMsg(), "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
		//Assert.assertEquals(loginPage.getPasswordEmptyMsg(), "The credentials provided are incorrect");
	}

	@Test
	public void Login_TC_05_Email_Valid_Pass_Wrong() {
		loginPage.enterToEmailTextbox(RegisterTest.emailRegister);
		loginPage.enterToPasswordTextbox("123457");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getPasswordwrongMsg(), "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
	}

	@Test
	public void Login_TC_06_Email_Valid_Pass_Valid() {
		loginPage.enterToEmailTextbox(RegisterTest.emailRegister);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginBtn();
		Assert.assertTrue(registerPage.isSuccessMsgDisplay());
	}

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

	public String generalEmail() {
		String email = "test" + random(1, 1000) + "@gmail.com";
		return email;
	}

	private static int random(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min) + min);
	}
}
