package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.HomePageObject;
import pageObject.MyAccountPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;
import pageUI.MyAccountPageUI;

public class BaseTest {
	protected final Log log;

	// Constructor
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	WebDriver driver;
	private String projectLocation = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");

	public WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("headless");
			firefoxOpt.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOpt);
		} else {
			throw new RuntimeException("Please input the browser name!");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected void removeDriver() {

		try {
			// Get ra t??n c???a OS v?? convert qua ch??? th?????ng
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai b??o 1 bi???n command line ????? th???c thi
			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			// Quit driver executable file in Task Manager
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("edge")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill msedgedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		driver.quit();
	}

	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("headless");
			firefoxOpt.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOpt);
		} else {
			throw new RuntimeException("Please input the browser name!");
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	protected void setBrowserDriverProperty() {
		String browserFolderPath = projectLocation + getDirectorySlash("browserDriver");
		if (isWindows()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver-mac");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver-mac");
		}
	}

	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add l???i v??o ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}

			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public String generalEmail() {
		String email = "test" + random(1, 1000) + "@gmail.com";
		return email;
	}

	private static int random(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min) + min);
	}

	public boolean SortStringAToZ(String a, String b) {
		if (a.compareTo(b) < 0)
			return true;
		return false;
	}
	
	public boolean SortDoubleASC(Double a, Double b) {
		if (a > b)
			return true;
		return false;
	}

	
	public boolean isListDoubleSortASC(List<Double> list) {
		boolean result = false;
		for (int i = 0; i < list.size() - 1; i++) {
			return result = SortDoubleASC(list.get(i), list.get(i + 1));
			
		}
		return result;
	}
	public boolean isListSortAToZ(List<String> list) {
		boolean result = false;
		for (int i = 0; i < list.size() - 1; i++) {
			return result = SortStringAToZ(list.get(i), list.get(i + 1));
			
		}
		return result;
	}
	

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};

	RegisterPageObject registerPage;
	HomePageObject homePage;
}
