package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.modules.HomePage;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 */

public class PageFactoryInitializer extends BaseMethod {
	
	// create object of class as method and initialize page factory
	public HomePage homePage() {
		return PageFactory.initElements(getWebDriver(), HomePage.class);
	}
}
