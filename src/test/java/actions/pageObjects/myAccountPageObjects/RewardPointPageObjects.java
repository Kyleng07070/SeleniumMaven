package actions.pageObjects.myAccountPageObjects;

import actions.commons.BaseSwitchPages;

import interfaces.pageUIs.myAccountPageUI.RewardPointPageUI;

import org.openqa.selenium.WebDriver;

public class RewardPointPageObjects extends BaseSwitchPages {
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
