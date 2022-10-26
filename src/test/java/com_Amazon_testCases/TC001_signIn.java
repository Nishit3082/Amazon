package com_Amazon_testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com_Amazon_pageObject.HomePage;
import com_Amazon_testBase.BaseTest;

public class TC001_signIn extends BaseTest {

	@Test
	public void signIn() throws IOException {
		
	logger.info("Application is openend");	
		HomePage hp=new HomePage(driver);
		//hp.signInLink();
	
	getScreenshot(driver, "Home Page");
	hp.clickonStarthere();
	logger.info("Entering credentials");
	hp.yourNametxt(prop.getProperty("name"));
	hp.emailOrMobiletxt(prop.getProperty("mobile"));
	hp.passwordField(prop.getProperty("password"));
	hp.passwordAgainField(prop.getProperty("passwordagain"));
	getScreenshot(driver, "Login Page with Credetntials");
	hp.clickOnContinuebtn();
	
	
	}
}
