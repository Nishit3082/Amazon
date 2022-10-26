package com_Amazon_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utiles {

	public WebDriver driver;
	
	//For clicking an Element
	public void clickingonElement(WebElement element) {
		element.click();
	}
	//For mouse actions
	public void actions(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
	}
	
	//For Send Keys
	public void doSendKeys(WebElement element, String value) {
		element.sendKeys(value);
		
	}
	
	
	
}