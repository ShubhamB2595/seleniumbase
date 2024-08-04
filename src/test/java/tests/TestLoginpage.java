package tests;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;

public class TestLoginpage extends PageFactoryInitializer {
	String emailerrormsg ="Please enter valid Email";
	String passworderrormsg = "Please enter valid password";
	String findAccount = "We didn't find an account with this";
	String accountemailerrormsg = "We didn't find an account with this Email";
	String enteremail = "Please Enter Email";
	String enterpassword = "Please Enter Password";

	@Test(description = "login_001 Verify the functionlity of login button")
	public void login_001() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rscher8@gmail,com","Rutuja@123" );
		String errormsg = loginPage().getText_ValidemailError();
		softassert.assertEquals(errormsg, emailerrormsg,"Please enter valid Email");
		softassert.assertAll();
	}

	@Test(description = "login_002 Verify the functionality of Invalid Email ID  and Password Login")
	public void login_002() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rschgmail.com","Rutuja@123" );
		//softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(), "EmailId textbox should present ");
		//loginPage().sendKeys_EmailId_Txt("rschgmail.com");
		//softassert.assertTrue(loginPage().isDisplay_Password_Txt(), "Password textbox should present");
		//loginPage().sendkeys_Password_Txt("Rutuja123");
		//softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(), "Login textbox should present ");
	    //loginPage().click_LoginIn_Btn();
		//softassert.assertTrue(loginPage().isDisplay_validEmailErrorMsg_Txt(),"Error msg should display ");
		String errormsg = loginPage().getText_ValidemailError();
		softassert.assertEquals(errormsg, emailerrormsg,"Please enter valid Email");
		softassert.assertAll();
	}

	@Test(description = "login_003 verify the functionlity of invalid Emaild with password .")
	public void login_003() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rscher8gmail.com","Rutuja@123" );
		String errormsg = loginPage().getText_ValidemailError();
		softassert.assertEquals(errormsg, emailerrormsg,"Please enter valid Email");
		softassert.assertAll();
	}

	@Test(description = "login_004 verify the functionlity of Empty EmailId Login but an field password")
	public void login_004() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("","Rutuja@123" );
		softassert.assertAll();
	}

	@Test(description = "login_005 verify the functionlity of Empty password Login but an field Emailid")
	public void login_005() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rscher8@gmail.com", "");
		String errormsg = loginPage().getText_EnterPasswordError_Txt();
		softassert.assertEquals(errormsg,enterpassword,"Please Enter Password" );
		softassert.assertAll();
	}
	
	@Test(description = "login_006 verify the functionlity of Max Length username")
	public void login_006() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rschersudhakryavatal@gmail.com", "Rutuja@123");
		String errormsg = loginPage().getText_AccountEmailErrorMsg_Txt();
		softassert.assertEquals(errormsg,accountemailerrormsg,"We didn't find an account with this Email" );
		softassert.assertAll();
	    }
	
	@Test(description = "login_007 verify the functionlity of  Max Length Password")
	public void login_007() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rscher8@gmail.com", "1234567890366768787Rutujacher");
		String errormsg = loginPage().getText_AccountEmailErrorMsg_Txt();
		softassert.assertEquals(errormsg,accountemailerrormsg,"We didn't find an account with this Email" );
		softassert.assertAll();
	}
	
	@Test(description = "login_008 verify the functionlity of  Case Sensitivity Check")
      public void login_008() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("Rutuja_cher@gmail.com", "Rutuja@123");
		String errormsg = loginPage().getText_AccountEmailErrorMsg_Txt();
		softassert.assertEquals(errormsg,accountemailerrormsg,"We didn't find an account with this Email" );
		softassert.assertAll();
	}
	
	@Test(description = "login_011  Verify if a user cannot login with a valid username and an invalid password.")
	public void login_011() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		loginPage().isDisplay_EmailPasswordLogin_Txt();
		loginPage().sendkeys_EmailPasswordLogin_Click("rscher8@gmail.com", "Rutuja123");
		String errormsg =  loginPage().getText_AccountEmailErrorMsg_Txt();
		softassert.assertEquals(errormsg,accountemailerrormsg, "We didn't find an account with this Email");
		}
	
	@Test(description = "login_014  Verify the functionlity of  Forgot Password Functionality")
	public void login_014() {
		SoftAssert softassert = new SoftAssert();
		loginPage().goto_AccountLogin();
		softassert.assertTrue(loginPage().isDisplay_ForgotyourPassword_Txt(),"Forgot your Password text should be present");
		loginPage().click_forgotyourPassword_Txt();
	}
	
}
