package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

import Enums.ByTypes;
import Selenium.GenericWebDriver;

public class IkeaMainPage extends GenericPageObject {

	private static final String SEARCHFIELD_XPATH = "//span[@class ='search']//preceding-sibling::input";
	
	public IkeaMainPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void searchForItem(String value) {
		try {
			WebElement searchField = webDriver.getElement(ByTypes.xpath, SEARCHFIELD_XPATH);
			searchField.sendKeys(value);
			WebElement submit = webDriver.getElement(ByTypes.id, "search_btn_find");
			submit.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("The number item: " + value + " does not exists");
		}
	}

}
