package Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.appium.java_client.AppiumDriver;
import pageFactory.CalculatorPage;

public class CalculatorFunctions extends CalculatorPage{	

	AppiumDriver driver;

	Random random = new Random();
	int x = 0;
	int y = 0;
	int z = 0;
	String expectedResult = "";
	String actualResult = "";
	String getResult = "";
	String operation = "";
	String sheetName = "";
	String sheetNames = "";

	public CalculatorFunctions(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	}

	public void enternumber(int number) {
		for (int i = 0 ; i<String.valueOf(number).length(); i++ ) {				
			int[] num = Integer.toString(number).chars().map(c -> c-'0').toArray();
			switch (num[i]) {
			case 0:
				num_0.click();
				break;
			case 1:
				num_1.click();
				break;
			case 2:
				num_2.click();
				break;
			case 3:
				num_3.click();
				break;
			case 4:
				num_4.click();
				break;
			case 5:
				num_5.click();
				break;
			case 6:
				num_6.click();
				break;
			case 7:
				num_7.click();
				break;
			case 8:
				num_8.click();
				break;
			case 9:
				num_9.click();
				break;
			default:
				break;
			}
		}
	}

	public int generateNumber() {
		int num = random.nextInt(1000);
		return num;
	}

	public void typeFirstNumber() {	
		x = generateNumber();
		enternumber(x);
		System.out.println("\nx: " + x);
	}

	public void typeSecondNumber() {
		y = generateNumber();
		enternumber(y);
		System.out.println("\ny: " + y);
	}
	
	public void pressPlusBtn() {
		num_add.click();
		operation="plus";
		System.out.println("\noperation: " + operation);
	}

	public void pressMinusBtn() {
		num_sub.click();
		operation="minus";
		System.out.println("\noperation: " + operation);
	}

	public void pressMultipleBtn() {
		num_mul.click();
		operation="mul";
		System.out.println("\noperation: " + operation);
	}

	public void pressDivideBtn() {
		num_div.click();
		operation="div";
		System.out.println("\noperation: " + operation);
	}

	public void pressEqualBtn() {
		num_equal.click();
	}

	public void getExpectedReslutText() {
		String[] arr= {};
		if(operation.contains("plus")) {
			z = x + y;
			expectedResult = String.valueOf(z);
		}
		else if(operation.contains("minus")) {
			z = x - y;
			expectedResult = String.valueOf(z);
		}
		else if(operation.contains("mul")) {
			z = x * y;
			expectedResult = String.valueOf(z);
		}
		else if(operation.contains("div")) {
			float z=0;
			if(y!=0) {
				z = Float.parseFloat(String.valueOf(x)) / Float.parseFloat(String.valueOf(y));				
				expectedResult = String.valueOf(z).replace(".", "-");				
				arr = expectedResult.split("-");				
				expectedResult = arr[0] + "." + arr[1].substring(0,1);
			}else if(y==0){
				expectedResult = "Can not be divided by 0";
			}
		}
		System.out.println("\nExpected Reslut: " + expectedResult);		
	}

	public void getActuallyReslutText() {
		actualResult = num_result.getText();

		String[] arr= {};

		if(actualResult.contains(",")) {
			actualResult = actualResult.replace(",", "");
		}

		if(operation.contains("div")){
			if(y!=0) {
				if(actualResult.contains(".")) {
					actualResult = actualResult.replace(".", "-");	
					arr = actualResult.split("-");
					actualResult = arr[0] + "." +arr[1].substring(0,1);
				}
				else {
					actualResult = actualResult + ".0";
				}
			}
			else if (y==0){
				actualResult = "Can not be divided by 0";
			}
		}

		if(operation.contains("minus")){
			if(z<0){
				actualResult = "-" + actualResult.substring(1,actualResult.length());
			}
		}

		System.out.println("\nActually Reslut = " + actualResult);
	}

	public void assertResult() {
		assert (expectedResult.contains(actualResult));
		System.out.println("\n Is equal");
	}
	
	public void writeDataToExcel() {
		try {
			String excelPath = "src/test/resources/data/writeData.xlsx";
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			sheetName = operation;
			System.out.println("sheetName: " + sheetName);
			
			XSSFSheet sheet = wb.getSheet(sheetName);

			FileOutputStream fos = new FileOutputStream(file);

			XSSFCell opr = sheet.getRow(1).createCell(0);
			opr.setCellValue(operation);

			XSSFCell fn = sheet.getRow(1).createCell(1);
			fn.setCellValue(x);

			XSSFCell sn = sheet.getRow(1).createCell(2);
			sn.setCellValue(y);

			XSSFCell exr = sheet.getRow(1).createCell(3);
			exr.setCellValue(expectedResult);

			XSSFCell ar = sheet.getRow(1).createCell(4);
			ar.setCellValue(actualResult);

			wb.write(fos);

			System.out.println("Completed write: " + sheetName);
			wb.close();
		}
		catch(IOException ioex) {
			System.out.println(ioex.getCause());
			System.out.println(ioex.getMessage());
			ioex.printStackTrace();
		}
	}
	
	public void readDataFromExcel() {
		try {
			String excelPath = "src/test/resources/data/readData.xlsx";
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			sheetNames = "operations";
			
			XSSFSheet sheet = wb.getSheet(sheetNames);

			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(0);

			String opr = cell.getStringCellValue();

			System.out.println("Completed data read: " + opr);

			System.out.println("Completed data read: " + sheetNames);
			wb.close();
		}
		catch(IOException ioex) {
			System.out.println(ioex.getCause());
			System.out.println(ioex.getMessage());
			ioex.printStackTrace();
		}
	}

}
