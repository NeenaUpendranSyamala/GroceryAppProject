
package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ExpenseCategory {

	WebDriver driver;
	GeneralUtilities gu;

	public ExpenseCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gu = new GeneralUtilities();
	}

	// web elements

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']//p[text()='Expense Category']")
	WebElement expenseCtgy;

	@FindBy(xpath = "//h1[text()='Expense Category']") // with page factory
	WebElement expenseCtgyPageheading;

	@FindBy(xpath = "//li[2]//p[contains(text(), 'Manage Expense')]") // with page factory
	WebElement manageExpense;

	@FindBy(xpath = "//a[@onclick='click_button(1)']") // with page factory
	WebElement newButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']") // with page factory
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") // with page factory
	WebElement resetButton;

	@FindBy(xpath = "//button[@name='Search' and @type='submit']") // with page factory
	WebElement searchItem;

	@FindBy(xpath = "//input[@id='name']") // with page factory
	WebElement expenseCategoryTitle;

	@FindBy(xpath = "//input[@id='un']") // with page factory
	WebElement searchTitle;

	@FindBy(xpath = "//button[@name='Create']") // with page factory
	WebElement createNewExpenseCategoryButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]") // with page factory
	WebElement addedItem;
	
	@FindBy(xpath = "//button[@name='Update']") // with page factory
	WebElement updateItemBtn;
	

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[2]//i[@class='fas fa-trash-alt']") 
																														
	WebElement deleteIcon;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[2]//i[@class='fas fa-edit']") 
	WebElement editIcon;
	

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") // with page factory
	WebElement deleteSuccessAlert;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") // with page factory
	WebElement updateSuccessAlert;

	// @FindBy(xpath = "//table[@class='table table-bordered table-hover
	// table-sm']//td[1]") // with page factory
	// List<WebElement> expenseCategoryItemsTable = new ArrayList <WebElement>();
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]") // with page factory
	List<WebElement> itemList;

	String dynamicpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\" + i + \"]//td[2]//a[@class='btn btn-sm btn btn-danger btncss']";

	public void clickmanageExpense() {
		gu.buttonClick(manageExpense);
	}

	public void clickExpenseCategory() {
		gu.buttonClick(expenseCtgy);
	}

	public String expenseCateogryPageHeading() {
		return gu.getElementText(expenseCtgyPageheading);
	}

	public void clickNewButton() {
		gu.buttonClick(newButton);
	}

	public void clickSearchButton() {
		gu.buttonClick(searchButton);
	}

	public void clickItemSearch() {
		gu.buttonClick(searchItem);
	}

	public void enterTitle(String title) {
		gu.inputText(expenseCategoryTitle, title);
	}

	public void inputSearchItem(String title) {
		gu.inputText(searchTitle, title);
	}

	public void createNewExpenseCategory() {
		gu.buttonClick(createNewExpenseCategoryButton);
	}

	public String addedItemCheck() {
		String val = gu.getElementText(addedItem);
		return val;
	}

	public void acceptDeleteAlert() {
		gu.acceptAlert();
	}

	public String successAlert() {
		return deleteSuccessAlert.getText();
	}
	
	public String updateSuccessAlert() {
		return updateSuccessAlert.getText();
	}

	public String getNewButtonColor() {
		return gu.getBackgroundColor(newButton);
	}

	public String getSearchButtonColor() {
		return gu.getBackgroundColor(searchButton);
	}

	public String getResetButtonColor() {
		return gu.getBackgroundColor(resetButton);
	}
	
	public void clickEditIcon() {
		editIcon.click();
	}
	
	public void clickUpdateItem() {
		updateItemBtn.click();
	}
	
	public void selectItemToUpdate(String item) {
		String dynamicPath = gu.selectDynamicItem(itemList, item, dynamicpath);
		WebElement cellElement = driver.findElement(By.xpath(dynamicPath));
		cellElement.click();
	}

	public void deleteItem(String itemName) {
		String dynamicItemXpath = gu.selectDynamicItem(itemList, itemName, dynamicpath);
		WebElement cellElement = driver.findElement(By.xpath(dynamicItemXpath));
		cellElement.click();
		driver.switchTo().alert().accept();
	}
}
