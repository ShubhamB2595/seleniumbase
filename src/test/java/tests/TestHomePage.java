package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TestHomePage extends PageFactoryInitializer{

	@Test
	public void verify_Logo_From_HomePage() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage().isDisplay_BookSwagon_Logo(), "Should display bookswagon logo");
		softAssert.assertAll();
	}
	
	@Test
	public void verify_Functionality_Of_SearchBar() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage().isDisplay_SearchBar_Txt(), "Should display search box");
		
		homePage().searchBook(bookName);
		String searchResult_Header = homePage().getText_SearchResult_Header();
		softAssert.assertTrue(searchResult_Header.contains(bookName));
		softAssert.assertAll();
	}
	
	

}
