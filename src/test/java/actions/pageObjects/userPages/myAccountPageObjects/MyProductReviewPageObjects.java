package actions.pageObjects.userPages.myAccountPageObjects;

import actions.pageObjects.userPages.BaseSwitchPagesObjects;

import interfaces.pageUIs.userPageUIs.myAccountPageUI.MyProductReviewPageUI;

import org.openqa.selenium.WebDriver;

public class MyProductReviewPageObjects extends BaseSwitchPagesObjects {
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
