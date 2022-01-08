package commons;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObject.HomePageObject;
import pageObject.PageGeneratorManager;

public class Register extends BaseTest {
	private WebDriver driver;
	public static String email;
	public static String password = "123456";

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = new HomePageObject(driver);
		email = generalEmail();
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("test");
		registerPage.enterToLastNameTextbox("auto");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterBtn();
		Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		removeDriver();
	}
}
