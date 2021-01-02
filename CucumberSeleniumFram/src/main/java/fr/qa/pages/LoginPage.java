/**
 * 
 */
package fr.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fr.qa.utils.ElementUtils;

/**
 * @author bambadia
 *
 */
public class LoginPage extends ElementUtils {

	WebDriver driver;

	// Locators

	@FindBy(id = "email")
	@CacheLookup
	private WebElement email;

	@FindBy(id = "passwd")
	@CacheLookup
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	@CacheLookup
	private WebElement forgotPasswdLink;

	// Constructor

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean isForgotPasswordLinkExist() {

		return forgotPasswdLink.isDisplayed();

	}

	public void enterUsername(String username) {

		//email.sendKeys(username);
		doSendKeys(email, username);
	}

	public void enterPasswd(String passwd) {

		//password.sendKeys(passwd);
		doSendKeys(password, passwd);

	}

	public void clickOnLoginButton() {

		//loginButton.click();
		doClick(loginButton);
	}
	
	public AccountPage doLogin(String username, String password) {
		
		enterUsername(username);
		enterPasswd(password);
		clickOnLoginButton();
		
		return new AccountPage(driver);
	}
}
