package Commons;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection.Base;
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

import PageUIs.NopCommerce.AdminProductsPageUI;
import PageUIs.NopCommerce.NopCommerceBasePageUI;
import PageUIs.OrangeHRM.OrangeHRMBasePageUI;
import pageObjects.NopCommerce.GeneratorManagerPage;
import pageObjects.NopCommerce.UserAddressesPO;
import pageObjects.NopCommerce.UserCustomerInfoPO;
import pageObjects.NopCommerce.UserMyProductReviewsPO;
import pageObjects.NopCommerce.UserOrdersPO;
import pageObjects.NopCommerce.UserRewardPointsPO;

public class BasePage {
	List<WebElement> elements;
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	private long shortTimeout = 5;
	private long longTimeout = 15;
	
	public void openPageUrl (WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage (WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		if(driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... values) {
		if(driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		getElement(driver, getDynamicLocator(locator, values)).click();
	}
	
	public void clickToElement (WebElement element) {
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		if(driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		WebElement element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		if(driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		WebElement element = getElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}
	
	public int countElementSize(WebDriver driver, String locator, String... values) {
		return getListElement(driver, getDynamicLocator(locator, values)).size();
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getElement(driver, locator));
		select.selectByVisibleText(valueItem);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem, String... values) {
		Select select = new Select(getElement(driver, getDynamicLocator(locator, values)));
		select.selectByVisibleText(valueItem);
	}
	
	public String getSelectItemInDropdown(WebDriver driver, String locator) {
		Select select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		List<WebElement> allItems = getListElement(driver, childItemLocator);

		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				clickToElement(item);
				sleepInSecond(1);
				break;
			}
		}
	}
  
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sleepInMiliSecond(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText().trim();
	}
	
	public String getElementText(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).getText().trim();
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public int getElementNumber(WebDriver driver, String locator) {
		return getListElement(driver, locator).size();
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckbox(WebDriver driver, String locator, String values) {
		WebElement element = getElement(driver, getDynamicLocator(locator, values));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		} 
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	
	public boolean isElementUnDisplay(WebDriver driver, String locator) {
		overideImplicitWait(driver, shortTimeout);
		elements = getListElement(driver, locator);
		overideImplicitWait(driver, longTimeout);
		
		if(elements.size() == 0) {
			System.out.println("Elements không hiển thị trên UI và không có trong DOM");
			return true;
		}
		else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Elements không hiển thị trên UI và có trong DOM");
			return true;
		}
		else {
			System.out.println("Elements không hiển thị trên UI và không có trong DOM");
			return false;
		}
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String locatorSource, String locatorTarget) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(driver, locatorSource), getElement(driver, locatorTarget)).perform();
	}
	
	public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
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
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
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
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {

		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExcutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitForListElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overideImplicitWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overideImplicitWait(driver, longTimeout);
	}
	
	public void overideImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}
	
	/* NopCommerce Project*/

	public void waitForAjaxLoadingIconInvisible(WebDriver driver) {
		waitForElementInvisible(driver, NopCommerceBasePageUI.AJAX_LOADING_ICON);
	}

	// TC Level_06
	public UserCustomerInfoPO clickToCustomerInfoLink(WebDriver driver) {
		waitForElementClickable(driver, NopCommerceBasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, NopCommerceBasePageUI.CUSTOMER_INFO_LINK);
		return GeneratorManagerPage.getUserCustomerInfoPage(driver);
	}
	
	// TC Level_06
	public UserAddressesPO clickToAddressesLink(WebDriver driver) {
		waitForElementClickable(driver, NopCommerceBasePageUI.ADDRESSES_LINK);
		clickToElement(driver, NopCommerceBasePageUI.ADDRESSES_LINK);
		return GeneratorManagerPage.getUserAddressesPage(driver);
	}
	
	// TC Level_06
	public UserOrdersPO clickToOrdersLink(WebDriver driver) {
		waitForElementClickable(driver, NopCommerceBasePageUI.ORDERS_LINK);
		clickToElement(driver, NopCommerceBasePageUI.ORDERS_LINK);	
		return GeneratorManagerPage.getUserOrdersPage(driver);
	}
	
	// TC Level_06
	public UserMyProductReviewsPO clickToMyProductReviewsLink(WebDriver driver) {
		waitForElementClickable(driver, NopCommerceBasePageUI.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, NopCommerceBasePageUI.MY_PRODUCT_REVIEWS_LINK);
		return GeneratorManagerPage.getUserMyProductReviewsPage(driver);
	}
	
	// TC Level_06
	public UserRewardPointsPO clickToRewardPointsLink(WebDriver driver) {
		waitForElementClickable(driver, NopCommerceBasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, NopCommerceBasePageUI.REWARD_POINTS_LINK);
		return GeneratorManagerPage.getUserRewardPointsPage(driver);
	}
	
	public BasePage openLinkByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, NopCommerceBasePageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, NopCommerceBasePageUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Addresses":
			return GeneratorManagerPage.getUserAddressesPage(driver);
		case "Customer info":
			return GeneratorManagerPage.getUserCustomerInfoPage(driver);
		case "Orders":
			return GeneratorManagerPage.getUserOrdersPage(driver);
		case "My product reviews":
			return GeneratorManagerPage.getUserMyProductReviewsPage(driver);
		default:
			return GeneratorManagerPage.getUserRewardPointsPage(driver);
		}
	}
	
	public void openLinkWithPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, NopCommerceBasePageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, NopCommerceBasePageUI.DYNAMIC_LINK, pageName);
	}
	
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, NopCommerceBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, NopCommerceBasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}
	
	public void clickToRadioButtonByID(WebDriver driver, String radioID) {
		waitForElementClickable(driver, NopCommerceBasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioID);
		clickToElement(driver, NopCommerceBasePageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioID);
	}
	
	public void clickToButtonByValue(WebDriver driver, String buttonValue) {
		waitForElementClickable(driver, NopCommerceBasePageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
		clickToElement(driver, NopCommerceBasePageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
	}
	
	public void selectDropdownListByName(WebDriver driver, String dropdownListName, String value) {
		waitForElementVisible(driver, NopCommerceBasePageUI.DYNAMIC_DROPDOWN_LIST_BY_NAME, dropdownListName);
		selectItemInDropdown(driver, NopCommerceBasePageUI.DYNAMIC_DROPDOWN_LIST_BY_NAME, value, dropdownListName);
	}
	
	/*Orange HRM Project*/
	
	public void openMenuPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, OrangeHRMBasePageUI.DYNAMIC_MENU_LINK, pageName);
		clickToElement(driver, OrangeHRMBasePageUI.DYNAMIC_MENU_LINK, pageName);
	}
	
	public void clickToButtonByNameAtFormHeader(WebDriver driver, String headerName, String buttonName) {
		waitForElementClickable(driver, OrangeHRMBasePageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, headerName, buttonName);
		clickToElement(driver, OrangeHRMBasePageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, headerName, buttonName);
	}
	
	public boolean isInfomationDisplayAtColumnNameAndRowName(WebDriver driver, String tableID, String columnName, String rowNumber, String expectedValue) {
		int getColumnIndex = countElementSize(driver, OrangeHRMBasePageUI.DYNAMIC_TABLE_COLUMN_NAME_SIBLING, tableID, columnName) + 1;
		String actualValues = getElementText(driver, OrangeHRMBasePageUI.DYNAMIC_TABLE_CELL_VALUE_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(getColumnIndex));
		return actualValues.equals(expectedValue);
	}

}
