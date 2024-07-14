package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class HomePage extends PageFactoryInitializer{
	
	@FindBy(id="ctl00_imglogo")
	private WebElement bookSwagon_Logo;
	
	@FindBy(id="inputbar")
	private WebElement searchBar_Txt;
	
	@FindBy(id="btnTopSearch")
	private WebElement search_Btn;
	
	@FindBy(xpath="//h1")
	private WebElement searchResult_Header;
	
	public boolean isDisplay_BookSwagon_Logo() {
		return bookSwagon_Logo.isDisplayed();
	}
	
	public boolean isDisplay_SearchBar_Txt() {
		return searchBar_Txt.isDisplayed();
	}
	
	public void sendKeys_SearchBar_Txt(String product) {
		searchBar_Txt.sendKeys(product);
	}
	
	public void click_Search_Btn() {
		search_Btn.click();
	}
	
	public void searchBook(String bookName) {
		isDisplay_SearchBar_Txt();
		sendKeys_SearchBar_Txt(bookName);
		click_Search_Btn();
		ExplicitWaiting.waitForSomeTime(5000);
	}
	
	public String getText_SearchResult_Header() {
		return searchResult_Header.getText();
	}

}
