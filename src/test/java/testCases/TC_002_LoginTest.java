package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verify_login() {

		try {
			logger.info(" ******** Starting TC_002_LoginTest ********");

			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();

			// MyAccount page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
			// Assert.assertEquals(targetpage, true);
			Assert.assertTrue(targetpage);
			// Assert.assertEquals(targetpage, true, "Login Failed");

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***********   Finished TC_002_LoginTest **************");
	}
}
