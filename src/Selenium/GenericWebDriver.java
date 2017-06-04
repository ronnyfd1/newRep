package Selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

import Enums.ByTypes;
import TestObjects.TestLog;
import services.Utils.fileUtils;

public class GenericWebDriver {
	// remote webdriver
	RemoteWebDriver webdriver;
	TestLog testLog;

	// remote url = address of node/grid
	public void init(String remoteUrl, TestLog testLog) throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences loggingPreferences = new LoggingPreferences();
		loggingPreferences.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

		webdriver = new RemoteWebDriver(new java.net.URL(remoteUrl), capabilities);

	}

	public LogEntries getWebBrowserLogs() {
		return webdriver.manage().logs().get(LogType.BROWSER);
	}

	// navigate to a url
	public void openUrl(String url) {
		webdriver.get(url);
	}

	public void quit() {
		webdriver.quit();
	}

	public WebElement getElementByXpath(String xpath) {
		return getElement(ByTypes.xpath, xpath);
	}

	public WebElement getElement(ByTypes type, String value) {
		WebDriverWait wait = new WebDriverWait(webdriver, 10, 1000);

		WebElement element = null;

		try {
			switch (type) {
			case xpath:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				break;

			case id:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;

			case className:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				break;

			case name:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;

			case link:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			printScreen("Element_not_found:_" + value + "used_type_" + type);
			e.printStackTrace();
		}

		return element;

	}

	public List<String> getComboBoxValues(String xpath) {
		// gets the combobox element
		WebElement comboboxElement = getElement(ByTypes.xpath, xpath);

		// create a combobox element
		Select select = new Select(comboboxElement);
		// create a list of webElements from the combobox values
		List<WebElement> comboValues = select.getOptions();
		// creates a list of strings that will hold the text
		List<String> listStr = new ArrayList<String>();
		// iterates over the WebElements list and gets the text from each
		// WebElement
		for (WebElement element : comboValues) {
			listStr.add(element.getText());
		}
		// return the list of strings
		return listStr;
	}

	public WebElement getElementById(String id) {
		WebDriverWait wait = new WebDriverWait(webdriver, 10, 1000);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

		return element;
	}

	public WebElement getElementByClass(String className) {
		WebDriverWait wait = new WebDriverWait(webdriver, 10, 1000);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));

		return element;
	}

	public List<WebElement> getElementsByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 10, 1000);

		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return list;
	}

	public void selectComboBoxOptions(String optionVale, String xpath) throws Exception {

		try {
			WebElement comboBox = getElement(ByTypes.xpath, xpath);

			Select select = new Select(comboBox);

			select.selectByVisibleText(optionVale);
		} catch (Exception e) {
			printScreen("SelectingFromComboBoxFailed");
			e.printStackTrace();
		}

	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		webdriver.manage().addCookie(cookie);
	}

	public boolean isCookiesExist(String name, String value) {
		Cookie cookie = webdriver.manage().getCookieNamed(name);

		if (cookie != null) {
			if (cookie.getValue().equals(value)) {
				return true;
			} else
				return false;
		} else
			return false;

	}

	public String printScreen(String prefix) {
		File screenshot = null;

		String newPath = null;

		try {
			WebDriver augmentedDriver = new Augmenter().augment(webdriver);
			screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			newPath = System.getProperty("user.dir") + "\\files\\scr\\" + prefix + screenshot.getName();
			fileUtils.copyFile(screenshot, newPath);

		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}

		return newPath;

	}

	public void switchToTab(int tabIndex) throws Exception {
		webdriver.getWindowHandle();

	}

	public void dragAndDrop(String xpathFrom, String xpathTo) {
		Actions actions = new Actions(webdriver);
		WebElement elementFrom = getElement(ByTypes.xpath, xpathFrom);
		WebDriverWait wait = new WebDriverWait(webdriver, 10);
		actions.dragAndDrop(elementFrom, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTo))))
				.build().perform();
		;
	}

}
