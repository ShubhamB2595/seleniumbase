package pageObjects.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class CartPage extends PageFactoryInitializer {

	@FindBy(xpath = "//a[@href='https://www.bookswagon.com/shoppingcart.aspx']//span[@class='itemcount']")
	private WebElement cartPage_Logo;

	@FindBy(xpath = "//a[normalize-space()='Book']")
	private WebElement bookDropDown_txt;

	@FindBy(xpath = "//ul[@class='list-unstyled maincategory dropdown']//a[@onclick='getSearchResult()'][normalize-space()='Fiction']")
	private WebElement fictionBookCategory_txt;

	@FindBy(xpath = "//a[normalize-space()='The Hidden Hindu']")
	private WebElement bookName_TheHiddenHindu;

	@FindBy(xpath = "//a[@id='btnAddtocart']")
	private WebElement addToCart_Btn;

	@FindBy(xpath = "//label[@id='ctl00_phBody_BookCart_lvCart_ctrl0_lblProductTitle']")
	private WebElement cartItem_Name;

	@FindBy(id = "ctl00_phBody_BookCart_lvCart_ctrl0_btnMovetoWishlist")
	private WebElement moveToWishList_Btn;

	@FindBy(id = "ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete")
	private WebElement remove_Btn;

	@FindBy(id = "ctl00_phBody_BookCart_lvCart_imgPayment")
	private WebElement buy_Btn;

	@FindBy(xpath = "//a[@href='https://www.bookswagon.com/shoppingcart.aspx']")
	private WebElement cartPage_Link;

	@FindBy(id = "ctl00_lblTotalCartItems")
	private WebElement cartItem_Count;

	@FindBy(xpath = "//a[text()='Remove']")
	private List<WebElement> newRemove_Btn;

	@FindBy(xpath = "//div[@class='title']/a")
	private List<WebElement> bookNameList_Title;
	
	@FindBy(xpath= "//option[@selected='selected']")
	private WebElement currency_Type;
	
	@FindBy(id="ctl00_phBody_BookCart_lvCart_lblTotalGross")
	private WebElement totalGrossPrice_Txt;
	
	@FindBy(id="ctl00_phBody_ddlCurrency")
	private WebElement currencyDropdown_Arrow;
	
	@FindBy(xpath="//*[@id='ctl00_phBody_ddlCurrency']/option[1]")
	private WebElement currencyINR_Txt;
	
	@FindBy(xpath="//*[@id='ctl00_phBody_ddlCurrency']/option[2]")
	private WebElement currencyUSD_Txt;
	
	@FindBy(id ="ctl00_phBody_BookCart_lvCart_ctrl0_txtQty")
	private WebElement quantitybox_Count;
	
	@FindBy(id="ctl00_phBody_BookCart_lvCart_ctrl0_btnPlus")
	private WebElement plus_Btn;
	
	@FindBy(id="ctl00_phBody_BookCart_lvCart_ctrl0_btnMinus")
	private WebElement minus_Btn;
	
	@FindBy(xpath="//h1[normalize-space()='My Shopping Cart']")
	private WebElement shoppingCartPage_Title;
	
	@FindBy(xpath="//h1")
	private WebElement checkOutPage_Title;
	
	@FindBy(xpath="//a[text()='New Arrivals']")
	private WebElement newArrival_Link;
	
	@FindBy(xpath="//img[@alt='Make Epic Money']")
	private WebElement makeEpicMoney_BookName;
	
	@FindBy(xpath="//label[text()='Product successsfully added to the cart']")
	private WebElement successMessage_Txt;
	
	@FindBy(xpath="//a[text()='Box Sets']")
	private WebElement boxSet_Link;
	
	@FindBy(xpath="//img[@alt='India Unboxed']")
	private WebElement indiaUnboxed_BookName;
	
	@FindBy(xpath="//a[text()='Best sellers']")
	private WebElement bestSellers_Link;
	
	@FindBy(xpath="//img[@alt='Doglapan']")
	private WebElement bestSellers_Book;
	
	@FindBy(xpath="//a[text()='Fiction Books']")
	private WebElement fictionBook_Link;
	
	@FindBy(xpath="//img[@alt='It Ends with Us']")
	private WebElement fiction_Book;
	
	@FindBy(xpath="//a[text()='Award Winners']")
	private WebElement awardWinners_Link;
	
	@FindBy(xpath="//img[@alt='Conscious Parent']")
	private WebElement awardWinner_ConsciousParent_Book;
	
	@FindBy(xpath="//a[text()='Featured Authors']")
	private WebElement featuredAuthors_Link;
	
	@FindBy(xpath="//a[text()='John Green']")
	private WebElement authorName;
	
	@FindBy(xpath="//a[text()='Paper Towns']")
	private WebElement author_Book;
	
	@FindBy(xpath="//*[@id='ctl00_li4']/a")
	private WebElement todayDealHeader;
	
	public String get_TotalGross_Price() {
		return totalGrossPrice_Txt.getText();
	}

	public String getCurrencyText() {
	    return currency_Type.getText();
	}
	
	public void click_SearchedBook(String bookName) {
		homePage().searchBook(bookName);
		int count = bookNameList_Title.size();
		for (WebElement element : bookNameList_Title) {
			if (element.getText().equals(bookName)) {
				element.click();
				break;
			}
		}
	}

	public int getCartItemCount() {
		String itemCountText = cartItem_Count.getText();
		return Integer.parseInt(itemCountText);
	}

	public int getRemoveButtonCount() {
		return newRemove_Btn.size();
	}

	public boolean isDisplay_Cartage_Logo() {
		return cartPage_Logo.isDisplayed();
	}

	public void click_CartPage_Logo() {
		cartPage_Logo.click();
		ExplicitWaiting.waitForSomeTime(2000);
	}

	public String getText_Cart_Item() {
		return cartItem_Name.getText();
	}

	public boolean isDisplayed_WishList_Btn() {
		return moveToWishList_Btn.isDisplayed();
	}

	public void click_On_WishList_Btn() {
		moveToWishList_Btn.click();
		ExplicitWaiting.waitForSomeTime(3000);
	}

	public boolean isDisplayed_Remove_Btn() {
		return remove_Btn.isDisplayed();
	}

	public void click_On_Remove_Btn() {
		remove_Btn.click();
		ExplicitWaiting.waitForSomeTime(3000);
	}

	public boolean isDisplayed_Buy_Btn() {
		return buy_Btn.isDisplayed();
	}

	public void click_On_Buy_Btn() {
		buy_Btn.click();
		ExplicitWaiting.waitForSomeTime(3000);
	}

	public void preCondition_For_CartPage(String bookName) {
		click_SearchedBook(bookName);
		ExplicitWaiting.waitForSomeTime(2000);
		click_On_AddToCart_Btn();
		click_On_CartPage_Link();
		ExplicitWaiting.waitForSomeTime(1000);
	}

	public void click_On_CartPage_Link() {
		ExplicitWaiting.explicitWaitElementToBeClickable(cartPage_Link,5000);
		cartPage_Link.click();
	}

	public boolean isDisplayed_AddTo_Cart_btn() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(addToCart_Btn, 2000);
		return addToCart_Btn.isDisplayed();
	}

	public void click_On_AddToCart_Btn() {
		ExplicitWaiting.explicitWaitElementToBeClickable(addToCart_Btn,5000);
		addToCart_Btn.click();
	}
	
	public String getCurrency_Text() {
		return currency_Type.getText();
	}
	
	public void select_INR_Currency_Txt() {
		selectByValue(currencyDropdown_Arrow,"5");
	}
	
	public void click_on_Currency_DropDown() {
		currencyDropdown_Arrow.click();
	}
	
	public boolean isDisplayed_Currency_DropDown() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(currencyDropdown_Arrow, 2000);
		return currencyDropdown_Arrow.isDisplayed();
	}
	
	public void select_USD_CurrencyTxt() {
		selectByValue(currencyDropdown_Arrow,"1");
	}
	
	public boolean isDisplayed_Quantity_Box() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(quantitybox_Count, 2000);
		return quantitybox_Count.isDisplayed();
	}

	public String getCount_Quantity_Box() {
		return quantitybox_Count.getAttribute("value");	
	}
	
	public boolean isDisplayed_Plus_Btn() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(plus_Btn, 2000);
		return plus_Btn.isDisplayed();
	}
	
	public void click_Plus_Btn() {
		ExplicitWaiting.explicitWaitElementToBeClickable(plus_Btn, 2000);
		plus_Btn.click();
		ExplicitWaiting.waitForSomeTime(3000);
	}
	
	public boolean isDisplayed_Minus_Btn() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(minus_Btn, 3000);
		return minus_Btn.isDisplayed();
	}
	
	public void click_Minus_Btn() {
		ExplicitWaiting.explicitWaitElementToBeClickable(minus_Btn, 3000);
		minus_Btn.click();
	}
	
	public String getShoppingCartPage_Title() {
		return shoppingCartPage_Title.getText();
	}
	
	public String getCheckOutPage_Title() {
		return checkOutPage_Title.getText();
	}
	
	public boolean isDisplayed_NewArrivals_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(newArrival_Link, 2000);
		return newArrival_Link.isDisplayed();
	}
	
	public void click_NewArrivals_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(newArrival_Link, 2000);
		newArrival_Link.click();
		ExplicitWaiting.waitForSomeTime(1000);
	}
	
	public boolean isDisplayed_MakeEpicMoney_BookName() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(makeEpicMoney_BookName, 2000);
		return makeEpicMoney_BookName.isDisplayed();
	}
	
	public void click_MakeEpicMoney_BookName() {
		ExplicitWaiting.explicitWaitElementToBeClickable(makeEpicMoney_BookName, 2000);
		click(makeEpicMoney_BookName);
		ExplicitWaiting.waitForSomeTime(1000);
	}
	
	public String getCartSuccessMessage_Txt() {
		return successMessage_Txt.getText();
	}
	
	public boolean isDisplayed_BoxSet_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(boxSet_Link, 2000);
		return boxSet_Link.isDisplayed();
	}
	
	public void click_BoxSet_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(boxSet_Link, 2000);
		click(boxSet_Link);
	}

	public boolean isDisplayed_IndiaUnboxed_BookName() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(indiaUnboxed_BookName, 2000);
		return indiaUnboxed_BookName.isDisplayed();
	}
	
	public void click_IndiaUnboxed_BookName() {
		ExplicitWaiting.explicitWaitElementToBeClickable(indiaUnboxed_BookName, 2000);
		click(indiaUnboxed_BookName);
	}
	
	public boolean isDisplayed_BestSellers_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(bestSellers_Link, 2000);
		return bestSellers_Link.isDisplayed();
	}
	
	public void click_BestSellers_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(bestSellers_Link, 2000);
		click(bestSellers_Link);
	}
	
	public boolean isDisplayed_BestSellerBookName() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(bestSellers_Book, 2000);
		return bestSellers_Book.isDisplayed();
	}
	
	public void click_BestSellerBookName() {
		ExplicitWaiting.explicitWaitElementToBeClickable(bestSellers_Book, 2000);
		click(bestSellers_Book);
	}
	
	public void remove_BookFromCart() {
		click_CartPage_Logo();
		click_On_Remove_Btn();
	}
	
	public boolean isDisplayed_FictionBook_txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(fictionBook_Link, 2000);
		return fictionBook_Link.isDisplayed();
	}
	
	public void click_FictionBook_txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(fictionBook_Link, 2000);
		click(fictionBook_Link);
	}
	
	public boolean isDisplayed_FictionActOfGod_Book() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(fiction_Book, 2000);
		return fiction_Book.isDisplayed();
	}
	
	public void click_FictionBiharDairies_Book() {
		ExplicitWaiting.explicitWaitElementToBeClickable(fiction_Book, 2000);
		fiction_Book.click();
	}
	
	public boolean isDisplayed_AwardWinners_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(awardWinners_Link, 2000);
		return awardWinners_Link.isDisplayed();
	}
	
	public void click_AwardWinners_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(awardWinners_Link, 2000);
		awardWinners_Link.click();
	}
	
	public boolean isDisplayed_AwardWinnerConsciousParent_Book() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(awardWinner_ConsciousParent_Book, 2000);
		return awardWinner_ConsciousParent_Book.isDisplayed();
	}
	
	public void click_AwardWinnerConsciousParent_Book() {
		ExplicitWaiting.explicitWaitElementToBeClickable(awardWinner_ConsciousParent_Book, 2000);
		awardWinner_ConsciousParent_Book.click();	
	}
	
	public boolean isDisplayed_FeaturedAuthors_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(featuredAuthors_Link, 2000);
		return featuredAuthors_Link.isDisplayed();
	}
	
	public void click_FeaturedAuthors_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(featuredAuthors_Link, 2000);
		featuredAuthors_Link.click();
	}
	
	public boolean isDisplayed_AuthorName_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(authorName, 2000);
		return authorName.isDisplayed();
	}
	
	public void click_AuthorName_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(authorName, 2000);
		click(authorName);
	}
	
	public boolean isDisplayed_AuthorBookName_Txt() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(author_Book, 2000);
		return author_Book.isDisplayed();
	}
	
	public void click_AuthorBookName_Txt() {
		ExplicitWaiting.explicitWaitElementToBeClickable(author_Book, 2000);
		click(author_Book);
	}
	
	public boolean isDisplayed_TodaysDeal_Header() {
		ExplicitWaiting.explicitWaitVisibilityOfElement(todayDealHeader, 2000);
		return todayDealHeader.isDisplayed();
	}
	
	public void click_TodaysDeal_Header() {
		ExplicitWaiting.explicitWaitElementToBeClickable(todayDealHeader, 2000);
		click(todayDealHeader);
	}
	
}


