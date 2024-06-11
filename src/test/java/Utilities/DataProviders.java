package Utilities;

import org.testng.annotations.DataProvider;

/**
 * Data provider method to supply user data for test cases.
 */
public class DataProviders {

	@DataProvider(name = "userData")
	public Object[][] getUserData() {
		return new Object[][] { { "Fname1", "Lname1", "Pass1", "Company BBB", "Admin", "admin@mail.com", "082555" },
				{ "Fname2", "Lname2", "Pass2", "Company AAA", "Customer", "Customer@mail.com", "083444" }

		};
	}
}
