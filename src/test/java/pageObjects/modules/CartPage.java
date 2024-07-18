package pageObjects.modules;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class CartPage extends PageFactoryInitializer{

	@FindBy (xpath="//a[@href='https://www.bookswagon.com/shoppingcart.aspx']//span[@class='itemcount']")
	private WebElement cartPage_Logo;
	
	@FindBy (xpath="//a[normalize-space()='Book']")
	private WebElement book_DropDown_txt;
	
	@FindBy (xpath ="//ul[@class='list-unstyled maincategory dropdown']//a[@onclick='getSearchResult()'][normalize-space()='Fiction']")
	private WebElement fiction_Book_Category_txt;
	
	@FindBy (xpath="//a[normalize-space()='The Hidden Hindu']")
	private WebElement bookName_The_Hidden_Hindu;
	
	@FindBy (id="btnAddtocart")
	private WebElement add_To_Cart_Btn;
	
	@FindBy (xpath="//label[@id='ctl00_phBody_BookCart_lvCart_ctrl0_lblProductTitle']")
	private WebElement cart_Item_Name;
	
	@FindBy (id="ctl00_phBody_BookCart_lvCart_ctrl0_btnMovetoWishlist")
	private WebElement move_To_WishList_Btn;
	
	@FindBy (id="ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete")
	private WebElement remove_Btn;
	
	@FindBy (id="ctl00_phBody_BookCart_lvCart_imgPayment")
	private WebElement buy_Btn;
	
	@FindBy (xpath="//a[@href='https://www.bookswagon.com/shoppingcart.aspx']")
	private WebElement cartPage_Link;
	
	@FindBy (xpath="//a[text()='Remove']")
	private List<WebElement> newRemove_Btn;
	
	public boolean isDisplay_Cartage_Logo() {
		return cartPage_Logo.isDisplayed();
	}
	
	public void click_CartPage_Logo() {
		cartPage_Logo.click();
		ExplicitWaiting.waitForSomeTime(2000);
	}
	
	public void add_Book_To_Cart()	{
		book_DropDown_txt.click();
		fiction_Book_Category_txt.click();
		bookName_The_Hidden_Hindu.click();
		add_To_Cart_Btn.click();
		ExplicitWaiting.waitForSomeTime(2000);
		
	}
	
	public String getText_Cart_Item() {
		return cart_Item_Name.getText();
	}
	
	public boolean isDisplayed_WishList_Btn() {
		return move_To_WishList_Btn.isDisplayed();
	}
	
	public void click_On_WishList_Btn1() {
		move_To_WishList_Btn.click();
	}
	
	public boolean isDisplayed_Remove_Btn() {
		return remove_Btn.isDisplayed();
	}
	
	public void click_On_Remove_Btn() {
		remove_Btn.click();
	}
	
	public boolean isDisplayed_Buy_Btn() {
		return buy_Btn.isDisplayed();
	}
	
	public void click_On_Buy_Btn() {
		buy_Btn.click();
	}
	
	public void preCondition_For_CartPage() {
		add_Book_To_Cart();
		click_On_CartPage_Link();
		ExplicitWaiting.waitForSomeTime(1000);
	}

	public void click_On_CartPage_Link() {
		cartPage_Link.click();
	}
}

