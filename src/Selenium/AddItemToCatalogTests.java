package Selenium;

import org.junit.Assert;
import org.junit.Test;

import PageObject.AddItemToCatalogPage;

public class AddItemToCatalogTests extends BasicTest {
	@Test
	public void AddItemToCatalog_FullFlow() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/addItemToCatalog.jsp");

		addItemToCatalogPage.chooseCategory("Bags");
		addItemToCatalogPage.chooseQuantity("100");
		addItemToCatalogPage.enterItemName("My new bag");
		addItemToCatalogPage.enterDescription("My new description");

		addItemToCatalogPage.clickOnSendButton();

	}

	@Test
	public void findSpan() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/precedingFollowingParent.jsp");
		precedingFollowingParentPage.findSpan_ddd();
		System.out.println("yes!");
	}

	@Test
	public void testAddCookies() throws Exception {
		webdriver.openUrl("http://www.google.co.il");

		webdriver.addCookie("Automation", "test_svg");
		System.out.println();

		Assert.assertTrue(webdriver.isCookiesExist("Automation", "test_svg"));
	}
}
