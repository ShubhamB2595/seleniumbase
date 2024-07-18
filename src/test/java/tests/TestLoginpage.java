package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TestLoginpage extends PageFactoryInitializer {

	@Test(description = "login_001 Verify the functionlity of login button")
	public void login_001() {
		SoftAssert softassert = new SoftAssert();
		loginPage().mouseOver_MyAccount_Btn();
		softassert.assertTrue(loginPage().isDisplay_Login_Link(), "login Link should present ");

		String oldurl = getWebDriver().getCurrentUrl();
		loginPage().click_Login_Link();
		String loginurl = getWebDriver().getCurrentUrl();
		softassert.assertNotEquals(oldurl, loginurl, "User should navigate to login page");
		softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(), "EmailId textbox should present ");

		loginPage().sendKeys_EmailId_Txt("rscher8@gmail.com");
		softassert.assertTrue(loginPage().isDisplay_Password_Txt(), "Password textbox should present");

		loginPage().sendkeys_Password_Txt("Rutuja@123");
		softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(), "Login textbox should present ");

		loginPage().click_LoginIn_Btn();
		softassert.assertAll();
	}

	@Test(description = "login_002 Verify the functionality of Invalid Email ID  and Password Login")
	public void login_002() {
		SoftAssert softassert = new SoftAssert();
		loginPage().mouseOver_MyAccount_Btn();
		softassert.assertTrue(loginPage().isDisplay_Login_Link(), "login Link should present ");

		String oldurl = getWebDriver().getCurrentUrl();
		loginPage().click_Login_Link();
		String loginurl = getWebDriver().getCurrentUrl();
		softassert.assertNotEquals(oldurl, loginurl, "User should navigate to login page");
		softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(), "EmailId textbox should present ");

		loginPage().sendKeys_EmailId_Txt("rschgmail.com");
		softassert.assertTrue(loginPage().isDisplay_Password_Txt(), "Password textbox should present");

		loginPage().sendkeys_Password_Txt("Rutuja123");
		softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(), "Login textbox should present ");

		loginPage().click_LoginIn_Btn();
		softassert.assertAll();
	}

	@Test(description = "login_003 verify the functionlity of invalid Emaild with password .")
	public void login_003() {
		SoftAssert softassert = new SoftAssert();
		loginPage().mouseOver_MyAccount_Btn();
		softassert.assertTrue(loginPage().isDisplay_Login_Link(), "login Link should present ");

		String oldurl = getWebDriver().getCurrentUrl();
		loginPage().click_Login_Link();
		String loginurl = getWebDriver().getCurrentUrl();
		softassert.assertNotEquals(oldurl, loginurl, "User should navigate to login page");
		softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(), "EmailId textbox should present ");

		loginPage().sendKeys_EmailId_Txt("rschgmail.com");
		softassert.assertTrue(loginPage().isDisplay_Password_Txt(), "Password textbox should present");

		loginPage().sendkeys_Password_Txt("Rutuja@123");
		softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(), "Login textbox should present ");

		loginPage().click_LoginIn_Btn();
		softassert.assertAll();
	}

	@Test(description = "login_004 verify the functionlity of Empty EmailId Login but an field password")
	public void login_004() {
		SoftAssert softassert = new SoftAssert();
		loginPage().mouseOver_MyAccount_Btn();

		softassert.assertTrue(loginPage().isDisplay_Login_Link(), "login Link should present");
		String oldurl = getWebDriver().getCurrentUrl();
		loginPage().click_Login_Link();
		String loginurl = getWebDriver().getCurrentUrl();
		softassert.assertNotEquals(oldurl, loginurl, "User should navigate to login page");

		softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(), "EmaildId textbox should present");
		loginPage().sendKeys_EmailId_Txt("");

		softassert.assertTrue(loginPage().isDisplay_Password_Txt(), "Password textbox should present");
		loginPage().sendkeys_Password_Txt("Rutuja@123");

		softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(), "login btn textbox should present");
		loginPage().click_LoginIn_Btn();
		softassert.assertAll();
	}

	@Test(description = "login_005 verify the functionlity of Empty password Login but an field Emailid")
	public void login_005() {
		SoftAssert softassert = new SoftAssert();
		loginPage().mouseOver_MyAccount_Btn();

		softassert.assertTrue(loginPage().isDisplay_Login_Link(), "login Link should display");
		String oldurl = getWebDriver().getCurrentUrl();
		loginPage().click_Login_Link();
		String loginurl = getWebDriver().getCurrentUrl();
		softassert.assertNotEquals(oldurl, loginurl, "User should navigate to login page ");

		softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(), "EmailId textbox should present");
		loginPage().sendKeys_EmailId_Txt("rscher8@gmail.com");

		softassert.assertTrue(loginPage().isDisplay_Password_Txt(), "password textbox should present");
		loginPage().sendkeys_Password_Txt("Rutuja@123");

		softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(), "login btn textbox should present");
		loginPage().click_LoginIn_Btn();
		softassert.assertAll();
	}

}
