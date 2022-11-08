package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageExpenses {

	WebDriver driver;
	GeneralUtilities gu;
	ExplicitWait ew;
	Actions obj;

	public ManageExpenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gu = new GeneralUtilities();
		ew = new ExplicitWait();
		obj = new Actions(driver);

	}

	// web elements

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']//p[text()='Manage Expense']")
	WebElement ListExpenses;

	@FindBy(xpath = "//li[2]//a[@class='nav-link']//i[@class='nav-icon fas fa-money-bill-alt']") // with page factory
	WebElement manageExpense;

	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Create Merchant']") // with page factory
	WebElement createMerchant;

	@FindBy(xpath = "//h1[text()='List Expense']") // with page factory
	WebElement ListExpensePageHeading;

	@FindBy(xpath = "//h1[text()='Create Merchant']") // with page factory
	WebElement createMerchantPageHeading;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']") // with page factory
	WebElement newButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']") // with page factory
	WebElement searchButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-warning']") // with page factory
	WebElement resetButton;

	@FindBy(xpath = "//select[@id ='user_id']") // with page factory
	WebElement userIdField;

	@FindBy(xpath = "//input[@id='ex_date']") // with page factory
	WebElement dateField;

	@FindBy(xpath = "//select[@id='ex_type']") // with page factory
	WebElement expenseTypeField;

	@FindBy(xpath = "//input[@id='amount']") // with page factory
	WebElement amountField;

	@FindBy(xpath = "//button[@name='create']") // with page factory
	WebElement createBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") // with page factory
	WebElement CreateSuccessAlert;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement chooseFileBtn;

	String filePath =System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\SampleFile.docx";

	public void loadManageExpense() {
		gu.buttonClick(manageExpense);
	}

	public void loadListExpenses() {
		gu.buttonClick(ListExpenses);
	}

	public void loadCreateExpense() {
		gu.buttonClick(createMerchant);
	}

	public String manageExpensesPageLoad() {
		return gu.getElementText(ListExpensePageHeading);
	}

	public String createMerchantPageLoad() {
		return gu.getElementText(ListExpensePageHeading);
	}

	public String getNewBtnFontColor() {
		return gu.getBackgroundColor(newButton);
	}

	public String getSearchBtnFontColor() {
		return gu.getBackgroundColor(searchButton);
	}

	public String getResetBtnFontColor() {
		return gu.getBackgroundColor(resetButton);
	}

	public String getNewBtnFontSize() {
		return gu.getFontSize(newButton);
	}

	public String getSearchBtnFontSize() {
		return gu.getFontSize(searchButton);
	}

	public String getResetBtnFontsize() {
		return gu.getFontSize(resetButton);
	}

	public void loadAddExpensePage() {
		gu.buttonClick(newButton);
	}

	public boolean verifyUserNameFieldPresence() {
		return gu.elementPresence(userIdField);
	}

	public boolean verifyDateFieldPresence() {
		return gu.elementPresence(dateField);
	}

	public boolean verifyExpenseTypeFieldPresence() {
		return gu.elementPresence(expenseTypeField);
	}

	public boolean verifyAmountFieldPresence() {
		return gu.elementPresence(amountField);
	}

	public void addUser(String user) {
		gu.selectDropDownValue(userIdField, user);
	}

	public void addDate(String date) {
		gu.inputText(dateField, date);
	}

	public void addAmount(String amt) {
		gu.inputText(amountField, amt);
	}

	public void addExpenseCategory(String expenseCtgryt) {
		gu.selectDropDownValue(expenseTypeField, expenseCtgryt);
	}

	public void AddDetails(String user, String expenseCtgry, String amt) {
		addUser(user);
		addExpenseCategory(expenseCtgry);
		addAmount(amt);

	}

	public void FileUpload() throws AWTException, InterruptedException {

		gu.performFileUpload(chooseFileBtn, driver, filePath);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling using JavascriptExecutor
		js.executeScript("window.scrollBy(0,380)");// Scroll Down to file upload button (+ve)
	
		ew.presenceOfWebElementLocated(driver, "//button[@name='create']");

	}

	public void createExpenseRecord() {
		gu.buttonClick(createBtn);
	}

	public String successAlert() {
		return CreateSuccessAlert.getText();
	}

}
