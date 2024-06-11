package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actionDriver.ActionDriver;
import baseClass.BaseClass;

public class webTable extends BaseClass {

	

	public webTable(WebDriver driver) {
		BaseClass.driver = driver;
	}

	//clicks the "Add User Button"
	public void clickAddUserButton() {
		ActionDriver.click("addUser_xpath");
	}
	// Enters the first name  in the respective input field
	public void enterFirstName(String value) {
		ActionDriver.type(value, "firstName_name");
	}
	// Enters the last name  in the respective input field
	public void enterLastName(String value) {
		ActionDriver.type(value, "lastName_name");
	}
	// Enters the username  in the respective input field
	public void enterUserName(String value) {
		ActionDriver.type(value, "userName_name");
	}
	// Enters the password  in the respective input field
	public void enterPassword(String value) {
		ActionDriver.type(value, "password_name");
	}
	//Selects the customer radio button based on the provided value
	public void selectCustomerRadioButton(String value) {

		if (value.equalsIgnoreCase("Company AAA")) {
			ActionDriver.click("companyAaaRadio_xpath");
		} else {
			ActionDriver.click("companyBbbRadio_xpath");
		}
	}
	// Selects the role from the dropdown based on the provided value
	public void selectRole(String value) {
		ActionDriver.select(value, "role_xpath");
	}
	//Enters the email in the respective input field
	public void enterEmail(String value) {
		ActionDriver.type(value, "email_name");
	}
	// Enters the cellphone number in the respective input field
	public void enterCellPhone(String value) {
		ActionDriver.type(value, "cellPhone_name");
	}
	//clicks the "Save Button"
	public void clickSaveButton() {
		ActionDriver.click("saveButton_xpath");
	}
	
	//Verifies if a user is present in the user list table by username
	public boolean isUserPresent(String value)
	{
		List<WebElement> userList = ActionDriver.webelementList("userNameList");
		
		for(int i=1; i <userList.size()-1;i++)
		{
			String selectUserName = driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[3]")).getText();
			
			if(selectUserName.equalsIgnoreCase(value))
			{
				
				System.out.println("The user name is "+ selectUserName);
				return true;// User found in the table
				
				
			}
			
		}
		return false;// User not found in the table
		
		
	}

}
