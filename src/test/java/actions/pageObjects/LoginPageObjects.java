package actions.pageObjects;

import actions.commons.BasePage;
import actions.pageManager.PageGeneratorManager;

import interfaces.pageUIs.LoginPageUI;

import org.openqa.selenium.WebDriver;

public class LoginPageObjects extends BasePage {
    private final WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public HomePageObjects clickLoginButton() {
        waitForElementClickAble(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public String getAccountErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.ACCOUNT_NOT_FOUND_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.ACCOUNT_NOT_FOUND_ERROR_MESSAGE);
    }
}
