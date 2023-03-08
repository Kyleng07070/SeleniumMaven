package actions.pageManager;

import actions.pageObjects.HomePageObjects;
import actions.pageObjects.LoginPageObjects;
import actions.pageObjects.RegisterPageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObjects getHomePage(WebDriver driver) {
        return new HomePageObjects(driver);
    }

    public static LoginPageObjects getLoginPage(WebDriver driver) {
        return new LoginPageObjects(driver);
    }

    public static RegisterPageObjects getRegisterPage(WebDriver driver) {
        return new RegisterPageObjects(driver);
    }
}
