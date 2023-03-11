package actions.pageObjects.adminPages;

import actions.commons.BasePage;
import actions.pageManager.PageGeneratorManager;

import interfaces.pageUIs.adminPageUIs.AdminLoginPageUI;

import org.openqa.selenium.WebDriver;

public class AdminLoginPageObjects extends BasePage {
    private final WebDriver driver;

    public AdminLoginPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void inputEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPageObjects clickLoginButton() {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObjects adminLogin(String email, String password) {
        inputEmailTextbox(email);
        inputPasswordTextbox(password);
        return clickLoginButton();
    }
}
