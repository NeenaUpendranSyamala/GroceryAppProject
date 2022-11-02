package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;

	@Test(enabled = true)
	public void verifySignInButtonText() {
		lp = new LoginPage(driver);
		String actual = lp.getSignInText();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "Sign In text is not as expected");
	}

	@Test(enabled = true, priority = 1, groups = { "Critical" })
	public void verifyLoginForValidUser() throws IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		lp.performLogin(Constants.userName, Constants.password);
		String actual = hp.getHomePageText();
		String expected = "Home";
		Assert.assertEquals(actual, expected, "Unsuccessful Login");
	}

	@Test(enabled = true)
	public void verifyLoginForInValidUser() throws IOException {

		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		String user = ExcelRead.readStringData(1, 0);
		String pwd = ExcelRead.readStringData(1, 1);
		lp.performLogin(user, pwd);
		String actual = lp.getAlertMsg();
		String expected = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actual, expected, "Alert not as expected");
	}

	@Test(enabled = true)
	public void verifySignInButtonColor() {
		lp = new LoginPage(driver);
		String actual = lp.getSignInButtonColor();
		String expected = "rgba(52, 58, 64, 1)";
		Assert.assertEquals(actual, expected, "Sign In button color is not as expected");
	}

}
