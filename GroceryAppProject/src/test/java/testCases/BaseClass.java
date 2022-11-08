package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenShotCapture;

public class BaseClass {

	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		prop.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browservalue) throws IOException {
		testBasic();
		if (browservalue.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") // system.getproperty
					+ "\\src\\test\\resources\\DriverFiles\\chromedriver.exe");
			// takes the path till project location via java and then we append the rest of the path
			
			driver = new ChromeDriver();
		} 
		else if (browservalue.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
					+ "\\src\\test\\resources\\DriverFiles\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("BaseURL"));
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	/*
	 * @AfterMethod public void afterMethod(ITestResult itestResult) throws
	 * IOException { // if the test fails, screenshot is captured if
	 * (itestResult.getStatus() == ITestResult.FAILURE) { sc = new
	 * ScreenShotCapture(); sc.captureScreenShotFailures(driver,
	 * itestResult.getName()); }
	 */

	@AfterMethod
	public void afterMethod() {
		// if the test fails, screenshot is captured

		driver.close();
	}
}
