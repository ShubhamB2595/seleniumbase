package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.modules.HomePage;
import pageObjects.modules.RegistrationPage;

public class PageFactoryInitializer extends BaseMethod {

	// create object of class as method and initialize page factory
	public HomePage homePage() {
		return PageFactory.initElements(getWebDriver(), HomePage.class);
	}

	public RegistrationPage registrationPage() {
		return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
	}
}
