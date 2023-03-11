package actions.pageObjects.userPages.myAccountPageObjects;

import actions.pageObjects.userPages.BaseSwitchPagesObjects;

import interfaces.pageUIs.userPageUIs.myAccountPageUI.AddressPageUI;

import org.openqa.selenium.WebDriver;

public class AddressPageObjects extends BaseSwitchPagesObjects {
    private final WebDriver driver;

    public AddressPageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String getAddressHeader() {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_PAGE_TITLE);
        return getElementText(driver, AddressPageUI.ADDRESS_PAGE_TITLE);
    }

    public String getAddressData() {
        waitForElementVisible(driver, AddressPageUI.NO_ADDRESS_MESSAGE);
        return getElementText(driver, AddressPageUI.NO_ADDRESS_MESSAGE);
    }

    public void clickAddNewButton() {
        waitForElementVisible(driver, AddressPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
    }

    public void inputFirstName(String firstName) {
        waitForElementVisible(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputLastName(String lastname) {
        waitForElementVisible(driver, AddressPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    public void inputEmailName(String email) {
        waitForElementVisible(driver, AddressPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, email);
    }

    public void selectCountry(String selectCountry) {
        waitForElementVisible(driver, AddressPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, AddressPageUI.COUNTRY_DROPDOWN, selectCountry);
    }

    public void inputCity(String city) {
        waitForElementVisible(driver, AddressPageUI.CITY_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.CITY_TEXTBOX, city);
    }

    public void inputAddress1(String address1) {
        waitForElementVisible(driver, AddressPageUI.ADDRESS_1_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.ADDRESS_1_TEXTBOX, address1);
    }

    public void inputZipPostalCode(String zipCode) {
        waitForElementVisible(driver, AddressPageUI.ZIP_POSTAL_CODE_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipCode);
    }

    public void inputPhoneNumber(String phoneNumber) {
        waitForElementVisible(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void clickSaveButton() {
        waitForElementVisible(driver, AddressPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressPageUI.SAVE_BUTTON);
    }

    public String getMessageAddedSuccessfully() {
        waitForElementVisible(driver, AddressPageUI.MESSAGE_ADDED_SUCCESSFULLY);
        return getElementText(driver, AddressPageUI.MESSAGE_ADDED_SUCCESSFULLY);
    }

    public void clickCloseButton() {
        waitForElementVisible(driver, AddressPageUI.CLOSE_MESSAGE_BUTTON);
        clickToElement(driver, AddressPageUI.CLOSE_MESSAGE_BUTTON);
    }
}
