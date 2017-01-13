package com.automation.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.BasePage;

public class CartPage extends BasePage {
	
	 public CartPage(WebDriver driver) {
	        super(driver);
	    }

    @FindBy (className ="item-price")  WebElement itemPrice;
    @FindBy (className ="cart-item-row")  WebElement cartItem;
    @FindBy (className ="js-kit-name")  WebElement kitName;
    @FindBy (xpath = "//div[@class='quantity-control']/span[@title='Add another kit']") WebElement add_kit;
    @FindBy (className ="cart-empty")  WebElement cartEmpty;
    @FindBy (className ="button-continue")  WebElement continueButton;
    @FindBy (xpath = "//div[@class='quantity-control']/span[@title='Add another kit']") WebElement kitNameField;
    @FindBy (css = ".submit.button-continue.button-disabled") WebElement continueButtonDisabled;
 
    public void continueButton() {
    	continueButton.click();   
    }
    
    public void addingKit(int count) throws InterruptedException {
    	System.out.println("Adding Kits");
    	for (int i = 0; i < count; i ++){
    		Thread.sleep(3000);
    		add_kit.click();   
    	} 	
    }
    
    public String verifyEmptyCart() {
    	System.out.println("Empty cart: "+cartEmpty.getText());
    	return cartEmpty.getText();
    }
    
    public float expectedCartTotal(int count) {
    	//this method is the expected total calculated
    	float total;
    	if(count==1){
    		total=(float) 199.00;
    	}
    	else
    	{ 
    		total = (float) (199.00 + 179.10*(count-1));
    	}
    	return total;
    }
    
    public String actualCartTotal() {
    	
    	String totalCurrency= driver.findElement(By.xpath("//*[@id='text_items_total_with_discount']")).getText();
    	//here we are removing the leading $ from the total
    	return totalCurrency.substring(1);
    }
    
    public enum Names{
  	  
    	NAME_ONE("Mark"),
    	NAME_TWO("Peter"),
    	NAME_THREE("Paul"),
    	NAME_FOUR("Mary"),
    	NAME_FIVE("John"),
    	NAME_SIX("Ashwin"),
    	NAME_SEVEN("Swetha");
	 
    	private final String nameText;
	 	
    	private Names(String name){
    		this.nameText = name;
	 }

	 @Override
	 public String toString(){
		 return nameText;
	 }
   }
  
    public void kitNameValue() throws InterruptedException {
        List<WebElement> kitrow = driver.findElements(By.className("cart-item-row"));
       
        for (WebElement option: kitrow) {
        	Thread.sleep(2000);
            int rand = new Random().nextInt(Names.values().length);
        	String randomName = Names.values()[rand].toString();
            option.findElement(By.className("js-kit-name")).sendKeys(randomName); // sending a name from the randomName method
        }
    }
       
    public boolean continueButtonEnabled(){
    	return continueButtonDisabled.isEnabled();	
    }
    
    public String actualCountExpected()
    {
    	String countQuantity= driver.findElement(By.xpath("//*[@id='text-health-kit-count']")).getText();
    	System.out.println("Number of kits Count: "+countQuantity); // this is the count after adding the kits
    	return countQuantity;
    }
 
}
