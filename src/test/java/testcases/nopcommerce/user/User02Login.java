package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.userPages.HomePageObjects;
import actions.pageObjects.userPages.LoginPageObjects;
import actions.pageObjects.userPages.RegisterPageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User02Login extends BaseTest {
    WebDriver driver;

    private String emailAddress;
    private String password;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        emailAddress = "Automation" + generateRandomNumber() + "@gmail.vn";
        String firstName = "Hung";
        String lastName = "Automation" + generateRandomNumber();
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
    }

    @Test
    public void Login_01_Empty_Data() {
        loginPageObjects = homePageObjects.clickLoginLink();
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(loginPageObjects.getEmailErrorMessage(), "Please enter your email");
    }

    @Test
    public void Login_02_Not_Registered_Email() {
        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox("Invalid@gmail.com");
        loginPageObjects.inputToPasswordTextbox(password);
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(
                loginPageObjects.getAccountErrorMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n"
                        + "No customer account found");
    }

    @Test
    public void Login_03_Invalid_Email() {
        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox("Invalid");
        loginPageObjects.inputToPasswordTextbox(password);
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(loginPageObjects.getEmailErrorMessage(), "Wrong email");
    }

    @Test
    public void Login_04_Invalid_PW() {
        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox("4567890");
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(
                loginPageObjects.getAccountErrorMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n"
                        + "The credentials provided are incorrect");
    }

    @Test
    public void Login_05_Success() {
        loginPageObjects = homePageObjects.clickLoginLink();

        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox(password);

        homePageObjects = loginPageObjects.clickLoginButton();
        Assert.assertTrue(homePageObjects.isMyAccountDisplay());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
