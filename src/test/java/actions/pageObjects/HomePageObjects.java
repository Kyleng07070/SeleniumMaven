package actions.pageObjects;

import actions.commons.BasePage;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.myAccountPageObjects.CustomerInfoPageObjects;

import interfaces.pageUIs.HomePageUI;

import org.openqa.selenium.WebDriver;

public class HomePageObjects extends BasePage {
    private final WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public RegisterPageObjects clickRegisterLink() {
        waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObjects clickLoginLink() {
        waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public boolean isMyAccountDisplay() {
        waitForAllElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public CustomerInfoPageObjects clickMyAccountLink() {
        waitForAllElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }
}
