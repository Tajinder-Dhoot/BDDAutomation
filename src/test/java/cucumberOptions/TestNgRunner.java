package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features="src/test/java/features",
		
		glue = "stepDefinitions",

		//dryRun = true,
				
		monochrome = true
		
		)

public class TestNgRunner extends AbstractTestNGCucumberTests{

}
