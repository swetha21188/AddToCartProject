package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	 public PaymentPage(WebDriver driver) {
	        super(driver);
	    }
	 
	 @FindBy (className ="progress-banner-heading")  WebElement billingTitle;
	 
	 public String paymentPageTitle() throws InterruptedException {
	    	System.out.println("Payment Page Title: "+billingTitle.getText());
	    	return billingTitle.getText();
	 
	    }
}