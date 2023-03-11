package actions.pageObjects.userPages.myAccountPageObjects;

import actions.pageObjects.userPages.BaseSwitchPagesObjects;

import interfaces.pageUIs.userPageUIs.myAccountPageUI.RewardPointPageUI;

import org.openqa.selenium.WebDriver;

public class RewardPointPageObjects extends BaseSwitchPagesObjects {
    private final WebDriver driver;

    public RewardPointPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getRewardPointHeader() {
        waitForElementVisible(driver, RewardPointPageUI.REWARD_PAGE_TITLE);
        return getElementText(driver, RewardPointPageUI.REWARD_PAGE_TITLE);
    }
}
