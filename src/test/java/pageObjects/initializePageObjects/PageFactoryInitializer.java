package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.modules.CartPage;
import pageObjects.modules.HomePage;

public class PageFactoryInitializer extends BaseMethod {
	
	// create object of class as method and initialize page factory
	public HomePage homePage() {
		return PageFactory.initElements(getWebDriver(), HomePage.class);
	}
	
	public CartPage cartPage() {
		return PageFactory.initElements(getWebDriver(),CartPage.class);
		
	}
}

