package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageObjects.HomePageObjects;
import actions.pageObjects.LoginPageObjects;
import actions.pageObjects.RegisterPageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class User02Login extends BaseTest {
    WebDriver driver;

    private String emailAddress, firstName, lastName, password;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private RegisterPageObjects registerPageObjects;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        emailAddress = "Automation" + generateRandomNumber() + "@gmail.vn";
        firstName = "Hung";
        lastName = "Automation" + generateRandomNumber();
        password = "12345678";

        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();

        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox(password);
        registerPageObjects.clickRegisterButton();
        System.out.println(emailAddress + " " + password);
    }

    @Test
    public void Login_01_Empty_Data() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickLoginLink();

        loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(loginPageObjects.getEmailErrorMessage(), "Please enter your email");
    }

    @Test
    public void Login_02_Invalid_Email() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickLoginLink();

        loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.inputToEmailTextbox("Invalid@gmail.com");
        loginPageObjects.inputToPasswordTextbox(password);
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(
                loginPageObjects.getAccountErrorMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n"
                        + "No customer account found");
    }

    @Test
    public void Login_03_Invalid_PW() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickLoginLink();

        loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox("4567890");
        loginPageObjects.clickLoginButton();

        Assert.assertEquals(
                loginPageObjects.getAccountErrorMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n"
                        + "The credentials provided are incorrect");
    }

    @Test
    public void Login_04_Success() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickLoginLink();

        loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.inputToEmailTextbox(emailAddress);
        loginPageObjects.inputToPasswordTextbox(password);
        loginPageObjects.clickLoginButton();

        loginPageObjects.clickLogoutLink();
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
