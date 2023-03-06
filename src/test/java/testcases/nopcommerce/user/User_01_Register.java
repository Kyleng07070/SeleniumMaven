package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageObjects.HomePageObjects;
import actions.pageObjects.RegisterPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class User_01_Register extends BaseTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    private String emailAddress, firstName, lastName, password;
    private RegisterPageObjects registerPageObjects;
    private HomePageObjects homePageObjects;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        emailAddress  = "Automation" + generateRandomNumber() +"@gmail.vn";
        firstName = "Hung";
        lastName = "Automation" + generateRandomNumber();
        password = "12345678";
    }

    @Test
    public void Register_01_Empty_Data() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();
        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.clickRegisterButton();

        Assert.assertEquals(registerPageObjects.getFirstNameErrorMessage(), "First name is required.");
        Assert.assertEquals(registerPageObjects.getLastNameErrorMessage(), "Last name is required.");
        Assert.assertEquals(registerPageObjects.getEmailErrorMessage(), "Email is required.");
        Assert.assertEquals(registerPageObjects.getPasswordErrorMessage(), "Password is required.");
        Assert.assertEquals(registerPageObjects.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();

        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox("InvalidEmail");
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox(password);
        registerPageObjects.clickRegisterButton();

        Assert.assertEquals(registerPageObjects.getEmailErrorMessage(),"Wrong email");
    }

    @Test
    public void Register_03_Success() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();

        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox(password);
        registerPageObjects.clickRegisterButton();

        Assert.assertEquals(registerPageObjects.getRegisterSuccessMessage(),"Your registration completed");
    }

    @Test
    public void Register_04_Existing_Email() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();

        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox(password);
        registerPageObjects.clickRegisterButton();

        Assert.assertEquals(registerPageObjects.getExistingEmailErrorMessage(),"The specified email already exists");
    }

    @Test
    public void Register_05_PW_Less_Than_Six() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();

        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox("1234");
        registerPageObjects.inputToConfirmPasswordTextbox("1234");
        registerPageObjects.clickRegisterButton();

        Assert.assertEquals(registerPageObjects.getPasswordErrorMessage(),"Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_06_ConfirmPW_Wrong() {
        homePageObjects = new HomePageObjects(driver);
        homePageObjects.clickRegisterLink();

        registerPageObjects = new RegisterPageObjects(driver);
        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(emailAddress);
        registerPageObjects.inputToPasswordTextbox(password);
        registerPageObjects.inputToConfirmPasswordTextbox("1234567890");
        registerPageObjects.clickRegisterButton();

        Assert.assertEquals(registerPageObjects.getConfirmPasswordErrorMessage(),"The password and confirmation password do not match.");
    }

    public int generateRandomNumber(){
        Random random= new Random();
        return random.nextInt(9999);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
