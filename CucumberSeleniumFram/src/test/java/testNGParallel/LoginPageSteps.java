/**
 * 
 */
package testNGParallel;

import appBase.BaseStep;
import fr.qa.pages.LoginPage;
import fr.qa.utils.DriverManager;
import io.cucumber.java.en.*;

/**
 * @author bambadia
 *
 */
public class LoginPageSteps extends BaseStep {

	private LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());


	@Given("^I am on the login page URL \"([^\"]*)\"$")
    public void iAmOnTheLoginPageURLSomething(String url) throws Throwable {
		
		DriverManager.getInstance().getDriver().get(url);
        
    }
	
	
	

    @When("^I fill in username with \"([^\"]*)\"$")
    public void iFillInUsernameWithSomething(String username) throws Throwable {
    	
    	loginPage.enterUsername(username);
        
    }

    @Then("^I should  see login page$")
    public void iShouldSeeLoginPage() throws Throwable {
    	
        
    }

    @Then("^I should see the selfcare page$")
    public void iShouldSeeTheSelfcarePage() throws Throwable {
    	org.junit.Assert.assertTrue(false);
        
    }

    @Then("^the error message shoul be \"([^\"]*)\"$")
    public void theErrorMessageShoulBeSomething(String strArg1) throws Throwable {

    }

    @And("^I fill in password with \"([^\"]*)\"$")
    public void iFillInPasswordWithSomething(String passwd) throws Throwable {
    	loginPage.enterPasswd(passwd);
        
    }

    @And("^I clicked on Signin button$")
    public void iClickedOnSigninButton() throws Throwable {
    	loginPage.clickOnLoginButton();
        
    }

    @And("^The title of the page should be \"([^\"]*)\"$")
    public void theTitleOfThePageShouldBeSomething(String strArg1) throws Throwable {
        
    }

}
