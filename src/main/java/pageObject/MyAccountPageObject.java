package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;
import commons.GlobalConstants;
import pageUI.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {

	WebDriver driver;
	Select select;
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGenderFemale() {
		waitForElementVisible(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
		clickToElement(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);

	}

	public void enterToFirstNameTextbox(String string) {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, string);
	}

	public void enterToLastNameTextbox(String string) {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, string);
	}
	
	public void SelectBirthDay(String Day, String Month, String Year){
		waitForElementVisible(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPLIST);		
		selectItemInDropdown(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPLIST, Day);	
		
		waitForElementVisible(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPLIST);
		selectItemInDropdown(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPLIST, Month);

		waitForElementVisible(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPLIST);
		selectItemInDropdown(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPLIST, Year);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
	}
	public String getDayOfBirthDroplistValue() {
		waitForElementVisible(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPLIST);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.DAY_OF_BIRTH_DROPLIST, "1" );
	}
	
	public String getMonthOfBirthDroplistValue() {
		waitForElementVisible(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPLIST);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPLIST, "1");
	}

	public String getYearOfBirthDroplistValue() {
		waitForElementVisible(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPLIST);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPLIST, "1999" );
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX);
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
	}
	public void clickToAddressLink() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);
	}

	public void clickToAddnewButton() {
		waitForElementVisible(driver, MyAccountPageUI.ADDNEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDNEW_BUTTON);
		
	}

	public void enterToAddressFirstNameTextbox(String value) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX, value);
		
	}

	public void enterToAddressLastNameTextbox(String value) {		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX, value);
	}
	
	public void enterToAddressEmailTextbox(String value) {		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, value);
	}
	
	public void enterToAddressCompanyTextbox(String value) {		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX, value);
	}

	public void selectProvinceDroplist(String province) {
		waitForElementVisible(driver, MyAccountPageUI.PROVINCE_DROPLIST);		
		selectItemInDropdown(driver, MyAccountPageUI.PROVINCE_DROPLIST, province);	
		
	}

	public void enterFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, MyAccountPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
		
	}

	public void enterPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, MyAccountPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void entertoZipPostalCodeTextbox(String zipCode) {
		waitForElementVisible(driver, MyAccountPageUI.ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ZIP_CODE_TEXTBOX, zipCode);
		
	}

	public void enterToAddress2Textbox(String Address2) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS2_TEXTBOX, Address2);
		
	}

	public void enterToAddress1Textbox(String Address1) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS1_TEXTBOX, Address1);
		
	}

	public void selectCountryDroplist(String value) {
		waitForElementVisible(driver, MyAccountPageUI.COUNTRY_DROPLIST);		
		selectItemInDropdown(driver, MyAccountPageUI.COUNTRY_DROPLIST, value);	
		
	}

	public void enterToCityTextbox(String value) {
		waitForElementVisible(driver, MyAccountPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CITY_TEXTBOX, value);
		
	}

	public void clickToSaveAddressButton() {
		waitForElementVisible(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
	}

	public String getAddressNameValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_NAME_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_NAME_VALUE);
	}

	public String getAddressEmailValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_EMAIL_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_EMAIL_VALUE);
	}

	public String getAddressPhoneNumberValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_PHONE_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_PHONE_VALUE);
	}
	public String getAddressFaxNumberValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_FAX_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_FAX_VALUE);
	}


	public String getAddressCompanyValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COMPANY_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_COMPANY_VALUE);
	}

	public String getAddressAddress1Value() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ADDRESS1_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_ADDRESS1_VALUE);
	}
	public String getAddressAddress2Value() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ADDRESS2_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_ADDRESS2_VALUE);
	}

	public String getAddressZipCodeValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ZIP_CODE_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_ZIP_CODE_VALUE);
	}

	public String getAddressCountryValue() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COUNTRY_VALUE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_COUNTRY_VALUE);
	}

	public void clickChangePasswordLink() {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
	}

	public void enterOldPassword(String string) {
		waitForElementVisible(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, string);
	}

	public void enterNewPassword(String string) {
		waitForElementVisible(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, string);
	}

	public void enterConfirmPassword(String string) {
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, string);
	}

	

	public void clickChangePasswordButton() {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public HomePageObject clickLogoutLink() {
		waitForElementVisible(driver, GlobalConstants.LOG_OUT_LINK);
		clickToElement(driver, GlobalConstants.LOG_OUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public void clickToCloseMsgChangePasswordSuccess() {
		waitForElementVisible(driver, MyAccountPageUI.SUCCESS_CHANGE_PASSWORD_MSG);
		clickToElement(driver, MyAccountPageUI.SUCCESS_CHANGE_PASSWORD_MSG);
		
	}



}
