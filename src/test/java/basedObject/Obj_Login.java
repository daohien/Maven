package basedObject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import common.commonFunc;

public class Obj_Login {
	// Xpath
		String xpathBtnLogin = "//button[contains(@onclick,'logIn()')]";
		String xpathUserName = "//input[@id='loginusername']";
		String xpathPassWord = "//input[@id='loginpassword']";
		String xpathMenuLogin = "//a[@id='login2']";
		String xpathBtnClose = "//body/div[@id='logInModal']/div[1]/div[1]/div[3]/button[1]";
		WebDriver local_driver; 
		
		// Constructor
		public Obj_Login(WebDriver driver) {
			local_driver = driver;//gan gia tri cho local driver
		}
		public static commonFunc func = new commonFunc();
		// Action
		
		public void inputUsername(ExtentTest test, String inputData) {
			func.elementSendkey(local_driver, test, xpathUserName, inputData);
		}
		
		public void inputPassWord(ExtentTest test, String inputData) {
			func.elementSendkey(local_driver, test, xpathPassWord, inputData);
		}
		
		public void clickBtnLogin(ExtentTest test) {
			func.elementClick(local_driver, test, xpathBtnLogin);
		}
		
		public void clickBtnMenuLogin(ExtentTest test) {
			func.elementClick(local_driver, test, xpathMenuLogin);
		}
		
		
		public void matchingResult(ExtentTest test, String actualResult, String expectResult) {;
			func.assertAlert(local_driver, test, actualResult, expectResult);
		}
		
		public void btnClose(ExtentTest test) {;
		func.elementClick(local_driver, test, xpathBtnClose);
	}
		

}
