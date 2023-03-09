package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.HomePageObjects;
import actions.pageObjects.LoginPageObjects;
import actions.pageObjects.RegisterPageObjects;
import actions.pageObjects.myAccountPageObjects.AddressPageObjects;
import actions.pageObjects.myAccountPageObjects.CustomerInfoPageObjects;
import actions.pageObjects.myAccountPageObjects.MyProductReviewPageObjects;
import actions.pageObjects.myAccountPageObjects.RewardPointPageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User4Address extends BaseTest {
    WebDriver driver;

    private String newFirstName,
            newLastName,
            newEmail,
            selectCountry,
            address1,
            city,
            zipCode,
            phoneNumber;
    private CustomerInfoPageObjects customerInfoPageObjects;
    private AddressPageObjects addressPageObjects;
    private MyProductReviewPageObjects myProductReviewPageObjects;
    private RewardPointPageObjects rewardPointPageObjects;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        String emailAddress = "Automation" + generateRandomNumber() + "@gmail.vn";
        String firstName = "Hung";
        String lastName = "Automation" + generateRandomNumber();
        String password = "12345678";

        newFirstName = "Van Anh";
        newLastName = "Mai";
        newEmail = "Automation" + generateRandomNumber() + "@gmail.vn";
        selectCountry = "161";
        address1 = "Somewhere only we know";
        city = "Opus - The city of vows";
        zipCode = "666";
        phoneNumber = "000777888";

        HomePageObjects homePageObjects = PageGeneratorManager.getHomePage(driver);
        RegisterPageObjects registerPageObjects = homePageObjects.clickRegisterLink();

        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox(password);
        registerPageObjects.clickRegisterButton();
        System.out.println(emailAddress);
        homePageObjects = registerPageObjects.clickContinueButton();

        LoginPageObjects loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox(password);

        homePageObjects = loginPageObjects.clickLoginButton();
        customerInfoPageObjects = homePageObjects.clickMyAccountLink();
    }

    @Test
    public void Address_00_Switch_Page() {
        addressPageObjects = customerInfoPageObjects.openAddressPage(driver);

        Assert.assertEquals(addressPageObjects.getAddressHeader(), "My account - Addresses");
        Assert.assertEquals(addressPageObjects.getAddressData(), "No addresses");

        rewardPointPageObjects = addressPageObjects.openRewardPointPage(driver);
        Assert.assertEquals(
                rewardPointPageObjects.getRewardPointHeader(), "My account - Reward points");

        myProductReviewPageObjects = rewardPointPageObjects.openMyProductReviewPage(driver);
        Assert.assertEquals(
                myProductReviewPageObjects.getMyProductReviewHeader(),
                "My account - My product reviews");

        customerInfoPageObjects = myProductReviewPageObjects.openCustomerInfoPage(driver);
    }

    @Test
    public void Address_01_Validate_Info() {
        addressPageObjects = customerInfoPageObjects.openAddressPage(driver);

        Assert.assertEquals(addressPageObjects.getAddressHeader(), "My account - Addresses");
        Assert.assertEquals(addressPageObjects.getAddressData(), "No addresses");
    }

    @Test
    public void Address_02_Add_New_Address() {
        addressPageObjects.clickAddNewButton();

        addressPageObjects.inputFirstName(newFirstName);
        addressPageObjects.inputLastName(newLastName);
        addressPageObjects.inputEmailName(newEmail);
        addressPageObjects.selectCountry(selectCountry);
        addressPageObjects.inputCity(city);
        addressPageObjects.inputAddress1(address1);
        addressPageObjects.inputZipPostalCode(zipCode);
        addressPageObjects.inputPhoneNumber(phoneNumber);
        addressPageObjects.clickSaveButton();

        Assert.assertEquals(
                addressPageObjects.getMessageAddedSuccessfully(),
                "The new address has been added successfully.");

        addressPageObjects.clickCloseButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
