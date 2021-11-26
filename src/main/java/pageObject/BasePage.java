package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected final Log log;
	// Constructor
	public BasePage() {
		log = LogFactory.getLog(getClass());
	}
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	

	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void waitForAlertPresence(WebDriver driver) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
//
//	public By getByXpath(String locator) {
//		return By.xpath(locator);
//	}
	
	//locatoType: id=/ css=/   xpath=/ name=/ class=
	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=")) {
			by = By.name(locatorType.substring(5));
		}else if (locatorType.startsWith("css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if (locatorType.startsWith("xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}
		return by;
	}
	

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[]) values);
	}

	public void clickToElement(WebDriver driver, String locator) {
		try {
			getWebElement(driver, locator).click();
		} catch (Exception e) {
			log.debug("Element is not clickable: " + e.getMessage());
		}
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		try {
			getWebElement(driver, getDynamicLocator(locator, values)).click();
		} catch (Exception e) {
			log.debug("Element is not clickable: " + e.getMessage());
		}
	}

	private void clickToElement(WebElement element) {
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(valueItem);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

		List<WebElement> allItems = getListWebElement(driver, childItemLocator);

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				clickToElement(item);
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText().trim();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getText().trim();
	}

	public String getElementAttributeByName(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementAttributeValue(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getAttribute("value");
	}

	public int getElementNumber(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	public int getElementNumber(WebDriver driver, String locator, String... values) {
		return getListWebElement(driver, getDynamicLocator(locator, values)).size();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			return getWebElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			log.debug("Element is not displayed with error: " + e.getMessage());
			return false;
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		boolean status = false;
		try {
			status = getWebElement(driver, locator).isDisplayed();
			return status;
		} catch (Exception e) {
			return status;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		try {
			return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
		} catch (Exception e) {
			log.debug("Element is not displayed with error: " + e.getMessage());
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overideImpicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		overideImpicitTimeout(driver, longTimeout);

		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
		overideImpicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicLocator(locator, values));
		overideImpicitTimeout(driver, longTimeout);

		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public void overideImpicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		try {
			driver.switchTo().frame(getWebElement(driver, locator));
		} catch (Exception e) {
			log.debug("No frame with: " + e.getMessage());
		}
	}

	public void switchToDefaulContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... values) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicLocator(locator, values)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
		} catch (Exception e) {
			log.debug("Wait for element visible with error: " + e.getMessage());
		}

	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, values))));

	}

	public void waitForListElementVisiable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));

	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
		} catch (Exception e) {
			log.debug("Wait for element clickable with error: " + e.getMessage());
		}
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, values))));
	}

	public void uploadOneFile(WebDriver driver, String locator, String FileName) {
		getWebElement(driver, locator).sendKeys(FileName);
	}

	public void uploadMultipleFiles(WebDriver driver, String locator, String... fileNames) {

		// System.getProperty("user.dir"): get ra đường dẫn local chưa project trên máy
		// D:\AutoTest_DaoMinhDam\03.Hyprid Framework
		String osName = System.getProperty("os.name");
		String projectLocation = System.getProperty("user.dir");
		String filePath = null;
		if (osName.contains("win")) {
			filePath = projectLocation + "\\uploadFiles\\";
		} else {
			filePath = projectLocation + "//uploadFiles//";
		}

		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, locator).sendKeys(fullFileName);
		// sendkeyToElement(driver, UploadPageUI.UPLOAD_FILE_TYPE, fullFileName);
	}

	public String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}
	

	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
