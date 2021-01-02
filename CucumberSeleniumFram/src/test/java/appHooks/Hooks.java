/**
 * 
 */
package appHooks;

import org.openqa.selenium.OutputType;

import fr.qa.utils.DriverManager;
import fr.qa.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

import appBase.BaseStep;

/**
 * @author bambadia
 *
 */
public class Hooks extends BaseStep {

	BaseStep base;

	@Before
	public void initialize() {

		base = new BaseStep();
		base.setUpFramework();
		try {
			base.openBrowser(TestUtils.readProperties("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * @Take screenshot if scenario failed
	 */
	@After(order =1)
	public void takescreenshot(Scenario scenario) {
		
		if(scenario.isFailed()){
            byte[] screenshot = ( (TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            
            scenario.attach(screenshot, "image/png", scenario.getName().replaceAll(" ", "_"));
            
        }
		
	}
	
	
	@After(order = 0)
	public void tearDown() {

		base.quit();

	}

}
