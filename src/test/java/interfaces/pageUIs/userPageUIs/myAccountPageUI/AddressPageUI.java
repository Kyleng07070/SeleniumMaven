package interfaces.pageUIs.userPageUIs.myAccountPageUI;

public class AddressPageUI {
    public static final String ADDRESS_PAGE_TITLE = "//div[@class='page-title']/h1";
    public static final String NO_ADDRESS_MESSAGE = "//div[@class='no-data']";
    public static final String ADD_NEW_BUTTON = "//button[contains(@class,'add-address-button')]";
    public static final String FIRST_NAME_TEXTBOX = "//input[@id='Address_FirstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@id='Address_LastName']";
    public static final String EMAIL_TEXTBOX = "//input[@id='Address_Email']";
    public static final String COUNTRY_DROPDOWN = "//select[@id='Address_CountryId']";
    public static final String CITY_TEXTBOX = "//input[@id='Address_City']";
    public static final String ADDRESS_1_TEXTBOX = "//input[@id='Address_Address1']";
    public static final String ZIP_POSTAL_CODE_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
    public static final String PHONE_NUMBER_TEXTBOX = "//input[@id='Address_PhoneNumber']";
    public static final String SAVE_BUTTON = "//button[contains(@class,'save-address-button')]";
    public static final String MESSAGE_ADDED_SUCCESSFULLY =
            "//div[contains(@class,'bar-notification')]/p[@class='content']";
    public static final String CLOSE_MESSAGE_BUTTON = "//span[@title='Close']";
}
