package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class RegistrationPage extends PageFactoryInitializer {

	@FindBy(xpath = "//a[@class='themecolor headersignuplink']")
	private WebElement signUp_Link;

	@FindBy(id = "ctl00_phBody_SignUp_txtName")
	private WebElement signUpName_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_rfvName")
	private WebElement errorMsg_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_txtEmail")
	private WebElement mobNo_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_lblmsg")
	private WebElement mobnoAlreadyExist_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_rfvEmail")
	private WebElement pleaseEnterMobile_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_revCustMobile")
	private WebElement invalidMobileError_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_lblmsg")
	private WebElement verifyCaptcha_Txt;

	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	private WebElement recaptchaIframe;

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private WebElement recaptchaCheckbox;

	@FindBy(id = "ctl00_phBody_SignUp_btnContinue")
	private WebElement continue_Btn;

	@FindBy(id = "ctl00_phBody_SignUp_txtOTP")
	private WebElement enterOtp_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_txtPassword")
	private WebElement signUpPassword_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_revPassword")
	private WebElement strongPassword_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_txtConfirmPwd")
	private WebElement confirmPassword_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_cvPassword")
	private WebElement passwordNotMatch_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_rfvPassword")
	private WebElement pleaseEnterPassword_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_RequiredFieldValidator1")
	private WebElement pleaseConfirmPassword_Txt;

	@FindBy(id = "ctl00_phBody_SignUp_btnSubmit")
	private WebElement signUp_Btn;

	@FindBy(id = "ctl00_lblUser")
	private WebElement myAccount_Btn;

	public void mouseOver_MyAccount_Btn() {
		mouseHover(myAccount_Btn);
	}

	public boolean isDisplay_SignUp_Link() {
		return signUp_Link.isDisplayed();
	}

	public void click_SignUp_Link() {
		signUp_Link.click();
		ExplicitWaiting.waitForSomeTime(5000);
	}

	public boolean isDisplay_SignUpName_Txt() {
		return signUpName_Txt.isDisplayed();
	}

	public void sendKeys_SignUpName_Txt(String name) {
		signUpName_Txt.sendKeys(name);
		ExplicitWaiting.waitForSomeTime(1000);
	}

	public boolean isDisplay_ErrorMsg_Txt() {
		return errorMsg_Txt.isDisplayed();
	}

	public boolean isDisplay_MobNo_Txt() {
		return mobNo_Txt.isDisplayed();
	}

	public boolean isDisplay_MobnoAlreadyExist_Txt() {
		return mobnoAlreadyExist_Txt.isDisplayed();
	}

	public boolean isDisplay_PleaseEnterMobile_Txt() {
		return pleaseEnterMobile_Txt.isDisplayed();
	}

	public void sendKeys_MobNo_Txt(String mobno) {
		mobNo_Txt.sendKeys(mobno);
		ExplicitWaiting.waitForSomeTime(1000);
	}

	public boolean isDisplay_InvalidMobileError_Txt() {
		return invalidMobileError_Txt.isDisplayed();
	}

	public boolean isDisplay_VerifyCaptcha_Txt() {
		return verifyCaptcha_Txt.isDisplayed();
	}

	public WebElement getrecaptchaIframe() {
		return recaptchaIframe;
	}

	public void click_recaptchaCheckbox() {
		ExplicitWaiting.explicitWaitElementToBeClickable(recaptchaCheckbox, 1000);
		recaptchaCheckbox.click();
		ExplicitWaiting.waitForSomeTime(60000);
	}

	public boolean isDisplay_Continue_Btn() {
		return continue_Btn.isDisplayed();
	}

	public void click_Continue_Btn() {
		continue_Btn.click();
		ExplicitWaiting.waitForSomeTime(5000);
	}

	public boolean isDisplay_EnterOtp_Txt() {
		return enterOtp_Txt.isDisplayed();
	}

	public void sendKeys_EnterOtp_Txt(String otp) {
		enterOtp_Txt.sendKeys(otp);
	}

	public boolean isDisplay_SignUpPassword_Txt() {
		return signUpPassword_Txt.isDisplayed();
	}

	public boolean isDisplay_StrongPassword_Txt() {
		return strongPassword_Txt.isDisplayed();
	}

	public void sendKeys_SignUpPassword_Txt(String password) {
		signUpPassword_Txt.sendKeys(password);
	}

	public boolean isDisplay_ConfirmPassword_Txt() {
		return confirmPassword_Txt.isDisplayed();
	}

	public void sendKeys_ConfirmPassword_Txt(String cpassword) {
		confirmPassword_Txt.sendKeys(cpassword);
	}

	public boolean isDisplay_PasswordNotMatch_Txt() {
		return passwordNotMatch_Txt.isDisplayed();
	}

	public boolean isDisplay_PleaseEnterPassword_Txt() {
		return pleaseEnterPassword_Txt.isDisplayed();
	}

	public boolean isDisplay_PleaseConfirmPassword_Txt() {
		return pleaseConfirmPassword_Txt.isDisplayed();
	}

	public boolean isDisplay_SignUp_Btn() {
		return signUp_Btn.isDisplayed();
	}

	public void click_SignUp_Btn() {
		signUp_Btn.click();
	}

	public void goTo_SignUp_Page() {
		mouseOver_MyAccount_Btn();
		click_SignUp_Link();
	}

	public void continue_ToSignUp(String name, String mobno) {
		sendKeys_SignUpName_Txt(name);
		sendKeys_MobNo_Txt(mobno);
		click_Continue_Btn();
	}

}
