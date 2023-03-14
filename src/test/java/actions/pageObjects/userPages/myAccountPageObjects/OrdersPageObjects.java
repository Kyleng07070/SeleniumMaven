package actions.pageObjects.userPages.myAccountPageObjects;

import actions.pageObjects.userPages.BaseSwitchPagesObjects;

import interfaces.pageUIs.userPageUIs.myAccountPageUI.OrdersPageUI;

import org.openqa.selenium.WebDriver;

public class OrdersPageObjects extends BaseSwitchPagesObjects {
    private final WebDriver driver;

    public OrdersPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getOrdersHeader() {
        waitForElementVisible(driver, OrdersPageUI.ORDERS_PAGE_TITLE);
        return getElementText(driver, OrdersPageUI.ORDERS_PAGE_TITLE);
    }
}
