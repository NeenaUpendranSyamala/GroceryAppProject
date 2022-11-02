package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	WebDriver driver;
	GeneralUtilities gu;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// web elements

	@FindBy(xpath = "//a[text()='Home']") // with page factory
	WebElement homepage;

	// functions

	public String getHomePageText() {
		gu = new GeneralUtilities();
		String text = gu.getElementText(homepage);
		return text;
	}

}
