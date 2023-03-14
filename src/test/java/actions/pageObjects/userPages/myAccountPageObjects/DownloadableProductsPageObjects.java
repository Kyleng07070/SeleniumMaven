package actions.pageObjects.userPages.myAccountPageObjects;

import actions.pageObjects.userPages.BaseSwitchPagesObjects;

import interfaces.pageUIs.userPageUIs.myAccountPageUI.DownloadableProductsPageUI;

import org.openqa.selenium.WebDriver;

public class DownloadableProductsPageObjects extends BaseSwitchPagesObjects {
    private final WebDriver driver;

    public DownloadableProductsPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getDownloadableProductsHeader() {
        waitForElementVisible(driver, DownloadableProductsPageUI.DOWNLOADABLE_PRODUCTS_PAGE_TITLE);
        return getElementText(driver, DownloadableProductsPageUI.DOWNLOADABLE_PRODUCTS_PAGE_TITLE);
    }
}
