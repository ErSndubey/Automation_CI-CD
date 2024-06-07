package Infobays;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/feature", tags = "@tag", glue = "Infobays.stepDefinitions", monochrome = true, plugin = {"pretty", "html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
//it will run the test.
}

