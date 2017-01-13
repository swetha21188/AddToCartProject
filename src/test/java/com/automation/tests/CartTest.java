package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.automation.pages.AddressPage;
import com.automation.pages.CartPage;
import com.automation.pages.PaymentPage;

public class CartTest extends BaseTest {
	
	AddressPage addressPage;
	CartPage cartPage;
	PaymentPage paymentPage;
			
	private String firstName = "SWETHA";
	private String lastName = "PATOOR";
	private String address1 = "100 N WHISMAN RD";
	private String address2 = "APT 4315";
	private String city = "MOUNTAIN VIEW";
	private String state = "CA";
	private String zip = "94043-4947";
	private String email = "swetha@email.com";
	private String phone = "1111111111";
	private int count=5; // number of kits to be added

@Test
public void AddingKitstoCart() throws InterruptedException{
	
	cartPage = new CartPage(driver); // create cart page object
	SoftAssert s_assert = new SoftAssert(); //using soft assert to continue assertions even if they fail
	// On Cart Page
	s_assert.assertEquals(driver.getTitle(), "Store - 23andMe - DNA Genetic Testing & Analysis", "The title does not match"); // Asserting the Title of the webpage
	s_assert.assertEquals(cartPage.verifyEmptyCart(), "Add a service below.","The cart is not empty before adding kits"); // Verifying if cart is empty
	Thread.sleep(5000);
	cartPage.addingKit(count); // adding 5 kits 
	Thread.sleep(3000);
	Float newCartTotal = Float.valueOf(cartPage.actualCartTotal()); // converting string to float
	System.out.println("Expected Cart Total: "+cartPage.expectedCartTotal(5)); // this is expected total
	System.out.println("Actual Cart Total: "+newCartTotal); // this is what is being displayed
	
	s_assert.assertEquals(cartPage.expectedCartTotal(5), newCartTotal,"The total for n kits does not match"); //Verifying the total of n number of kits
	s_assert.assertTrue(cartPage.continueButtonEnabled(), "Continue button should not be enabled when no names are given"); //Continue button should be disabled
	
	Thread.sleep(4000);
	int newCountTotal = Integer.parseInt(cartPage.actualCountExpected()); // converting string to integer
	s_assert.assertEquals(count,newCountTotal,"The number of kits added is not the same"); // Verifying if the number of kits count is the same
	
	cartPage.kitNameValue(); // passing random values from a list as kit names
	
	Thread.sleep(3000);
	cartPage.continueButton(); // continues to the address page
	
	// On Address Page
	
	addressPage = new AddressPage(driver);
	s_assert.assertEquals(addressPage.addressPageTitle(), "SHIPPING","The header of the shipping page is not correct"); //Verifying the header of the shipping page
	//adding values to the shipping page
	addressPage.firstNameValue(firstName);
	addressPage.lastNameValue(lastName);
	addressPage.address1Value(address1);
	addressPage.address2Value(address2);
	addressPage.cityValue(city);
	addressPage.stateValue(state);
	addressPage.postalCodeValue(zip);
	addressPage.emailValue(email);
	addressPage.phoneValue(phone);
	
	//Continuing to the next page
	addressPage.continueButton();
	addressPage.continueButton();
	
	// On Payment Page
	
	paymentPage = new PaymentPage(driver);	
	s_assert.assertEquals(paymentPage.paymentPageTitle(), "BILLING","The header of the Payment page is not corrects"); //verifying the header of the payment page
	Thread.sleep(3000);
	s_assert.assertAll();
	System.out.println("Verified 23andme Payment cycle Page");
	}
	
}
