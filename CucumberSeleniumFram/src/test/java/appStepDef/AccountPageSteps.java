/**
 * 
 */
package appStepDef;

import java.util.List;
import java.util.Map;
import org.junit.Assert;

import fr.qa.pages.AccountPage;
import fr.qa.pages.LoginPage;
import fr.qa.utils.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author bambadia
 *
 */
public class AccountPageSteps {

	private LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
	private AccountPage accountPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {

		DriverManager.getInstance().getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String passwd = credList.get(0).get("password");

		accountPage = loginPage.doLogin(username, passwd);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		// Write code here that turns the phrase above into concrete actions

		accountPage.getAccountsPageTitle();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		accountPage.getAccountsPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
		List<String> expAccountSectionsList = dataTable.asList();

		System.out.println("Expected accounts section list: " + expAccountSectionsList);

		List<String> actualAccountSectionsList = accountPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);

		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {

		Assert.assertTrue(accountPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
