package com_Amazon_pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com_Amazon_utilities.Utiles;

public class HomePage extends Utiles {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Hello, sign in']")
	WebElement signIn;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement links;
	
	
	
/*	public void links() {
		actions(links);
	}*/
	
	public void signInLink() {
		//clickingonElement(signIn);
		
		System.out.println(signIn.getText());
	}	
	
	String expValue="Discover Your Style";
	boolean status=true;
	public void links() {
		Actions actions=new Actions(driver);
		actions.moveToElement(links).build().perform();
		
		List<WebElement> links=driver.findElements(By.xpath("//span[@class='nav-text']"));
		int noOfLinks=links.size();
		System.out.println("No of available links in signIn page is: " + noOfLinks);
		
		for (int i = 0; i < noOfLinks; i++) {
			String nameOfLinks=links.get(i).getText();
			System.out.println("Name of Link is : " + nameOfLinks);
			
			if (nameOfLinks.equalsIgnoreCase(expValue)) {
				status=true;
				break;
			} else {
				status=false;
			}
		}
		Assert.assertEquals("Discover Your Style", expValue, "link is not present");
		System.out.println("Links is present: " + expValue);
	}
		
	
	@FindBy(xpath="(//a[text()='Start here.'])[2]")
	WebElement click;
	
	@FindBy(id="ap_customer_name")
	WebElement yourName;
	
	@FindBy(id="ap_email")
	WebElement emailOrMoibiletxt;
	
	@FindBy(id="ap_password")
	WebElement passwordtxt;
	
	@FindBy(id="ap_password_check")
	WebElement passwordAgain;
	
	@FindBy(id="continue")
	WebElement continuebtn;
	
	public void clickonStarthere() {
		clickingonElement(click);
	}
	public void yourNametxt(String value) {
		doSendKeys(yourName, value);
		yourName.getAttribute(value);
		//sys("Text entered in Yourname field is: " + value);
		
	}
	public void emailOrMobiletxt(String value) {
		doSendKeys(emailOrMoibiletxt, value);
		emailOrMoibiletxt.getAttribute(value);
		System.out.println("Text entered in Email Or Mobile Field is : " + value);
	}
	public void passwordField(String value) {
		doSendKeys(passwordtxt, value);
		passwordtxt.getAttribute(value);
		System.out.println("Text entered in password field is : " +value);
	}
	public void passwordAgainField(String value) {
		doSendKeys(passwordAgain, value);
	}
	public void clickOnContinuebtn() {
		clickingonElement(continuebtn);
	}
	
	
}
