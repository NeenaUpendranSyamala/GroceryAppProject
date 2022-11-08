package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gu = new GeneralUtilities();
	}

	// web elements

	@FindBy(xpath = "//button[text()='Sign In']") // with page factory
	WebElement SignInText;

	@FindBy(xpath = "//input[@name='username']") // with page factory
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']") // with page factory
	WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']") // with page factory
	WebElement login;

	@FindBy(xpath = "//div[contains(@class,'alert-danger')]") // with page factory
	WebElement alertMsg;

//	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") //with page factory
//	WebElement alertMsg;

	public String getSignInText() {
		return gu.getElementText(SignInText);
	}

	public void inputUsername(String user) {
		userName.sendKeys(user);
	}

	public void inputPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void Login() {
		login.click();
	}

	public void performLogin(String user, String pwd) {
		userName.sendKeys(user);
		password.sendKeys(pwd);
		login.click();
	}

	public String getAlertMsg() {
		return alertMsg.getText();
	}

	public String getSignInButtonColor() {
		return gu.getBackgroundColor(login);
	}
	

}
