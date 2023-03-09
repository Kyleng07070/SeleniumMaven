package actions.pageObjects.myAccountPageObjects;

import actions.commons.BaseSwitchPages;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.HomePageObjects;

import interfaces.pageUIs.myAccountPageUI.CustomerInfoPageUI;

import org.openqa.selenium.WebDriver;

public class CustomerInfoPageObjects extends BaseSwitchPages {
    private final WebDriver driver;

    public CustomerInfoPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getValueOfFirstName() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getValueOfLastName() {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getValueOfEmail() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public void checkGenderMale() {
        waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE);
        checkToDefaultCheckBoxRadio(driver, CustomerInfoPageUI.GENDER_MALE);
    }

    public void clickSaveButton() {
        waitForElementVisible(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }

    public String getMessageUpdateSuccess() {
        waitForElementVisible(driver, CustomerInfoPageUI.MESSAGE_UPDATED_SUCCESSFULLY);
        return getElementText(driver, CustomerInfoPageUI.MESSAGE_UPDATED_SUCCESSFULLY);
    }

    public boolean getStatusOfGender() {
        waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE);
    }

    public void updateEmailAddress(String email) {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
    }

    public HomePageObjects clickLogoutLink() {
        waitForElementClickAble(driver, CustomerInfoPageUI.LOGOUT_LINK);
        clickToElement(driver, CustomerInfoPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public void clickCloseUpdateButton() {
        waitForElementVisible(driver, CustomerInfoPageUI.CLOSE_UPDATE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.CLOSE_UPDATE_BUTTON);
    }
}
