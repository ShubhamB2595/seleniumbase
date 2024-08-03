package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

public class TestRegistrationPage extends PageFactoryInitializer {

	@Test(description = "registration_001 Verify the functionality of sign up hyperlink text")
	public void registration_001() {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().mouseOver_MyAccount_Btn();
		softAssert.assertTrue(registrationPage().isDisplay_SignUp_Link(), "Should display signup link");
		String oldUrl = getWebDriver().getCurrentUrl();
		registrationPage().click_SignUp_Link();
		String signUpUrl = getWebDriver().getCurrentUrl();
		softAssert.assertNotEquals(oldUrl, signUpUrl, "User should navigate to signup page");
		softAssert.assertAll();
	}

	@Test(description = "registration_002 Verify the Name field is mandatory")
	public void registration_002() {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		softAssert.assertTrue(registrationPage().isDisplay_SignUpName_Txt(), "Name field should be present");
		registrationPage().sendKeys_SignUpName_Txt(" ");
		registrationPage().sendKeys_MobNo_Txt("9404295535");
		ExplicitWaiting.waitForSomeTime(9000);
		registrationPage().click_Continue_Btn();
		softAssert.assertTrue(registrationPage().isDisplay_ErrorMsg_Txt(), "Please enter name");
		softAssert.assertAll();
	}

	@Test(description = "registration_003 Verify the Name field uses only alphabets")
	public void registration_003() {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		softAssert.assertTrue(registrationPage().isDisplay_SignUpName_Txt(), "Name field should be present");
		registrationPage().sendKeys_SignUpName_Txt("123444446");
		registrationPage().sendKeys_MobNo_Txt("9404295535");
		ExplicitWaiting.waitForSomeTime(9000);
		registrationPage().click_Continue_Btn();
		softAssert.assertAll();
	}

	@Test(description = "registration_005 Verify the Mobile Number field is mandatory")
	public void registration_005() {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		softAssert.assertTrue(registrationPage().isDisplay_MobNo_Txt(), "Mobile Number field should be present");
		registrationPage().sendKeys_MobNo_Txt(" ");
		ExplicitWaiting.waitForSomeTime(9000);
		registrationPage().click_Continue_Btn();
		softAssert.assertTrue(registrationPage().isDisplay_PleaseEnterMobile_Txt(), "Please enter mobile");
		softAssert.assertAll();
	}

	@Test(description = "registration_006 Verify the Mobile Number field should allow 10 digits")
	public void registration_006() {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		softAssert.assertTrue(registrationPage().isDisplay_MobNo_Txt(), "Mobile Number field should be present");
		registrationPage().sendKeys_MobNo_Txt("8989899233");
		ExplicitWaiting.waitForSomeTime(60000);
		registrationPage().click_Continue_Btn();
		softAssert.assertTrue(registrationPage().isDisplay_InvalidMobileError_Txt(), "Invalid mobile");
		softAssert.assertAll();
	}

	@Test(description = "registration_008 Verify the functionality of continue button")
	public void registration_008() {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("9404295535");
		softAssert.assertTrue(registrationPage().isDisplay_VerifyCaptcha_Txt(), "Please verify captcha");
		ExplicitWaiting.waitForSomeTime(60000);
		registrationPage().click_Continue_Btn();
		softAssert.assertAll();
	}

	@Test(description = "registration_009 Verify that user should receive an OTP on registered mobile no.")
	public void registration_009() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("940429553532");
		ExplicitWaiting.waitForSomeTime(90000);
		getWebDriver().switchTo().frame(registrationPage().getrecaptchaIframe());
		registrationPage().click_recaptchaCheckbox();
		getWebDriver().switchTo().defaultContent();
		Thread.sleep(8000);
		registrationPage().click_Continue_Btn();
		softAssert.assertTrue(registrationPage().isDisplay_EnterOtp_Txt(), "OTP text field should pe present");
		softAssert.assertAll();

	}

	@Test(description = "registration_010 Verify the password text should be strong")
	public void registration_010() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("940429553522");
		ExplicitWaiting.waitForSomeTime(90000);
		getWebDriver().switchTo().frame(registrationPage().getrecaptchaIframe());
		registrationPage().click_recaptchaCheckbox();
		getWebDriver().switchTo().defaultContent();
		Thread.sleep(8000);
		registrationPage().click_Continue_Btn();
		registrationPage().sendKeys_SignUpPassword_Txt("Pornima23@");
		softAssert.assertTrue(registrationPage().isDisplay_StrongPassword_Txt(), "Password should be strong");
		registrationPage().click_SignUp_Btn();
		softAssert.assertAll();

	}

	@Test(description = "registration_011 Verify the password text should matches with the confirm password text")
	public void registration_011() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("940429553522");
		ExplicitWaiting.waitForSomeTime(90000);
		getWebDriver().switchTo().frame(registrationPage().getrecaptchaIframe());
		registrationPage().click_recaptchaCheckbox();
		getWebDriver().switchTo().defaultContent();
		Thread.sleep(8000);
		registrationPage().click_Continue_Btn();
		registrationPage().sendKeys_SignUpPassword_Txt("Pornima23@");
		registrationPage().sendKeys_ConfirmPassword_Txt("Pornima23@");
		softAssert.assertTrue(registrationPage().isDisplay_PasswordNotMatch_Txt(), "Password not match");
		registrationPage().click_SignUp_Btn();
		softAssert.assertAll();

	}

	@Test(description = "registration_012 Verify that error msg shown for blank password and confirm password text")
	public void registration_012() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("940429553522");
		ExplicitWaiting.waitForSomeTime(90000);
		getWebDriver().switchTo().frame(registrationPage().getrecaptchaIframe());
		registrationPage().click_recaptchaCheckbox();
		getWebDriver().switchTo().defaultContent();
		Thread.sleep(8000);
		registrationPage().click_Continue_Btn();
		registrationPage().sendKeys_SignUpPassword_Txt(" ");
		registrationPage().sendKeys_ConfirmPassword_Txt(" ");
		softAssert.assertTrue(registrationPage().isDisplay_PleaseEnterPassword_Txt(), "Please Enter Password");
		softAssert.assertTrue(registrationPage().isDisplay_PleaseConfirmPassword_Txt(), "Please confirm Password");
		registrationPage().click_SignUp_Btn();
		softAssert.assertAll();
	}
	
	@Test(description = "registration_013 Verify the functionality of signup tab")
	public void registration_013() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("940429553522");
		ExplicitWaiting.waitForSomeTime(90000);
		getWebDriver().switchTo().frame(registrationPage().getrecaptchaIframe());
		registrationPage().click_recaptchaCheckbox();
		getWebDriver().switchTo().defaultContent();
		Thread.sleep(8000);
		registrationPage().click_Continue_Btn();
		registrationPage().sendKeys_SignUpPassword_Txt("Pornima23@");
		registrationPage().sendKeys_ConfirmPassword_Txt("Pornima23@");
		softAssert.assertTrue(registrationPage().isDisplay_SignUp_Btn(), "signup button should be present");
		registrationPage().click_SignUp_Btn();
		softAssert.assertAll();
	}

	@Test(description = "registration_014 Verify that error msg is shown for already register mob no")
	public void registration_014() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		registrationPage().goTo_SignUp_Page();
		registrationPage().sendKeys_SignUpName_Txt("Pornima");
		registrationPage().sendKeys_MobNo_Txt("9370528986");
		softAssert.assertTrue(registrationPage().isDisplay_MobnoAlreadyExist_Txt(),"The mobile number you entered already exist");		
		ExplicitWaiting.waitForSomeTime(90000);
		getWebDriver().switchTo().frame(registrationPage().getrecaptchaIframe());
		registrationPage().click_recaptchaCheckbox();
		getWebDriver().switchTo().defaultContent();
		Thread.sleep(8000);
		registrationPage().click_Continue_Btn();

	}
}
