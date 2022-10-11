package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Calculator.feature", glue= {"StepDefinitions"},
monochrome=true,
plugin = {"pretty","html:target/HtmlReports/htmlReport.html",
		"pretty","json:target/JSONReports/jsonReport.json",		
		"pretty","junit:target/JUnitReports/xmlReport.xml"},
tags="@plus or @minus or @multiple or @divided"
		)
public class TestRunner {

}