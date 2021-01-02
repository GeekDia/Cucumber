/**
 * 
 */
package testNGParallel;


import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author bambadia
 *
 */

@CucumberOptions(features = { "src/test/resources/testNGParallel" }, glue = { "testNGParallel" }, plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/" }, dryRun = false, monochrome = true)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}
