package tests;

import org.testng.annotations.Test;


import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;



public class TestCartPage extends PageFactoryInitializer{
	
	@Test(description = "cartPage_001 Verify the Functionality of add to cart icon")
	public void click_On_CartPage_Logo() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplay_Cartage_Logo(), "Should display cartpage logo");
		
		String homePageURL=getWebDriver().getCurrentUrl();
		cartPage().click_CartPage_Logo();
		String cartPageURL= getWebDriver().getCurrentUrl();
		softAssert.assertNotEquals(homePageURL, cartPageURL, "Not Click on CartPage Logo");
		softAssert.assertAll();
	}

	@Test(description = "cartPage_002 Verify the Functionality of Move to wishlist button")
	public void click_On_WishList_Btn() {
		cartPage().preCondition_For_CartPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_WishList_Btn(),"Should display wishlist button");
		
		String bookTitle = cartPage().getText_Cart_Item();
		cartPage().click_On_WishList_Btn1();
		
	}

	@Test(description = "cartPage_003 Verify the Functionality of Remove button")
	public void click_On_Remove_Btn() {
		cartPage().preCondition_For_CartPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Remove_Btn(), "Should display remove button");
		
		String bookTitle = cartPage().getText_Cart_Item();
		cartPage().click_On_Remove_Btn();
		
	}
	
}
