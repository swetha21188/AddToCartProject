package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

	 public AddressPage(WebDriver driver) {
	        super(driver);
	    }
	 
    @FindBy (id ="id_first_name")  WebElement firstName;
    @FindBy (id ="id_last_name")  WebElement lastName;
    @FindBy (id ="id_company")  WebElement company;
    @FindBy (id ="id_address")  WebElement address1;
    @FindBy (id ="id_address2")  WebElement address2;
    @FindBy (id ="id_city")  WebElement city;
    @FindBy (id ="id_state")  WebElement state;
    @FindBy (id ="id_postal_code")  WebElement postalCode;
    @FindBy (id ="id_country")  WebElement country;
    @FindBy (id ="id_shipping_method")  WebElement shippingMethod;
    @FindBy (id ="id_email")  WebElement email;
    @FindBy (id ="id_int_phone")  WebElement phoneNum;
    @FindBy (className ="button-continue")  WebElement continueButton;
    @FindBy (className ="progress-banner-heading")  WebElement addressPageTitle;
    //*[@id='progress-label']
    @FindBy (xpath = "//div[@class='address']/input[@class='button-continue']") WebElement shiptoVerifiedAddress;
    
    public void firstNameValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	firstName.sendKeys(new_value);
    }
    
    public void lastNameValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	lastName.sendKeys(new_value);
    }
    
    public void companyValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	company.sendKeys(new_value);
    }
    
    public void address1Value(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	address1.sendKeys(new_value);
    }
    
    public void address2Value(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	address2.sendKeys(new_value);
    }
    
    public void cityValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	city.sendKeys(new_value);
    }
    
    public void stateValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	state.sendKeys(new_value);
    }
    
    public void postalCodeValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	postalCode.sendKeys(new_value);
    }
    
    public void countryValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	country.sendKeys(new_value);
    }
    
    public void shippingMethodValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	shippingMethod.sendKeys(new_value);
    }
    
    public void emailValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	email.sendKeys(new_value);
    }
    
    public void phoneValue(String new_value) throws InterruptedException {
    	Thread.sleep(2000);
    	phoneNum.sendKeys(new_value);
    }
    
    public void continueButton() throws InterruptedException {
    	Thread.sleep(2000);
    	continueButton.click();   
    }
    
    public void shiptoVerifiedAddressContinue() throws InterruptedException {
    	Thread.sleep(2000);
    	shiptoVerifiedAddress.click();
    }
    
    public String addressPageTitle() throws InterruptedException {
    	System.out.println("Shipping Page Title: "+addressPageTitle.getText());
    	return addressPageTitle.getText();
 
    }
}