package commons;

public class GlobalConstants {
	public static final String PROJECT_LOCATION = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FOLDER_LOCATION = PROJECT_LOCATION + "\\uploadFiles";
	public static final String DOWNLOAD_FOLDER_LOCATION = PROJECT_LOCATION + "\\downloadFiles";
	public static final String DEV_URL = "https://demo.nopcommerce.com";
	public static final String STAGING_URL = "https://staging.nopcommerce.com";
	public static final String TEST_URL = "https://test.nopcommerce.com";
	public static final String DB_URL = "jdbc:mysql://localhost:3906";
	public static final String DB_NAME = "automationfc";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "admin";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 15;

}
