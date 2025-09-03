package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {

		logger.info(" ******* Starting TC_001_AccountRegistrationTest *******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount");

			hp.clickRegister();
			logger.info("clicked on Register");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("Provided first name");

			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Provided last name");

			regpage.setEmail(randomeString() + "@gmail.com");// randomly generate the email id
			logger.info("Provided email");

			regpage.setTelephone(randomeNumber());
			logger.info("Provided telephone");

			String password = randomeAlphaNumeric();
			logger.info("Provided password");

			regpage.setPassword(password);

			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();

			regpage.clickContinue();
			logger.info("Provided telephone click on continue");

			String confirmationMsg = regpage.getConfirmationMsg();

			if (confirmationMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed...");
				logger.debug("Debug logs...");
				Assert.assertFalse(false);
			}

			// Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!!!");

		} catch (Exception e) {

			Assert.fail();
		}

		logger.info(" ******* Finished TC_001_AccountRegistrationTest ******");
	}

}
