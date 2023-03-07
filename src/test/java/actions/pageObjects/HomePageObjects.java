package actions.pageObjects;

import actions.commons.BasePage;

import interfaces.pageUIs.HomePageUI;

import org.openqa.selenium.WebDriver;

public class HomePageObjects extends BasePage {
    private final WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void clickRegisterLink() {
        waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickLoginLink() {
        waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public boolean isMyAccountDisplay() {
        waitForAllElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
