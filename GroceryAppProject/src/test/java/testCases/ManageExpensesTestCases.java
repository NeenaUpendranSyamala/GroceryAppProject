package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenses;

public class ManageExpensesTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageExpenses me;

	@Test(enabled = true)
	public void verifyManageExpensePageLoad() {
		lp = new LoginPage(driver);
		me = new ManageExpenses(driver);
		lp.performLogin(Constants.userName, Constants.password);
		me.loadManageExpense();
		me.loadListExpenses();
		String actualpageheader = me.manageExpensesPageLoad();
		String expectedpageHeader = Constants.expectedPageHeader;
		Assert.assertEquals(actualpageheader, expectedpageHeader, " Page is not loaded");
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonFontSize() {
		lp = new LoginPage(driver);
		me = new ManageExpenses(driver);
		lp.performLogin(Constants.userName, Constants.password);
		me.loadManageExpense();
		me.loadListExpenses();
		Assert.assertEquals(me.getNewBtnFontSize(), "16px", " font size not as expected");
		Assert.assertEquals(me.getSearchBtnFontSize(), "16px", " font size not as expected");
		Assert.assertEquals(me.getResetBtnFontsize(), "16px", " font size not as expected");
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonFontColor() {
		lp = new LoginPage(driver);
		me = new ManageExpenses(driver);
		lp.performLogin(Constants.userName, Constants.password);
		me.loadManageExpense();
		me.loadListExpenses();
		Assert.assertEquals(me.getNewBtnFontColor(), "rgba(220, 53, 69, 1)", " New btn font color not as expected");
		Assert.assertEquals(me.getSearchBtnFontColor(), "rgba(0, 123, 255, 1)",
				" Search btn font color not as expected");
		Assert.assertEquals(me.getResetBtnFontColor(), "rgba(255, 193, 7, 1)", " Reset btn font color not as expected");

	}

	@Test(enabled = true)
	public void verifyAddExpenseFields() {
		lp = new LoginPage(driver);
		me = new ManageExpenses(driver);
		lp.performLogin(Constants.userName, Constants.password);
		me.loadManageExpense();
		me.loadListExpenses();
		me.loadAddExpensePage();
		Assert.assertTrue(me.verifyUserNameFieldPresence());
		Assert.assertTrue(me.verifyExpenseTypeFieldPresence());
		Assert.assertTrue(me.verifyDateFieldPresence());
		Assert.assertTrue(me.verifyAmountFieldPresence());
	}

	@Test(enabled = false)
	public void verifyAddNewExpense() {
		lp = new LoginPage(driver);
		me = new ManageExpenses(driver);
		lp.performLogin(Constants.userName, Constants.password);
		me.loadManageExpense();
		me.loadListExpenses();
		String actual = me.manageExpensesPageLoad();
		String expected = "List Expense";
		Assert.assertEquals(actual, expected, " Page is not loaded");
	}
}
