package StepDefinitions;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import Functions.CalculatorFunctions;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CalculatorSteps {	
	public static AppiumDriver driver;	
	CalculatorFunctions calculatorFunctions ;

	String environment = "real_cable";

	@Before
	public void setup() {		
		if(environment.equalsIgnoreCase("real_cable")) {
			try {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", "Write your data");  // "Galaxy A1"
				cap.setCapability("udid", "Write your data");  // "A95N54NAZAT"
				cap.setCapability("platformName", "Write your data");  // "Android"
				cap.setCapability("platformVersion", "Write your data");  // "12"
				cap.setCapability("autoGrantPermissions", "true");
				cap.setCapability("noReset", "true");
				cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
				cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
				URL url = new URL ("http://127.0.0.1:4723/wd/hub");	
				driver = new AppiumDriver(url, cap);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

				System.out.println("Application started...");	
			}catch(Exception ex) {
				System.out.println(ex.getCause());
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		else if(environment.equalsIgnoreCase("real_wifi")) {
			try {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", "Write your data");  // "Galaxy A1"
				cap.setCapability("udid", "Write your data");  // "1.1.1.1:5555"
				cap.setCapability("udid", "Write your data");  // "A95N54NAZAT"
				cap.setCapability("platformName", "Write your data");  // "Android"
				cap.setCapability("platformVersion", "Write your data");  // "12"
				cap.setCapability("autoGrantPermissions", "true");
				cap.setCapability("noReset", "true");
				cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
				cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
				URL url = new URL ("http://127.0.0.1:4723/wd/hub");	
				driver = new AppiumDriver(url, cap);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

				System.out.println("Application started...");	
			}catch(Exception ex) {
				System.out.println(ex.getCause());
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		calculatorFunctions = new CalculatorFunctions(driver);
		
		calculatorFunctions.readDataFromExcel();
	}

	@After
	public void tearDown() {
		System.out.println("I am inside tearDown");
		calculatorFunctions.writeDataToExcel();
		driver.quit();
	}

	@Given("Type first number")
	public void type_first_number() {
		calculatorFunctions.typeFirstNumber();
	}

	@And("Type second number")
	public void type_second_number() {	
		calculatorFunctions.typeSecondNumber();
	}
	
	@And("Press plus button")
	public void press_plus_button() {
		calculatorFunctions.pressPlusBtn();
	}

	@When("Press minus button")
	public void press_minus_button() {
		calculatorFunctions.pressMinusBtn();
	}

	@When("Press multiple button")
	public void press_multiple_button() {
		calculatorFunctions.pressMultipleBtn();
	}

	@When("Press divided button")
	public void press_divided_button() {
		calculatorFunctions.pressDivideBtn();
	}

	@And("Press equal button")
	public void press_equal_button() {
		calculatorFunctions.pressEqualBtn();
	}

	@Then("Get expected result")
	public void get_expected_result() {
		calculatorFunctions.getExpectedReslutText();
	}

	@Then("Get actually result")
	public void get_actually_result() {
		calculatorFunctions.getActuallyReslutText();
	}

	@Then("Assert result")
	public void assert_result() {			
		calculatorFunctions.assertResult();
	}
}
