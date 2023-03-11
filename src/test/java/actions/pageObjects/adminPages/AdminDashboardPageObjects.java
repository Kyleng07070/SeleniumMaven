package actions.pageObjects.adminPages;

import actions.commons.BasePage;

import interfaces.pageUIs.adminPageUIs.AdminDashboardPageUI;

import org.openqa.selenium.WebDriver;

public class AdminDashboardPageObjects extends BasePage {
    private final WebDriver driver;

    public AdminDashboardPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public boolean isHeaderDisplay() {
        waitForElementVisible(driver, AdminDashboardPageUI.HEADER);
        return isElementDisplay(driver, AdminDashboardPageUI.HEADER);
    }
}
