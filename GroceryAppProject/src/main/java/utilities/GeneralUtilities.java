package utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	WebDriver driver;

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public boolean elementPresence(WebElement element) {
		return element.isDisplayed();
		
	}

	public void buttonClick(WebElement element) {
		element.click();
	}

	public void inputText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public String getAlertMessage() {
		String msg = driver.switchTo().alert().getText();
		return msg;
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public String getBackgroundColor(WebElement element) {
		String buttonColor = element.getCssValue("background-color");
		return buttonColor;
	}
	
	public String getFontColor(WebElement element) {
		String fontColor = element.getCssValue("color");
		return fontColor;
	}
	
	public String getFontSize(WebElement element) {
		String fontSize = element.getCssValue("font-size");
		return fontSize;
	}

	public String selectDropDownValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedText = selectedElement.getText();
		return selectedText;
	}

	public String selectDynamicItem(List<WebElement> element, String itemName, String dynamicPath) {
		String itemToDelete = null;
		for (int i = 0; i < element.size(); i++) {

			if (element.get(i).getText().equals(itemName)) {
				i = i + 1;
				itemToDelete = dynamicPath;
			}
		}
		return itemToDelete;
	}
}
