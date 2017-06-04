package Selenium;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import PageObject.AddItemToCatalogPage;
import PageObject.FacebookMainPage;
import PageObject.IkeaCatalogPage;
import PageObject.IkeaMainPage;
import PageObject.LoginPage;
import PageObject.PrecedingFollowingParentPage;
import TestObjects.TestLog;
import services.HtmlReporterImpl;
import services.IReporter;

public class BasicTest {
	protected GenericWebDriver webdriver;
	protected LoginPage loginPage;
	public AddItemToCatalogPage addItemToCatalogPage;
	public PrecedingFollowingParentPage precedingFollowingParentPage;
	public IkeaMainPage ikeaMainPage;
	public IkeaCatalogPage ikeaCatalogPage;
	public FacebookMainPage facebookMainPage;
	public TestLog testLog;

	IReporter reporter;

	@Before
	public void setup() throws Exception {
		reporter = new HtmlReporterImpl();

		// instance of generic webdriver
		webdriver = new GenericWebDriver();
		testLog = new TestLog();
		webdriver.init("http://localhost:4444/wd/hub", testLog);
		// webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/loginPage.jsp");
		loginPage = new LoginPage(webdriver);
		addItemToCatalogPage = new AddItemToCatalogPage(webdriver);
		precedingFollowingParentPage = new PrecedingFollowingParentPage(webdriver);
		ikeaMainPage = new IkeaMainPage(webdriver);
		ikeaCatalogPage = new IkeaCatalogPage(webdriver);
		facebookMainPage = new FacebookMainPage(webdriver);

	}

	@After
	public void tearDown() throws Exception {

		List<LogEntry> logs = webdriver.getWebBrowserLogs().getAll();
		for (int i = 0; i < logs.size(); i++) {
			System.out.println(logs.get(i).getMessage());
		}

		webdriver.quit();
		reporter.saveTestLog(testLog);
	}
}
