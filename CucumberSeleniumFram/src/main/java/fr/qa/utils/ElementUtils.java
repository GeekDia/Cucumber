/**
 * 
 */
package fr.qa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author bambadia
 *
 */
public class ElementUtils {
	
	
	public Logger log =  LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	

	/**
	 * @param element This function allowed to click on web element
	 */
	public void doClick(WebElement element) {

		waitForVisibility(element);
		log.info("Cliking on : " +element.getText());
		element.click();

	}

	/**
	 * @param element
	 * @param keys    This function send keys to web element input
	 */
	public void doSendKeys(WebElement element, String keys) {

		waitForVisibility(element);
		log.info("Sending " + keys + " on " +element.getText());
		element.sendKeys(keys);

	}

	/**
	 * @param element
	 * @return element's text
	 */
	public String doGetText(WebElement element) {

		waitForVisibility(element);
		log.info("Getting text on element " + element + " => Text is " +element.getText());

		return element.getText();

	}

	/**
	 * @param element This function wait for the visibility of element before doing
	 *                an action.
	 */
	public void waitForVisibility(WebElement element) {

		WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), TestUtils.getLOAD_TIMEOUT());

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void doClear(WebElement element) {

		waitForVisibility(element);
		log.info("Clearing element : "+element.getText());
		element.clear();
	}

}
