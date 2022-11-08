package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	WebDriver driver;
	GeneralUtilities gu;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gu = new GeneralUtilities();
	}

	// web elements

	@FindBy(xpath = "//a[text()='Home']") // with page factory
	WebElement homepage;
	
	@FindBy(xpath = "//li[@class='nav-item dropdown']") // with page factory
	WebElement UserDrowndown;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") // with page factory
	WebElement logoutButton;
	
	
	@FindBy(xpath = "//li[@class='nav-item']//i[@class='fas fa-bars']") // with page factory
	WebElement navBarIcon;
	

	
	
		
	// functions

	public String getHomePageText() {
		
		String text = gu.getElementText(homepage);
		return text;
	}
	
	public String getHomePageURL() {
		String url= gu.getPageURL(driver);
		return url;
	}
	
	public String getHomePageTitle() {
		String url= gu.getPageTitle(driver);
		return url;
	}
	
	public void performLogout() {
		gu.buttonClick(UserDrowndown);
		gu.buttonClick(logoutButton);	
	}
	
	public boolean verifySideBarMenuCollapse() {
		gu.buttonClick(navBarIcon);
		boolean isCollapsed = false;
		String className = driver.findElement(By.xpath("//body")).getAttribute("class");
		if(className.contains("sidebar-collapse"))
			isCollapsed=true;	
		return isCollapsed;
	}

	
}
