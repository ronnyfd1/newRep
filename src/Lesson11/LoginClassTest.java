package Lesson11;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Enums.ByTypes;
import PageObject.LoginPage;
import Selenium.BasicTest;

public class LoginClassTest extends BasicTest {
	/*
	 * @Test public void NavigateToURL() { webdriver.openUrl(
	 * "http://auto-course.us-west-2.elasticbeanstalk.com/loginPage.jsp"); }
	 */

	@Test
	public void LoginWithUserNameAndPassword_VerifyCorrectCredentials() {
		webdriver.getElementById("username").sendKeys("ronny");
		webdriver.getElementById("password").sendKeys("12345");
		webdriver.getElement(ByTypes.xpath, "//button[@class = 'btn btn-primary']").click();

		String userNameText = webdriver.getElement(ByTypes.xpath,"//div[@id = 'username']").getText();
		String passwordText = webdriver.getElement(ByTypes.xpath,"//div[@id = 'password']").getText();

		Assert.assertTrue("User name Text not found!", userNameText.equals("ronny"));
		Assert.assertTrue("Password Text not found!", passwordText.equals("12345"));
	}

	@Test
	public void LoginWithUserNameAndPassword_VerifyMessageWhenWrongText() {
		webdriver.getElementById("username").sendKeys("ronny");
		webdriver.getElementById("password").sendKeys("12345");
		webdriver.getElement(ByTypes.xpath,"//button[@class = 'btn btn-primary']").click();

		String userNameText = webdriver.getElement(ByTypes.xpath,"//div[@id = 'username']").getText();
		String passwordText = webdriver.getElement(ByTypes.xpath,"//div[@id = 'password']").getText();

		Assert.assertTrue("User name Text not found!", userNameText.equals("aaa"));
		Assert.assertTrue("Password Text not found!", passwordText.equals("54321"));
	}

	@Test
	public void testPrintTableContent() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/table.html");
		List<WebElement> cells = webdriver.getElementsByXpath("//table[@class = 'table']//tr//td");
		for (int i = 0; i < cells.size(); i++) {
			System.out.println("Text in cell " + i + " :" + cells.get(i).getText());
		}

	}

	@Test 
	public void testGetImageAndPrintItsName() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/images.html");
		String txt = webdriver.getElement(ByTypes.xpath,"//img").getAttribute("src");
		System.out.println(txt.substring(txt.length()-12,txt.length()));

	}
	
	/*@Test
	public void testGetImageAndPrintItsName2(){
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/loginPage.jsp");
		loginPage.enterUserName("Nir");
		loginPage.enterPassword("54231");
		loginPage.clickOnSubmit();
		System.out.println("ddd");
	}*/
	
}
