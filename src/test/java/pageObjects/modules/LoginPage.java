package pageObjects.modules;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageFactoryInitializer {

	@FindBy(id = "ctl00_lblUser")
	private WebElement myAccount_Btn;

	@FindBy(xpath = "//a[@class=\"btn btn-block themebackground text-white pt-1 pb-1 loginbtn\"]")
	private WebElement login_Link;

	@FindBy(id = "ctl00_phBody_SignIn_txtEmail")
	private WebElement emailId_Txt;

	@FindBy(id = "ctl00_phBody_SignIn_txtPassword")
	private WebElement password_Txt;

	@FindBy(id = "ctl00_phBody_SignIn_btnLogin")
	private WebElement loginIn_Btn;

	@FindBy(id = "ctl00_phBody_SignIn_btnRequestOTP")
	private WebElement requestOTP_Btn;

	public void mouseOver_MyAccount_Btn() {
		mouseHover(myAccount_Btn);
		// Actions action = new Actions(getWebDriver());
		// action.moveToElement(myAccount_Btn).build().perform();
	}

	public boolean isDisplay_Login_Link() {
		return login_Link.isDisplayed();
	}

	public void click_Login_Link() {
		login_Link.click();
		ExplicitWaiting.waitForSomeTime(5000);
	}

	public void sendKeys_EmailId_Txt(String username) {
		emailId_Txt.sendKeys(username);
		ExplicitWaiting.waitForSomeTime(1000);
	}

	public void sendkeys_Password_Txt(String password) {
		password_Txt.sendKeys(password);
		ExplicitWaiting.waitForSomeTime(1000);
	}

	public void click_LoginIn_Btn() {
		loginIn_Btn.click();
		ExplicitWaiting.waitForSomeTime(2000);
	}

	public boolean isDisplay_EmailId_Txt() {
		return emailId_Txt.isDisplayed();
	}
	
	public boolean isDisplay_Password_Txt() {
		return  password_Txt.isDisplayed();
	}
	
	public boolean isDisplay_loginIn_Btn() {
		return loginIn_Btn.isDisplayed();
	}

	public void login_ToApplication(String username, String password) {
		mouseOver_MyAccount_Btn();
		click_Login_Link();
		sendKeys_EmailId_Txt(username);
		sendkeys_Password_Txt(password);
		click_LoginIn_Btn();
	}
	
	

}
