package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.HomePageObjects;
import actions.pageObjects.LoginPageObjects;
import actions.pageObjects.RegisterPageObjects;
import actions.pageObjects.myAccountPageObjects.CustomerInfoPageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User03CustomerInfo extends BaseTest {
    WebDriver driver;

    private String emailAddress, updateEmail;
    private String password;
    private String firstName, lastName;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private CustomerInfoPageObjects customerInfoPageObjects;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        emailAddress = "Automation" + generateRandomNumber() + "@gmail.vn";
        updateEmail = "Automation" + generateRandomNumber() + "@gmail.vn";
        firstName = "Hung";
        lastName = "Automation" + generateRandomNumber();
        password = "12345678";

        homePageObjects = PageGeneratorManager.getHomePage(driver);
        RegisterPageObjects registerPageObjects = homePageObjects.clickRegisterLink();

        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox(password);
        registerPageObjects.clickRegisterButton();
        System.out.println(emailAddress + " " + password);
        homePageObjects = registerPageObjects.clickContinueButton();

        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox(password);

        homePageObjects = loginPageObjects.clickLoginButton();
        customerInfoPageObjects = homePageObjects.clickMyAccountLink();
    }

    @Test
    public void Customer_01_Validate_Info() {
        Assert.assertEquals(customerInfoPageObjects.getValueOfFirstName(), firstName);
        Assert.assertEquals(customerInfoPageObjects.getValueOfLastName(), lastName);
        Assert.assertEquals(customerInfoPageObjects.getValueOfEmail(), emailAddress);
    }

    @Test
    public void Customer_02_Update_Info() {
        customerInfoPageObjects.checkGenderMale();
        customerInfoPageObjects.updateEmailAddress(updateEmail);
        customerInfoPageObjects.clickSaveButton();

        Assert.assertEquals(
                customerInfoPageObjects.getMessageUpdateSuccess(),
                "The customer info has been updated successfully.");
        Assert.assertTrue(customerInfoPageObjects.getStatusOfGender());
        Assert.assertEquals(customerInfoPageObjects.getValueOfEmail(), updateEmail);

        customerInfoPageObjects.clickCloseUpdateButton();
        homePageObjects = customerInfoPageObjects.clickLogoutLink();
    }

    @Test
    public void Customer_03_Login_With_Old_Email() {
        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox(password);

        loginPageObjects.clickLoginButton();

        Assert.assertEquals(
                loginPageObjects.getAccountErrorMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n"
                        + "No customer account found");
    }

    @Test
    public void Customer_04_Login_With_Update_Email() {
        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox(updateEmail);
        loginPageObjects.inputToPasswordTextbox(password);

        homePageObjects = loginPageObjects.clickLoginButton();
        Assert.assertTrue(homePageObjects.isMyAccountDisplay());
        customerInfoPageObjects = homePageObjects.clickMyAccountLink();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
