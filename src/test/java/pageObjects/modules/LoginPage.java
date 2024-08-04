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
	
	@FindBy(id = "ctl00_phBody_SignIn_lblemailmsg")
	private WebElement findErrorMsg_Txt;
	
	@FindBy(id="ctl00_phBody_SignIn_lblemailmsg")
	private WebElement accountEmailErrorMsg_Txt;
	
	@FindBy(xpath="//*[@id=\"ctl00_phBody_SignIn_lblemailmsg\"]")
	private WebElement validEmailErrorMsg_Txt;
	
	@FindBy(id="ctl00_phBody_SignIn_rfvPassword")
	private WebElement validPassErrorMsg_Txt;
	
	@FindBy(id="ctl00_phBody_SignIn_rfvPassword")
	private WebElement enterPasswordErrorMsg_Txt;

	@FindBy(id = "ctl00_phBody_SignIn_btnRequestOTP")
	private WebElement requestOTP_Btn;
	
	@FindBy(xpath = "//a[@class='forgotpasswordlink themecolor']")
	private WebElement forgotyourPassword_Txt;

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
		ExplicitWaiting.waitForSomeTime(5000);
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
		sendKeys_EmailId_Txt(username);
		sendkeys_Password_Txt(password);
		click_LoginIn_Btn();
	}
	
	public void goto_AccountLogin() {
		mouseHover(myAccount_Btn);
		login_Link.click();
	}
	
	public boolean isDisplay_validEmailErrorMsg_Txt() {
		return validEmailErrorMsg_Txt.isDisplayed();
	}
	
	public boolean isDisplay_AccountEmailErrorMsg_Txt() {
		return accountEmailErrorMsg_Txt.isDisplayed();
	}
	
	public String getText_AccountEmailErrorMsg_Txt() {
		return accountEmailErrorMsg_Txt.getText();
	}
	
	
	public String  getText_ValidemailError() {
		return validEmailErrorMsg_Txt.getText();
	}
	
	public String getText_FindEmailErrorMsg_Txt() {
		return findErrorMsg_Txt.getText();
	}
	
	public String getText_EnterPasswordError_Txt(){
		return enterPasswordErrorMsg_Txt.getText();
	}
	
	
	public void isDisplay_EmailPasswordLogin_Txt() {
		emailId_Txt.isDisplayed();
		 password_Txt.isDisplayed();
		 loginIn_Btn.isDisplayed();
	}
	
	public void sendkeys_EmailPasswordLogin_Click(String username,String password) {
		sendKeys_EmailId_Txt(username);
		sendkeys_Password_Txt(password);
		click_LoginIn_Btn();
	}
	
	public boolean isDisplay_ForgotyourPassword_Txt() {
		return  forgotyourPassword_Txt.isDisplayed();
	}
	
	public void click_forgotyourPassword_Txt() {
		forgotyourPassword_Txt.click();
		ExplicitWaiting.waitForSomeTime(5000);
	}
	
	
	
	
	
	

}
