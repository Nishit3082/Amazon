package com_Amazon_testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com_Amazon_pageObject.SignInPage;
import com_Amazon_testBase.BaseTest;

public class TC002_SignHere extends BaseTest {
	
	public WebDriver driver;
	
	@Test
	public void signHere() {
		SignInPage sp= new SignInPage(driver);
		
		sp.clickonStarthere();
	}

}
