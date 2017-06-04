package Selenium;

import org.junit.Test;

import PageObject.FacebookMainPage;

public class FaceBookMainPageTests extends BasicTest {
	@Test
	public void loginToMyFb_User_Password_Valid() throws Exception {
		webdriver.openUrl("https://www.facebook.com/");
		facebookMainPage.enterUserNameWithEmail("ronnyfd1@gmail.com");
		facebookMainPage.enterPassword("12345");
		facebookMainPage.clickOnLogIn();

	}
	
	@Test
	public void loginToMyFb_User_Password_Invalid() throws Exception {
		webdriver.openUrl("https://www.facebook.com/");
		facebookMainPage.enterUserNameWithEmail("ronnyfd1@gmail.com");
		facebookMainPage.enterPassword("12345");
		facebookMainPage.clickOnLogIn();

	}
}
