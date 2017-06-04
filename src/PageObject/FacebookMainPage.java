package PageObject;

import Enums.ByTypes;
import Selenium.GenericWebDriver;

public class FacebookMainPage extends GenericPageObject {

	//private static final String USERNAMEEMAIL_XPATH = "//input[@id='email']";
	//private static final String PASSWORD_XPATH = "//input[@id='pass']";
	private static final String LOGIN_XPATH = "//input[@testId='royal_login_button']";

	public FacebookMainPage(GenericWebDriver webDriver) {
		super(webDriver);

	}

	public void enterUserNameWithEmail(String email) {
		webDriver.getElement(ByTypes.id, "email").sendKeys(email);
		;
	}

	public void enterPassword(String pass) {
		webDriver.getElement(ByTypes.id, "pass").sendKeys(pass);
		;
	}

	public void clickOnLogIn() {
		webDriver.getElement(ByTypes.xpath, LOGIN_XPATH);
	}

}
