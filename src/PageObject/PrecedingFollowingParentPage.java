package PageObject;

import Enums.ByTypes;
import Selenium.GenericWebDriver;

public class PrecedingFollowingParentPage extends GenericPageObject {

	private static final String ABCDDD = "//span[@id='abc']//following-sibling::span";

	public PrecedingFollowingParentPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void findSpan_ddd() {
		webDriver.getElement(ByTypes.xpath, ABCDDD);
	}

}
