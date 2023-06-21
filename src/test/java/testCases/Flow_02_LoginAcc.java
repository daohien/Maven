package testCases;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basedObject.Obj_Login;
import basedObject.Obj_Sign;
import common.general;

public class Flow_02_LoginAcc extends general {

	Obj_Login lgoObj;
	Obj_Sign lgoObjSign;
	Random rand = new Random(); 

	@BeforeMethod
	public void initData() {
		lgoObj = new Obj_Login(driver);
		lgoObjSign = new Obj_Sign(driver);
	}
	
	public void signInAcc() {
		lgoObjSign.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String userNames = "Hien" + rand.nextInt(1000);
		String passWords = "Aa" + rand.nextInt(1000);
		lgoObjSign.inputUsername(test,userNames);
		lgoObjSign.inputPassWord(test, passWords);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObjSign.clickBtnSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		
		lgoObjSign.matchingResult(test,  alert.getText(), "Sign up successful.");
		
		alert.accept();		
		
	}
	
	@Test
	public void TC01_userNameBlank() {
		test = extent.createTest("TC01_userNameBlank"); 
		
		lgoObj.clickBtnMenuLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		lgoObj.inputPassWord(test, "Aa123456");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		lgoObj.matchingResult(test,  alert.getText(), "Please fill out Username and Password.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		alert.accept();	
	}
	
	@Test
	public void TC02_userNameNoExits() {
		test = extent.createTest("TC02_userNameNoExits()"); 
		
		lgoObj.clickBtnMenuLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		lgoObj.inputUsername(test,"HienDT Test");
		lgoObj.inputPassWord(test, "Aa1234567");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		lgoObj.matchingResult(test,  alert.getText(), "User does not exist.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		alert.accept();	
		
	}
	
	
	@Test
	public void TC03_passWordBlank() {
		test = extent.createTest("TC04_passWordBlank()"); 
		signInAcc();
		lgoObj.clickBtnMenuLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String userName = "HienDT";
		lgoObj.inputUsername(test,userName);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		lgoObj.matchingResult(test,  alert.getText(),  "Please fill out Username and Password.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		alert.accept();	
	
	}
	
	@Test
	public void TC04_passWordIncorrect() {
		test = extent.createTest("TC05_passWordIncorrect()"); 
		signInAcc();
		lgoObj.clickBtnMenuLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		String userName = "HienDT";
		String passWord = "Aa12345689";
		lgoObj.inputUsername(test,userName);
		lgoObj.inputPassWord(test, passWord);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		lgoObj.matchingResult(test,  alert.getText(),  "Wrong password.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		alert.accept();	
		

		
	}
	
	
	@Test
	public void TC05_loginSuccessful() {
		test = extent.createTest("TC03_loginSuccessful()"); 
		
		signInAcc();
		lgoObj.clickBtnMenuLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String userName = "HienDT";
		String passWord = "Aa123456";
		lgoObj.inputUsername(test,userName);
		lgoObj.inputPassWord(test, passWord);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnLogin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();

		alert.accept();	
		
	}
	
	
}
