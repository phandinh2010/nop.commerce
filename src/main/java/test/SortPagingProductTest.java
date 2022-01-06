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
		homePage.clickSubMenu("Computers ", "Notebooks ");
	}

	@Test
	public void Sort_TC_01_Sort_Name_AZ() {
		homePage.selectSortbyDropdown("Name: A to Z");		 
		Assert.assertTrue(isListSortAToZ(homePage.getListProduct()));
	}

	@Test
	public void Sort_TC_02_Sort_Name_ZA() throws InterruptedException {
		homePage.selectSortbyDropdown("Name: Z to A");
		Thread.sleep(3000);
		Assert.assertFalse(isListSortAToZ(homePage.getListProduct()));
	}

	@Test
	public void Sort_TC_03_Sort_Price_Low_To_Hight() throws InterruptedException {
		Thread.sleep(3000);
		homePage.selectSortbyDropdown("Price: Low to High");	
		Assert.assertTrue(isListSortAToZ(homePage.getListPrice()));
	}

	@Test
	public void Sort_TC_04_Sort_Price_Hight_To_Low() {
		homePage.selectSortbyDropdown("Price: High to Low");		 
		Assert.assertFalse(isListSortAToZ(homePage.getListPrice()));
	}
	@Test
	public void Sort_TC_05_Paging_Equal_3() throws InterruptedException {
		homePage.selectDisplayPerPage("3");	
		Thread.sleep(3000);
		int n = homePage.numberProductPerPage();
		System.out.println(n);
		Assert.assertTrue(n <= 3);
		
		if(homePage.getCurrentPage() == 1) {
			Assert.assertTrue(homePage.isDisplayNextPage());
		} else {
			Assert.assertTrue(homePage.isDisplayPreviousPage());
		}
		
	}
	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
