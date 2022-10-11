package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage {

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")
	@CacheLookup
	protected
	WebElement num_0;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")
	@CacheLookup
	protected
	WebElement num_1;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")
	@CacheLookup
	protected
	WebElement num_2;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")
	@CacheLookup
	protected
	WebElement num_3;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_04")
	@CacheLookup
	protected
	WebElement num_4;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")
	@CacheLookup
	protected
	WebElement num_5;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")
	@CacheLookup
	protected
	WebElement num_6;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")
	@CacheLookup
	protected
	WebElement num_7;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_08")
	@CacheLookup
	protected
	WebElement num_8;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")
	@CacheLookup
	protected
	WebElement num_9;


	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")
	@CacheLookup
	protected
	WebElement num_add;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub")
	@CacheLookup
	protected
	WebElement num_sub;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")
	@CacheLookup
	protected
	WebElement num_mul;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_div")
	@CacheLookup
	protected
	WebElement num_div;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")
	@CacheLookup
	protected
	WebElement num_equal;

	@FindBy(id= "com.sec.android.app.popupcalculator:id/calc_edt_formula")
	@CacheLookup
	protected
	WebElement num_result;

}
