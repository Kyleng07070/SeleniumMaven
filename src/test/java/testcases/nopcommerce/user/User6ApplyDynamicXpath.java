package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.userPages.HomePageObjects;
import actions.pageObjects.userPages.LoginPageObjects;
import actions.pageObjects.userPages.RegisterPageObjects;
import actions.pageObjects.userPages.myAccountPageObjects.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User6ApplyDynamicXpath extends BaseTest {
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
    private OrdersPageObjects ordersPageObjects;
    private DownloadableProductsPageObjects downloadableProductsPageObjects;

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
        addressPageObjects =
                (AddressPageObjects)
                        customerInfoPageObjects.openPagesAtSideTabMyAccount(driver, "Addresses");

        Assert.assertEquals(addressPageObjects.getAddressHeader(), "My account - Addresses");
        Assert.assertEquals(addressPageObjects.getAddressData(), "No addresses");

        rewardPointPageObjects =
                (RewardPointPageObjects)
                        addressPageObjects.openPagesAtSideTabMyAccount(driver, "Reward points");
        Assert.assertEquals(
                rewardPointPageObjects.getRewardPointHeader(), "My account - Reward points");

        myProductReviewPageObjects =
                (MyProductReviewPageObjects)
                        rewardPointPageObjects.openPagesAtSideTabMyAccount(
                                driver, "My product reviews");
        Assert.assertEquals(
                myProductReviewPageObjects.getMyProductReviewHeader(),
                "My account - My product reviews");

        ordersPageObjects =
                (OrdersPageObjects)
                        myProductReviewPageObjects.openPagesAtSideTabMyAccount(driver, "Orders");
        Assert.assertEquals(ordersPageObjects.getOrdersHeader(), "My account - Orders");

        downloadableProductsPageObjects =
                (DownloadableProductsPageObjects)
                        ordersPageObjects.openPagesAtSideTabMyAccount(
                                driver, "Downloadable products");
        Assert.assertEquals(
                downloadableProductsPageObjects.getDownloadableProductsHeader(),
                "My account - Downloadable products");
    }

    @Test
    public void Address_01_Validate_Info() {
        addressPageObjects =
                (AddressPageObjects)
                        downloadableProductsPageObjects.openPagesAtSideTabMyAccount(
                                driver, "Addresses");

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
