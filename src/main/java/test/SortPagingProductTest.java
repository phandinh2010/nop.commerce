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

public class SortPagingProductTest extends BaseTest {

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
		homePage = new HomePageObject(driver);
		homePage.clickSubMenu("computers", "notebooks");		
	}

	@Test
	public void Sort_TC_01_Sort_Name_AZ() {
	homePage.selectSortbyDropdown("Name: A to Z");
		
	}

	@Test
	public void Search_TC_02_Search_With_Note_Exist_Data() {
		homePage.enterKeywordSearchTextboxAtSearchPage("test xxx");
		homePage.clickToSearchButtonAtSearchPage();
		Assert.assertEquals(homePage.getErrorMgsNoDataFound(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_TC_03_Search_With_Product_Name() {
		homePage.enterKeywordSearchTextboxAtSearchPage("Lenovo");
		homePage.clickToSearchButtonAtSearchPage();
		Assert.assertTrue( homePage.isDisplayProductFirst());
		Assert.assertTrue(homePage.isDisplayProductSecond());
	}

	@Test
	public void Search_TC_04_Search_With_Product_Name() {
		homePage.enterKeywordSearchTextboxAtSearchPage("Thinkpad X1 Carbon Laptop");
		homePage.clickToSearchButtonAtSearchPage();
		Assert.assertTrue(homePage.isDisplayProductSOnly());
	}
	
	@Test
	public void Search_TC_05_Advance_Search_With_Parent_Categories() {
		homePage.enterKeywordSearchTextboxAtSearchPage("Apple MacBook Pro");
		homePage.selectCheckboxAdvanceSearch();
		homePage.selectParentCategories("Computers");		
		homePage.clickToSearchButtonAtSearchPage();
		Assert.assertEquals(homePage.getErrorMgsNoDataFound(), "No products were found that matched your criteria.");
	}
	@Test
	public void Search_TC_06_Advance_Search_With_Sub_Categories() {
		homePage.enterKeywordSearchTextboxAtSearchPage("Apple MacBook Pro");
		homePage.selectCheckboxAdvanceSearch();
		homePage.selectParentCategories("Computers");
		homePage.selectCheckboxAutomaticallySearchSubCategories();
		homePage.clickToSearchButtonAtSearchPage();
		Assert.assertTrue(homePage.isDisplayProductSAppleMacBookPro());
	}
	@Test
	public void Search_TC_07_Advance_Search_With_Incorrect_Manufacturer() {
		homePage.enterKeywordSearchTextboxAtSearchPage("Apple MacBook Pro");
		homePage.selectCheckboxAdvanceSearch();
		homePage.selectParentCategories("Computers");
		homePage.selectCheckboxAutomaticallySearchSubCategories();
		homePage.selectManufaceturer("HP");
		homePage.clickToSearchButtonAtSearchPage();
		Assert.assertEquals(homePage.getErrorMgsNoDataFound(), "No products were found that matched your criteria.");
	}
	
	

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
