package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
  (
		features=".//Features/Customer.feature",
		glue="StepDefinition",
		dryRun=true,
				monochrome=true,
		plugin= {"pretty",
				"html:test-output"}
		
		)

public class TestRun {
	/*This Empty*/
	
	
}
