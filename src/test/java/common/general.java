package common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class general {
	
	public WebDriver driver = null;
	public static ExtentTest test;
	public static ExtentReports extent; 
	
	@BeforeTest
	@Parameters({"browser"})
	public WebDriver initDriver(String browser) {
		extent = new ExtentReports(); // khai bao xu dung extent report
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/Automation_"+browser+".html"); // tro report den folder
		extent.attachReporter(spark); // attached spart report vao trinh quan ly report cua extent report
		
		if (browser.equalsIgnoreCase("chrome")){
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
			
		}
		
		String url = "https://www.demoblaze.com";
		driver.get(url);	
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	
	@AfterMethod
	public void openUrlSaveImage() {
		String url = "https://www.demoblaze.com";
		driver.get(url);	
		driver.manage().window().maximize();
		
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());	

		extent.flush();
		
	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
	
	public String screenShot(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDateTime myDateObj = LocalDateTime.now();
		// System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

		String formattedDate = myDateObj.format(myFormatObj);
		// System.out.println("After formatting: " + formattedDate);
		
		// capture screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String newName = "./report/screenshot" + formattedDate + ".png";

		// copy to report folder
		try {
			FileUtils.copyFile(screenshotFile, new File("./report" + newName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return newName;
	}
	
	
}
