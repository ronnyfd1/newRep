package Selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import Enums.ByTypes;
import PageObject.IkeaCatalogPage;

public class MyFirstTestClass extends BasicTest {

	@Test
	public void myFirstSeleniumTest() {
		webdriver.openUrl("http://www.google.co.il");
	}

	/*
	 * @After public void tearDown(){ super.tearDown(); }
	 */
	/*@Test
	public void myFirstSeleniumTest2() {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/loginPage.jsp");
		// webdriver.getElementByXpath("//input[@name = 'q']").sendKeys("wow
		// wow");
		// webdriver.getElementByXpath("//input[@name =
		// 'q']").sendKeys(Keys.ENTER);
		loginPage.enterUserName("ronny");
		loginPage.enterPassword("123");
		loginPage.clickOnSubmit();
		System.out.println("ddd");

		System.out.println("ddd");
	}*/

	@Test
	public void testScreenShot() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/loginPage.jsp");
		webdriver.printScreen("_error");
		webdriver.getElement(ByTypes.id, "dsss");
	}

	@Test
	public void twoBrowsers() throws Exception {
		webdriver.openUrl("http://www.google.co.il");
		GenericWebDriver webdriver2 = new GenericWebDriver();
		//webdriver2.init("http://localhost:4444/wd/hub", );
		webdriver2.openUrl("http://cnn.com");
		webdriver2.quit();
	}

	@Test
	public void ikeaTest() throws Exception {
		// open ikea website
		testLog.addStep("First step");
		webdriver.openUrl("https://www.ikea.co.il/");
		// search for item 20169559
		// best practice: the item id will be generated from db/external file
		ikeaMainPage.searchForItem("20169559");
		testLog.addStep("Second Step  ! ! !");
		// Get the item price and check that its 695
		ikeaCatalogPage.getItemPrice();
		testLog.addAction("action one");
		// add assertion that the price is 695
		Assert.assertEquals(ikeaCatalogPage.getItemPrice(), "695");
		// Add item to wishlist
		ikeaCatalogPage.addItemToWishList();
		// Open the wish list and check that the item is added
		ikeaCatalogPage.watchMyList();
		// assert that the item is added! ! !
		Assert.assertEquals(ikeaCatalogPage.getMakat(), "20169559");

	}
	
	@Test
	public void dragAndDropTest(){
		webdriver.openUrl("http://www.elated.com/res/File/articles/development/javascript/jquery/drag-and-drop-with-jquery-your-essential-guide/draggable.html");
		webdriver.dragAndDrop("//div[@class='ui-draggable']","//div[@class='wideBox']");
		System.out.println("f");
	}
	
	@Test
	public void test(){
		testLog.addStep("login to...");
		testLog.addAction("");
	}
}
