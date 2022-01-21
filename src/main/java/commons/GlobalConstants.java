package commons;

public class GlobalConstants {
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 20;
	public static final String PROJECT_LOCATION = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FOLDER_LOCATION = PROJECT_LOCATION + "\\uploadFiles";
	public static final String DOWNLOAD_FOLDER_LOCATION = PROJECT_LOCATION + "\\downloadFiles";
	public static final String DEV_URL = "https://demo.nopcommerce.com";
	public static final String STAGING_URL = "https://demo.nopcommerce.com";
	public static final String TEST_URL = "https://demo.nopcommerce.com";
	public static final String DB_URL = "jdbc:mysql://localhost:3906";
	public static final String DB_NAME = "automationfc";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "admin";
	public static final String LOG_OUT_LINK = "xpath=//a[text()='Log out']";
	public static final String LOGIN_LINK = "xpath=//a[text()='Log in']";	
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String MY_WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
	public static final String LOGO_WEB_IMAGE = "xpath=//img[@alt='nopCommerce demo store']";
	public static final String DYNAMIC_A_PRODUCT = "xpath=//td//a[text()='%s']";
	public static final String WISHLIST_EQUAL_TO_ZERO = "xpath=//span[text()='(0)']";
	

}
