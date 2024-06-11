/**
 * 
 */
package baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseClass initializes WebDriver and loads configuration properties before test suite execution.
 */
public class BaseClass {

	// Properties objects for configuration and locators
	public static Properties config = new Properties();
	public static Properties locator = new Properties();
	public static FileInputStream fileCo;
	public static FileInputStream fileLo;
	public static WebDriver driver;

	@BeforeSuite

	//Method to set up WebDriver and load configuration properties before test suite execution.
	public void setUp() {
		
		//// Load config and locator properties files
		try {
			fileCo = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/propertiesFiles/config.properties");
			config.load(fileCo);
			fileLo = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/propertiesFiles/locator.properties");
			locator.load(fileLo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Initialize WebDriver based on the browser specified in the config properties
		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		// Set timeouts for WebDriver
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Open the URL specified in the config properties
		driver.get(config.getProperty("url"));

	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
