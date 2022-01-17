package test;

import java.util.Collections;
import java.util.List;

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
		Assert.assertFalse(isListSortAToZ(homePage.getListProduct()));
	}

	@Test
	public void Sort_TC_03_Sort_Price_Low_To_Hight() throws InterruptedException {
		homePage.selectSortbyDropdown("Price: Low to High");
		Assert.assertTrue(isListDoubleSortASC(homePage.getListPrice()));
	}

	@Test
	public void Sort_TC_04_Sort_Price_Hight_To_Low() {
		homePage.selectSortbyDropdown("Price: High to Low");
		Assert.assertFalse(isListDoubleSortASC(homePage.getListPrice()));
	}

	@Test
	public void Sort_TC_05_Paging_Equal_3() throws InterruptedException {
		homePage.selectDisplayPerPage("3");
		int n = homePage.numberProductPerPage();
		System.out.println(n);
		Assert.assertTrue(n <= 3);

		if (homePage.getCurrentPage() == 1) {
			Assert.assertTrue(homePage.isDisplayNextPage());
		} else {
			Assert.assertTrue(homePage.isDisplayPreviousPage());
		}
	}

	@Test
	public void Sort_TC_06_Paging_Equal_6() throws InterruptedException {
		homePage.selectDisplayPerPage("6");
		Thread.sleep(3000);
		int n = homePage.numberProductPerPage();
		System.out.println(n);
		Assert.assertTrue(n <= 6);

		Assert.assertTrue(homePage.isUndisplayPaging());
	}

	@Test
	public void Sort_TC_07_Paging_Equal_9() throws InterruptedException {
		homePage.selectDisplayPerPage("6");
		Thread.sleep(3000);
		int n = homePage.numberProductPerPage();
		System.out.println(n);
		Assert.assertTrue(n <= 6);

		Assert.assertTrue(homePage.isUndisplayPaging());
	}

	@AfterClass(alwaysRun = true) // Khi testcase fail vẫn run để close browser
	public void afterClass() {
		removeDriver();
	}

}
