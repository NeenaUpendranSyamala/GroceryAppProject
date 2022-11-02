package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageExpenses {

	WebDriver driver;
	GeneralUtilities gu;
	ExplicitWait ew;

	public ManageExpenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gu = new GeneralUtilities();
		ew= new ExplicitWait();
	}

	// web elements

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']//p[text()='Manage Expense']") 
	WebElement ListExpenses;
	
	@FindBy(xpath = "//li[2]//p[contains(text(), 'Manage Expense')]") // with page factory
	WebElement manageExpense;
	
	@FindBy(xpath = "//h1[text()='List Expense']") // with page factory
	WebElement ListExpensePageHeading;
	
		
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
	
	
	public void loadManageExpense() {
		gu.buttonClick(manageExpense);
	}
	
	public void loadListExpenses() {
		gu.buttonClick(ListExpenses);
		ew.presenceOfWebElementLocated(driver, "//h1[text()='List Expense']");
	}
	
	public String manageExpensesPageLoad() {
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
		return  gu.elementPresence(userIdField);
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

}
