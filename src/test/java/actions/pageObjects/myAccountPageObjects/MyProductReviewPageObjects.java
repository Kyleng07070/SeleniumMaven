package actions.pageObjects.myAccountPageObjects;

import actions.commons.BaseSwitchPages;

import interfaces.pageUIs.myAccountPageUI.MyProductReviewPageUI;

import org.openqa.selenium.WebDriver;

public class MyProductReviewPageObjects extends BaseSwitchPages {
    private final WebDriver driver;

    public MyProductReviewPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getMyProductReviewHeader() {
        waitForElementVisible(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_TITLE);
        return getElementText(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_TITLE);
    }
}
