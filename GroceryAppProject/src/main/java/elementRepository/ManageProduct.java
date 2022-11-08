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

		@FindBy(xpath = "//a[text()='Home']") // with page factory
		WebElement homepage;
		
	// functions

		public String getHomePageText() {
			
			String text = gu.getElementText(homepage);
			return text;
		}
}
