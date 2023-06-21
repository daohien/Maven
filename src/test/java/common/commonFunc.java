package common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class commonFunc {
	
	public String screenshot_ele(WebElement ele) {
		File screenshotFile = ele.getScreenshotAs(OutputType.FILE); //chup 1 ele
		String new_name = "ele_" + getTimeStem() + ".png"; //"screenshot_20052023_201658.png

		//copy to report folder
		try {
			FileUtils.copyFile(screenshotFile , new File("./report/"+new_name));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new_name;
	}
	
	public String screenShot(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// capture screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String newName = "./report/screenshot" + getTimeStem() + ".png";

		// copy to report folder
		try {
			FileUtils.copyFile(screenshotFile, new File("./report" + newName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return newName;
	}

	public String getTimeStem() {
		LocalDateTime myDateObj = LocalDateTime.now();
		// System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

		String formattedDate = myDateObj.format(myFormatObj);
		// System.out.println("After formatting: " + formattedDate);
		return formattedDate;
	}
	
	public boolean verifyContais(String expect, String actual) {
		boolean flag = true;
		if (actual.contains(expect) == false) {
			flag = false;
		}
		return flag;
	}
	
	
	
	
	public void elementClick(WebDriver driver, ExtentTest test, String xpath) {
		WebElement btnEle = driver.findElement(By.xpath(xpath));
		test.info("Click button - xpath " + xpath);
		//test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshot_ele(btnEle)).build()); //add ele screenshot
		System.out.println("Click button - xpath " + xpath);
		btnEle.click();
	}
	

	public void elementSendkey(WebDriver driver, ExtentTest test, String xpath,String data) {
		WebElement inputEle = driver.findElement(By.xpath(xpath));
		test.info("Send data '" + data +"' into - xpath " + xpath);
		//test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshot_ele(inputEle)).build()); //add ele screenshot
		System.out.println("Send data '" + data +"' into - xpath " + xpath);
		inputEle.sendKeys(data);
	}
	
	public void assertAlert(WebDriver driver, ExtentTest test, String actualResult, String expectResult) {
		Assert.assertEquals(actualResult, expectResult);
		test.info("Alert:" + actualResult);
		System.out.println(actualResult);
		
			
	}

	

}
