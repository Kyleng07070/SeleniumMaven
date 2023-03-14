package actions.pageObjects.userPages;

import actions.commons.BasePage;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.userPages.myAccountPageObjects.*;

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

    public OrdersPageObjects openOrdersPage(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.ORDERS_LINK);
        clickToElement(driver, BaseSwitchPagesUI.ORDERS_LINK);
        return PageGeneratorManager.getOrdersPage(driver);
    }

    public DownloadableProductsPageObjects openDownloadableProductsPage(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(driver, BaseSwitchPagesUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGeneratorManager.getDownloadableProductsPage(driver);
    }

    public BaseSwitchPagesObjects openPagesAtSideTabMyAccount(WebDriver driver, String pageName) {
        waitForElementVisible(driver, BaseSwitchPagesUI.DYNAMIC_SIDE_TAB_LINK_PAGES, pageName);
        clickToElement(driver, BaseSwitchPagesUI.DYNAMIC_SIDE_TAB_LINK_PAGES, pageName);
        switch (pageName) {
            case "Addresses":
                return PageGeneratorManager.getAddressPage(driver);
            case "My product reviews":
                return PageGeneratorManager.getMyProductReviewPage(driver);
            case "Reward points":
                return PageGeneratorManager.getRewardPointPage(driver);
            case "Customer info":
                return PageGeneratorManager.getCustomerInfoPage(driver);
            case "Orders":
                return PageGeneratorManager.getOrdersPage(driver);
            case "Downloadable products":
                return PageGeneratorManager.getDownloadableProductsPage(driver);
            default:
                throw new RuntimeException(String.format("Invalid page name: [%s]", pageName));
        }
    }
}
