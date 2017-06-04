package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Enums.ByTypes;
import Selenium.GenericWebDriver;

public class AddItemToCatalogPage extends GenericPageObject {

	private static final String QUANTITY_XPATH = "//select[@name='qty']";
	private static final String CATEGORY_XPATH = "//label[text()='Category']//following-sibling::select";
	private static final String ITEMNAME_XPATH = "//input[@id = 'itemName']";
	private static final String ITEMDESCRIPTION_XPATH = "//label[contains(text(),'Item description')]/following-sibling::input";
	private static final String SUBMITBUTTON_XPATH = "//input[@type = 'submit']";

	public AddItemToCatalogPage(GenericWebDriver webDriver) {
		super(webDriver);

	}

	public void chooseQuantity(String optionVale) throws Exception {
		webDriver.selectComboBoxOptions(optionVale, QUANTITY_XPATH);
	}

	public void chooseCategory2(String optionVale) throws Exception {
		webDriver.selectComboBoxOptions(optionVale, CATEGORY_XPATH);
	}

	public void enterItemName(String itemName) {
		webDriver.getElement(ByTypes.xpath,ITEMNAME_XPATH).sendKeys(itemName);
	}

	public void enterDescription(String description) {
		webDriver.getElement(ByTypes.xpath,ITEMDESCRIPTION_XPATH).sendKeys(description);
	}

	public void clickOnSendButton() {
		webDriver.getElement(ByTypes.xpath,ITEMDESCRIPTION_XPATH).click();
	}

}
