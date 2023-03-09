package actions.commons;

import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.myAccountPageObjects.AddressPageObjects;
import actions.pageObjects.myAccountPageObjects.CustomerInfoPageObjects;
import actions.pageObjects.myAccountPageObjects.MyProductReviewPageObjects;
import actions.pageObjects.myAccountPageObjects.RewardPointPageObjects;

import interfaces.pageUIs.BaseSwitchPagesUI;

import org.openqa.selenium.WebDriver;

public class BaseSwitchPages extends BasePage {
    // Object Switch page UI
    public AddressPageObjects openAddressPage(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.ADDRESS_LINK);
        clickToElement(driver, BaseSwitchPagesUI.ADDRESS_LINK);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public MyProductReviewPageObjects openMyProductReviewPage(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(driver, BaseSwitchPagesUI.MY_PRODUCT_REVIEW_LINK);
        return PageGeneratorManager.getMyProductReviewPage(driver);
    }

    public RewardPointPageObjects openRewardPointPage(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.REWARD_POINT_LINK);
        clickToElement(driver, BaseSwitchPagesUI.REWARD_POINT_LINK);
        return PageGeneratorManager.getRewardPointPage(driver);
    }

    public CustomerInfoPageObjects openCustomerInfoPage(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, BaseSwitchPagesUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }
}
