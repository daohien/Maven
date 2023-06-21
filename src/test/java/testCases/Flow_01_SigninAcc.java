package testCases;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basedObject.Obj_Sign;
import common.general;


public class Flow_01_SigninAcc extends general{
	
	Obj_Sign lgoObj;

	@BeforeMethod
	public void initData() {
		lgoObj = new Obj_Sign(driver);
	}
	
	
	@Test
	public void TC01_userNameBlank() {
		test = extent.createTest("TC01_userNameBlank"); 
		
		lgoObj.clickBtnMenuSignin(test);
		
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
		
		lgoObj.clickBtnSignin(test);
		
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
	public void TC02_passWordIsBlank() {
		test = extent.createTest("TC02_passWordIsBlank"); 
		
		lgoObj.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		lgoObj.inputPassWord(test,"HienDT");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		
		lgoObj.matchingResult(test,  alert.getText(), "Please fill out Username and Password.");
		
		alert.accept();	
		
	}
	
	@Test
	public void TC03_successAccRegister() {
		test = extent.createTest("TC03_successAccRegister()"); 
		
		lgoObj.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random rand = new Random(); 
		
		String userName = "Hien" + rand.nextInt(1000);
		String passWord = "Aa" + rand.nextInt(1000);
		
		lgoObj.inputUsername(test,userName);
		lgoObj.inputPassWord(test,passWord);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		
		lgoObj.matchingResult(test,  alert.getText(), "Sign up successful.");
		
		alert.accept();	
		
	}
	

	public void TC04_accAlreadyExists() {
		
		test = extent.createTest("TC04_accAlreadyExists()"); 
		
		lgoObj.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.inputUsername(test,"HienDT");
		lgoObj.inputPassWord(test,"Aa123456");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		
		lgoObj.matchingResult(test,  alert.getText(), "This user already exist.");
		
		alert.accept();	

	}

	
	@Test
	public void TC05_clickIconClose() {
		test = extent.createTest("TC05_clickIconClose()"); 
		
		lgoObj.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		lgoObj.clickIconClose(test);
		
	}
	
	@Test
	public void TC06_clickBtnClose() {
		test = extent.createTest("TC06_clickBtnClose()"); 
		
		lgoObj.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnClose(test);

	}
	
}

