package basedObject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import common.commonFunc;
import common.general;


public class Obj_Sign  extends general {
	
	// Xpath
	String xpathIconClose = "//h5[@id='signInModalLabel']/following-sibling::button";
	String xpathUserName = "//input[@id='sign-username']";
	String xpathPassWord = "//input[@id='sign-password']";

	String xpathBtnClose = "//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]";
	String xpathBtnSignin = "//button[contains(text(),'Sign up')]";
	String xpathMenuSignin = "//a[@id='signin2']";
	WebDriver local_driver; 
	
	// Constructor
	public Obj_Sign(WebDriver driver) {
		local_driver = driver;//gan gia tri cho local driver
	}
	public static commonFunc func = new commonFunc();
	// Action
	
	public void clickIconClose(ExtentTest test) {
		func.elementClick(local_driver, test,  xpathIconClose);
	}
	
	public void inputUsername(ExtentTest test, String inputData) {
		func.elementSendkey(local_driver, test, xpathUserName, inputData);
	}
	
	public void inputPassWord(ExtentTest test, String inputData) {
		func.elementSendkey(local_driver, test, xpathPassWord, inputData);
	}
	
	public void clickBtnClose(ExtentTest test) {
		func.elementClick(local_driver, test, xpathBtnClose);
	}
	
	public void clickBtnSignin(ExtentTest test) {
		func.elementClick(local_driver, test, xpathBtnSignin);
	}
	
	public void clickBtnMenuSignin(ExtentTest test) {
		func.elementClick(local_driver, test, xpathMenuSignin);
	}
	
	public void matchingResult(ExtentTest test, String actualResult, String expectResult) {;
		func.assertAlert(local_driver, test, actualResult, expectResult);
	}
	

}
