package actionDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import listeners.Listerners;

/*
 * Provides reusable methods for common Selenium actions like type, click, and select
 */

public class ActionDriver extends BaseClass {

	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public static WebElement element;

	 // Method to type text into an input field
	public static void type(String value, String locators) {
		
		// Conditional logic based on locator type
		if (locators.endsWith("_xpath")) {
			element = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(BaseClass.locator.getProperty(locators)))));
			element.clear();
			element.sendKeys(value);
		} else if (locators.endsWith("_name")) {
			element = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.name(BaseClass.locator.getProperty(locators)))));
			element.clear();
			element.sendKeys(value);
		} else if (locators.endsWith("_className")) {
			element = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.className(BaseClass.locator.getProperty(locators)))));
			element.clear();
			element.sendKeys(value);
		}
		// Log the action
		Listerners.test.get().info("Entered: " + value + " On " + locators);
	}

	// Method to click on an element
	public static void click(String locators) {
		if (locators.endsWith("_xpath")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(BaseClass.locator.getProperty(locators))))).click();
		} else if (locators.endsWith("_name")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.name(BaseClass.locator.getProperty(locators))))).click();
		} else if (locators.endsWith("_className")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.className(BaseClass.locator.getProperty(locators))))).click();
		}
		// Log the action
		Listerners.test.get().info("Clicked On: "+ locators);
	}

	// Method to select an option from a dropdown
	public static void select(String value, String locators) {

		Select select;

		if (locators.endsWith("_xpath")) {

			select = new Select(wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath(BaseClass.locator.getProperty(locators))))));
			select.selectByVisibleText(value);
		} else if (locators.endsWith("_name")) {
			select = new Select(wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.name(BaseClass.locator.getProperty(locators))))));
			select.selectByVisibleText(value);
		} else if (locators.endsWith("_className")) {
			select = new Select(wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.className(BaseClass.locator.getProperty(locators))))));
			select.selectByVisibleText(value);

		}
		// Log the action
		Listerners.test.get().info("Selected: " + value + " On " + locators);
	}
	
	// Method to return a list of WebElements
	public static List<WebElement> webelementList(String locators)
	{
		List<WebElement> list = driver.findElements(By.xpath(locator.getProperty(locators)));
		return list;
	}

}
