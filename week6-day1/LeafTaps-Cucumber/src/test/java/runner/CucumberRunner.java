package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
glue ="stepdefinition", 
monochrome =true,
publish = true)
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
