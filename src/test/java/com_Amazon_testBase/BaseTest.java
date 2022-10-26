package com_Amazon_testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@BeforeClass
	@Parameters("browsername")
	public void setUp(String browsername) throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\IT\\JAVA\\Script\\My_Amazon_Project\\resources\\config.properties");
		prop.load(fis);
		
			if (browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			} else if(browsername.equalsIgnoreCase("Firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			} else if(browsername.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}	
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Application is opened");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Application is closed successfully");
	}
	public void getScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is Captured : " + testName);
	}
	
	
	
}
