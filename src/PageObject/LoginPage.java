package PageObject;

import Enums.ByTypes;
import Selenium.GenericWebDriver;

public class LoginPage extends GenericPageObject {

	private static final String USERNAME_XPATH = "//input[@id = 'username']";
	private static final String PASSWORD_XPATH = "//input[@id = 'password']";
	private static final String SUBMIT_XPATH = "//button[@class = 'btn btn-primary']";
	//private static final String SUBMIT_XPATH = "//button[@text() = 'submit']";

	public LoginPage(GenericWebDriver webDriver) {
		super(webDriver);

	}

	/*public void enterUserName(String userName) {
		webDriver.getElement(ByTypes.xpath,USERNAME_XPATH).sendKeys(userName);
	}

	public void enterPassword(String password) {
		webDriver.getElement(ByTypes.xpath,PASSWORD_XPATH).sendKeys(password);
	}
	
	public void clickOnSubmit(){
		webDriver.getElement(ByTypes.xpath,SUBMIT_XPATH).click();
	}*/

}
