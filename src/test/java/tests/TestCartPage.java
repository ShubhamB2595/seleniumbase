package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class TestCartPage extends PageFactoryInitializer {
	String USERNAME = "9021657453";
	String PASSWORD = "Rutika@123";
	String CURRENCY_INR = "INR";
	String CURRENCY_USD = "USD";
	String CART_MESSAGE="Product successsfully added to the cart";
	String BESTSELLERSBOOK="Doglapan";

	@Test(description = "cartPage_001 Verify the Functionality of add to cart icon")
	public void cartPage_001() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplay_Cartage_Logo(), "Should display cartpage logo");

		String homePageURL = getWebDriver().getCurrentUrl();
		cartPage().click_CartPage_Logo();
		String cartPageURL = getWebDriver().getCurrentUrl();
		softAssert.assertNotEquals(homePageURL, cartPageURL, "Not Click on CartPage Logo");
		softAssert.assertAll();
	}
	
//fail
	@Test(description = "cartPage_002 Verify the Functionality of Move to wishlist button")
	public void cartPage_002() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_WishList_Btn(), "Should display wishlist button");

		int cartItamCount = cartPage().getCartItemCount();
		cartPage().click_On_WishList_Btn();
		ExplicitWaiting.waitForSomeTime(3000);
		int updatedCartItamCount = cartPage().getCartItemCount();
		ExplicitWaiting.waitForSomeTime(3000);
		softAssert.assertNotEquals(cartItamCount, updatedCartItamCount, "Wish List Button Not clickable");
		softAssert.assertAll();
	}
	
	
	//fail
	@Test(description = "cartPage_003 Verify the Functionality of Remove button")
	public void click_On_Remove_Btn() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Remove_Btn(), "Should display remove button");

		int removeButtonCount = cartPage().getRemoveButtonCount();
		cartPage().click_On_Remove_Btn();
		ExplicitWaiting.waitForSomeTime(3000);
		int updatedRemoveButtonCount = cartPage().getRemoveButtonCount();
		softAssert.assertNotEquals(removeButtonCount, updatedRemoveButtonCount, "Not Click on Remove Button");
		softAssert.assertAll();
	}
	
//fail
	@Test(description = "cartPage_004 Verify the Functionality of Buy button")
	public void cartPage_004() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Buy_Btn(), "Should Display Buy Button");

		String cartPageURL = getWebDriver().getCurrentUrl();
		cartPage().click_On_Buy_Btn();
		ExplicitWaiting.waitForSomeTime(3000);
		String shoppingPageURL = getWebDriver().getCurrentUrl();
		softAssert.assertNotEquals(cartPageURL, shoppingPageURL, "Not Click on Buy Button");
		softAssert.assertAll();
	}

	@Test(description = "cartPage_005 Verify the Functionality of Curreny when user will select INR currency")
	public void cartPage_005() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Currency_DropDown(), "Should Display DropDown");

		String totalGrossPrice = cartPage().get_TotalGross_Price();
		System.out.println(totalGrossPrice);
		String selectedCurrency = cartPage().getCurrencyText();

		if (selectedCurrency.equals(CURRENCY_INR)) {
			cartPage().select_USD_CurrencyTxt();
		} else {
			cartPage().select_INR_Currency_Txt();
		}

		String newTotalGrossPrice = cartPage().get_TotalGross_Price();
		System.out.println(newTotalGrossPrice);
		softAssert.assertNotEquals(totalGrossPrice, newTotalGrossPrice,"Currency Not Changed");
		
		
		softAssert.assertTrue(true, "cartPage_006 Verify the Functionality of Curreny when user will select USD currency");
		ExplicitWaiting.waitForSomeTime(3000);
		
		totalGrossPrice = cartPage().get_TotalGross_Price();
		System.out.println("changes the currency"+totalGrossPrice);
		
		if (selectedCurrency.equals(CURRENCY_INR)) {
			cartPage().select_USD_CurrencyTxt();
		} else {
			cartPage().select_INR_Currency_Txt();
		}
		
		newTotalGrossPrice = cartPage().get_TotalGross_Price();
		
		System.out.println("new price"+newTotalGrossPrice);
		softAssert.assertEquals(totalGrossPrice, newTotalGrossPrice,"Currency Not Changed");
		softAssert.assertAll();
	}

	@Test(description = "cartPage_009 Verify the functionality of "+" when user click on "+" quantity")
	public void cartPage_008() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Plus_Btn(), "Should Display Plus Button");
		softAssert.assertTrue(cartPage().isDisplayed_Quantity_Box(), "Should Display Quantity Box");
		
		String quantityCount= cartPage().getCount_Quantity_Box();
		System.out.println(quantityCount);
		cartPage().click_Plus_Btn();
		ExplicitWaiting.waitForSomeTime(3000);
		String updatedQuantityCount= cartPage().getCount_Quantity_Box();
		System.out.println(updatedQuantityCount);
		softAssert.assertNotEquals(quantityCount, updatedQuantityCount,"Plus Button Not Clicked");
		softAssert.assertAll();
	}
	
	//fail
	@Test(description = "cartPage_010 Verify the functionality of (minus) when user click on (minus) quantity")
	public void cartPage_009() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		cartPage().click_Plus_Btn();
		//softAssert.assertTrue(cartPage().isDisplayed_Minus_Btn(), "Should Display Minus Button");
		softAssert.assertTrue(cartPage().isDisplayed_Quantity_Box(), "Should Display Quantity Box");
		ExplicitWaiting.waitForSomeTime(12000);

		String quantityCount= cartPage().getCount_Quantity_Box();
		ExplicitWaiting.waitForSomeTime(2000);
		System.out.println(quantityCount);
		cartPage().click_Minus_Btn();
		ExplicitWaiting.waitForSomeTime(15000);
		String updatedQuantityCount= cartPage().getCount_Quantity_Box();
		ExplicitWaiting.waitForSomeTime(3000);
		System.out.println(updatedQuantityCount);
		
		softAssert.assertNotEquals(quantityCount, updatedQuantityCount,"Minus Button Not Clicked");
		softAssert.assertAll();
	}
	
	@Test(description = "cartPage_014_Verify the Product will move to wishlist if user not login")
	public void cartPage_014() {
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_WishList_Btn(), "Should Display Wishlist");
		
		cartPage().click_On_WishList_Btn();
		String pageTitle=getWebDriver().getTitle();
		softAssert.assertNotEquals(pageTitle, "My Shopping Cart", "Page title does not match after clicking Wishlist button");
		softAssert.assertAll();	
	}
	
	@Test(description = "cartPage_015 Verify the Product will move to wishlist if user login")
	public void cartPage_015() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_WishList_Btn(), "Should Display Wishlist");
		
		cartPage().click_On_WishList_Btn();
		String pageTitle= cartPage().getShoppingCartPage_Title();
		softAssert.assertEquals(pageTitle, "My Shopping Cart", "Page title does not match after clicking Wishlist button");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	//need to check fail
	@Test(description = "cartPage_016 Verify user can't buy Product if user Not login")
	public void cartPage_16() {
		cartPage().preCondition_For_CartPage(bookName);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Buy_Btn(), "Should Display Buy Button");
		
		cartPage().click_On_Buy_Btn();
		String checkOutPageTitle=cartPage().getCheckOutPage_Title();
		softAssert.assertNotEquals(checkOutPageTitle, "Checkout Your Cart", "Page title does not match after clicking Wishlist button");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	
	//need to check fail
	@Test(description = "cartPage_017 Verify user can buy Product if user login")
	public void cartPage_17() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		cartPage().preCondition_For_CartPage(BOOK_NAME);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_Buy_Btn(), "Should Display Buy Button");
		String oldURL = getWebDriver().getCurrentUrl();
		ExplicitWaiting.waitForSomeTime(3000);
		cartPage().click_On_Buy_Btn();
		//String checkOutPageTitle=cartPage().getCheckOutPage_Title();
		String newURL = getWebDriver().getCurrentUrl();
		softAssert.assertNotEquals(oldURL, newURL, "Page title does not match after clicking Wishlist button");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	
	@Test(description = "cartPage_018 Verify adding the book to the cart from New Arrival in Home Page")
	public void cartPage_018() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_NewArrivals_Txt(), "Should Display New Arrivals Text");
		
		cartPage().click_NewArrivals_Txt();
		softAssert.assertTrue(cartPage().isDisplayed_MakeEpicMoney_BookName(), "Should Display Make Epic Money Book");
		cartPage().click_MakeEpicMoney_BookName();
		cartPage().click_On_AddToCart_Btn();
		String SuccessMessage = cartPage().getCartSuccessMessage_Txt();
		softAssert.assertEquals(SuccessMessage,CART_MESSAGE, "Product not added to cart");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	//fail
	@Test(description = "cartPage_019 Verify adding the book to the cart from Box set in Home Page")
	public void cartPage_019() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_BoxSet_Txt(), "Should Display BoxSet Text");
		
		cartPage().click_BoxSet_Txt();
		softAssert.assertTrue(cartPage().isDisplayed_IndiaUnboxed_BookName(), "Should Display India Unboxed Book");
		cartPage().click_IndiaUnboxed_BookName();
		cartPage().click_On_AddToCart_Btn();
		String SuccessMessage = cartPage().getCartSuccessMessage_Txt();
		softAssert.assertEquals(SuccessMessage,CART_MESSAGE, "Product not added to cart");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	
	@Test(description = "cartPage_020 Verify adding the book to the cart from Best seller in Home Page")
	public void cartPage_020() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_BestSellers_Txt(), "Should Display Best sellers Text");
		
		cartPage().click_BestSellers_Txt();
		softAssert.assertTrue(cartPage().isDisplayed_BestSellerBookName(), "Should Display Doglapan Book");
		cartPage().click_BestSellerBookName();
		cartPage().click_On_AddToCart_Btn();
		String SuccessMessage = cartPage().getCartSuccessMessage_Txt();
		softAssert.assertEquals(SuccessMessage,CART_MESSAGE, "Product not added to cart");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	//need to check fail
	@Test(description = "cartPage_021 Verify adding the book to the cart from Fiction books in Home Page")
	public void cartPage_021(){
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_FictionBook_txt(), "Should Display Fiction Book Text");
		
		cartPage().click_FictionBook_txt();
		softAssert.assertTrue(cartPage().isDisplayed_FictionActOfGod_Book(), "Should Display Act Of God Book");
		cartPage().click_FictionActOfGod_Book();
		cartPage().click_On_AddToCart_Btn();
		String SuccessMessage = cartPage().getCartSuccessMessage_Txt();
		softAssert.assertEquals(SuccessMessage,CART_MESSAGE, "Product not added to cart");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();
	}
	
	@Test(description = "cartPage_022 Verify adding the book to the cart from Award winner in Home Page")
	public void cartPage_022() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_AwardWinners_Txt(), "Should Display Award Winner Text");
		
		cartPage().click_AwardWinners_Txt();
		softAssert.assertTrue(cartPage().isDisplayed_AwardWinnerConsciousParent_Book(), "Should Display Conscious Parent Book");
		cartPage().click_AwardWinnerConsciousParent_Book();
		cartPage().click_On_AddToCart_Btn();
		String SuccessMessage = cartPage().getCartSuccessMessage_Txt();
		softAssert.assertEquals(SuccessMessage,CART_MESSAGE, "Product not added to cart");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();	
	}
	
	@Test(description = "cartPage_023 Verify adding the book to the cart from Feature Authors in Home Page")
	public void cartPage_023() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_FeaturedAuthors_Txt(), "Should Display Featured Author Text");
		
		cartPage().click_FeaturedAuthors_Txt();
		softAssert.assertTrue(cartPage().isDisplayed_AuthorName_Txt(), "Should Display Author Name");
		cartPage().click_AuthorName_Txt();
		softAssert.assertTrue(cartPage().isDisplayed_AuthorBookName_Txt(), "Should Display Author Book Name");
		cartPage().click_AuthorBookName_Txt();
		cartPage().click_On_AddToCart_Btn();
		String SuccessMessage = cartPage().getCartSuccessMessage_Txt();
		softAssert.assertEquals(SuccessMessage,CART_MESSAGE, "Product not added to cart");
		cartPage().remove_BookFromCart();
		softAssert.assertAll();	
	}
	
	@Test(description = "cartPage_024 Verify adding the book to the cart from Today's deal in Home Page")
	public void cartPage_024() {
		loginPage().login_ToApplication(USERNAME, PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartPage().isDisplayed_TodaysDeal_Header(), "Should Display Deal of the Day Header");
		
		cartPage().click_TodaysDeal_Header();
	}
}
