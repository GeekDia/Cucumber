/**
 * 
 */
package fr.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fr.qa.utils.ElementUtils;

/**
 * @author bambadia
 *
 */
public class AccountPage extends ElementUtils {

	WebDriver driver;

	AccountPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// By locators

	@FindBy(css = "div#center_column span")
	private List<WebElement> accountSections;

	public List<String> getAccountsSectionsList() {

		List<String> accountsList = new ArrayList<>();

		for (WebElement e : accountSections) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}

		return accountsList;

	}

	public int getAccountsSectionCount() {
		return accountSections.size();
	}

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
}
