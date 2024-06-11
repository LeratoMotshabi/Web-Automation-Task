package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.webTable;
import Utilities.DataProviders;
import baseClass.BaseClass;

public class UserListTableTestCase extends BaseClass {

	// Page Object for interacting with the user list table
	webTable userList;

	// Test to verify that the user is on the User List Table page
	@Test(priority = 0)
	public void verify_you_are_on_User_List_Table() {

		SoftAssert soft = new SoftAssert();

		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Protractor practice website - WebTables";

		//verify that the user is on the User List Table page using tile page
		soft.assertEquals(ActualTitle, ExpectedTitle);

		soft.assertAll();
	}

	// Test to verify that a user is added successfully
	@Test(priority = 1, dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void verify_user_Added_succefully(String Fname, String Lname, String Password, String Customer, String Role,
			String Email, String Cell) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		userList = new webTable(driver);// Initialize the page object here
		
		// Generate a unique username using random numeric string
		String UniqueUserName = "user" + RandomStringUtils.randomNumeric(2);
		
		// Add user details using the webTable methods
		userList.clickAddUserButton();
		userList.enterFirstName(Fname);
		System.out.println("Entered: " + Fname);
		userList.enterLastName(Lname);
		System.out.println("Entered: " + Lname);
		userList.enterUserName(UniqueUserName);
		System.out.println("Entered: " + UniqueUserName);
		userList.enterPassword(Password);
		System.out.println("Entered: " + Password);
		userList.selectCustomerRadioButton(Customer);
		System.out.println("Selected: " + Customer);
		userList.selectRole(Role);
		System.out.println("Selected: " + Role);
		userList.enterEmail(Email);
		System.out.println("Entered: " + Email);
		userList.enterCellPhone(Cell);
		System.out.println("Entered: " + Cell);

		userList.clickSaveButton();
		
		// Verify if the user is added to the table
		soft.assertTrue(userList.isUserPresent(UniqueUserName));

		soft.assertAll();
	}

}
