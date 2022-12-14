package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotCapture {

	public void captureScreenShotFailures(WebDriver driver, String name) throws IOException {

		// For taking screenshots
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		// Call getScreenshotAs method to create image file
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);

		// java code to create a folder
		File f1 = new File(System.getProperty("user.dir" )+ "\\Output Screenshots"); // generating folder using java
		if (!f1.exists()) {
			f1.mkdirs();
		}

		// java code for taking system date and time
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

		File finalDestination = new File(System.getProperty("user.dir") + "\\Output Screenshots" + name + timeStamp + ".png");
		FileHandler.copy(screenShot, finalDestination);
	}

}
