package actions.pageObjects.userPages;

import actions.commons.BasePage;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.userPages.myAccountPageObjects.AddressPageObjects;
import actions.pageObjects.userPages.myAccountPageObjects.CustomerInfoPageObjects;
import actions.pageObjects.userPages.myAccountPageObjects.MyProductReviewPageObjects;
import actions.pageObjects.userPages.myAccountPageObjects.RewardPointPageObjects;

import interfaces.pageUIs.userPageUIs.BaseSwitchPagesUI;

import org.openqa.selenium.WebDriver;

public class BaseSwitchPagesObjects extends BasePage {
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
