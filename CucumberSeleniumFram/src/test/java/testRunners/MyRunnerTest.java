/**
 * 
 */
package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

/**
 * @author bambadia
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "summary", "json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/"}, snippets = CAMELCASE, dryRun = false, monochrome = true, features = {
				"src/test/resources/appFeatures" },
		// tags = "@regression",
		glue = { "appStepDef", "appHooks" })
public class MyRunnerTest {

}
