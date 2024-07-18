package tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.initializePageObjects.PageFactoryInitializer;


public class TestLoginpage extends PageFactoryInitializer {
	
	@Test(description = "login_001 Verify the functionlity of login button")
	public void login_001() {
		SoftAssert softassert = new SoftAssert();
		loginPage().mouseOver_MyAccount_Btn();
		softassert.assertTrue(loginPage().isDisplay_Login_Link(),"login Link should present ");
		
		String oldurl = getWebDriver().getCurrentUrl();
		loginPage().click_Login_Link();
		String loginurl = getWebDriver().getCurrentUrl();
		softassert.assertNotEquals(oldurl,loginurl,"User should navigate to login page" );
		softassert.assertTrue(loginPage().isDisplay_EmailId_Txt(),"EmailId textbox should present ");
		
        loginPage().sendKeys_EmailId_Txt("rscher8@gmail.com");
        softassert.assertTrue(loginPage().isDisplay_Password_Txt(),"Password textbox should present");
        
		loginPage().sendkeys_Password_Txt("Rutuja@123");
		softassert.assertTrue(loginPage().isDisplay_loginIn_Btn(),"Login textbox should present ");
		
		loginPage().click_LoginIn_Btn();
		softassert.assertAll();
	}
	

}
