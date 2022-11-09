package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProduct {

	WebDriver driver;
	GeneralUtilities gu;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gu = new GeneralUtilities();
	}

	// web elements

	@FindBy(xpath = "//a[@class=' nav-link']//p[text()='Manage Product']") // with page factory
	WebElement managePdt;

	@FindBy(xpath = "//a[@onclick='click_button(1)']") // with page factory
	WebElement addNewPdtBtn;

	@FindBy(xpath = "//div[@class='content-header']//h1[text()='List Products']") // with page factory
	WebElement ManagePdtPageHeader;
	
	@FindBy(xpath = "//input[@name='unlimitw[]']") // with page factory
	WebElement unLtfStockChckbox;
	
	@FindBy(xpath = "//input[@value='Veg' and @name='type']") // with page factory
	WebElement RadioBtn_defaultPdtTyp;
	
	
	@FindBy(xpath = "//input[@name='price_type' and @id='purpose']") // with page factory
	WebElement RadioBtn_defaultPriceTyp;
	

	// functions

	public void loadManageProductPage() {
		gu.buttonClick(managePdt);

	}
	
	public boolean unLimitedStockCheckboxStatus() {
		return gu.isCheckboxEnabled(unLtfStockChckbox);
	}
	
	public boolean ProductTypeDefaultValue() {
		return gu.isRadioButtonEnabled(RadioBtn_defaultPdtTyp);
	}
	
	public boolean PriceTypeDefaultValue() {
		return gu.isRadioButtonEnabled(RadioBtn_defaultPriceTyp);
	}

	public void loadAddNewPdtPage() {
		gu.buttonClick(addNewPdtBtn);

	}

	public String getManageProductPageText() {
		String text = gu.getElementText(ManagePdtPageHeader);
		return text;
	}

	public String getManagePdtPageTitle() {
		String url = gu.getPageTitle(driver);
		return url;
	}
}
