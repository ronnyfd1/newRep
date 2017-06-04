package PageObject;

import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import Enums.ByTypes;
import Selenium.GenericWebDriver;

public class IkeaCatalogPage extends GenericPageObject {

	private static final String ITEMPRICETEXT_XPATH = "//div[@class='price ng-binding']";
	// private static final String WISHLIST_XPATH = "//div[@class
	// ='product_quantity']//div";
	private static final String WISHLIST_XPATH = "//div[contains(@class,'add_to_wishlist ')]";
	private static final String MAKAT_XPATH = "//div[@class ='search_inner']//div";
	private static final String WATCHMYLIST_XPATH = "//a[@href,'/wishlist']";

	public IkeaCatalogPage(GenericWebDriver webDriver) {
		super(webDriver);
	}

	public String getItemPrice() {
		String price = webDriver.getElement(ByTypes.xpath, ITEMPRICETEXT_XPATH).getText();
		// System.out.println(price);
		price = price.substring(0, price.length() - 2);
		// System.out.println(price);
		return price;
	}

	public void addItemToWishList() {
		WebElement addItemToWishListButton = webDriver.getElement(ByTypes.xpath, WISHLIST_XPATH);
		addItemToWishListButton.click();
	}

	public void watchMyList() {
		try {
			webDriver.getElement(ByTypes.xpath, WATCHMYLIST_XPATH).click();
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannot find the button watch my list");
		}
	}

	public String getMakat() {
		String makat = webDriver.getElement(ByTypes.xpath, MAKAT_XPATH).getText();
		return makat;

	}

}
