package testcases.nopcommerce.user;

import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.adminPages.AdminDashboardPageObjects;
import actions.pageObjects.adminPages.AdminLoginPageObjects;
import actions.pageObjects.userPages.HomePageObjects;
import actions.pageObjects.userPages.LoginPageObjects;
import actions.pageObjects.userPages.RegisterPageObjects;
import actions.pageObjects.userPages.myAccountPageObjects.CustomerInfoPageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User5SwitchRoles extends BaseTest {
    WebDriver driver;

    String userEmailAddress, userPassword;
    String adminEmailAddress, adminPassword;
    private HomePageObjects homePageObjects;
    private LoginPageObjects loginPageObjects;
    private CustomerInfoPageObjects customerInfoPageObjects;
    private AdminLoginPageObjects adminLoginPageObjects;
    private AdminDashboardPageObjects adminDashboardPageObjects;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        userEmailAddress = "Automation" + generateRandomNumber() + "@gmail.vn";
        String firstName = "Hung";
        String lastName = "Automation" + generateRandomNumber();
        userPassword = "12345678";

        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";

        homePageObjects = PageGeneratorManager.getHomePage(driver);
        RegisterPageObjects registerPageObjects = homePageObjects.clickRegisterLink();

        registerPageObjects.inputToFirstNameTextbox(firstName);
        registerPageObjects.inputToLastNameTextbox(lastName);
        registerPageObjects.inputToEmailTextbox(userEmailAddress);
        registerPageObjects.inputToPasswordTextbox(userPassword);
        registerPageObjects.inputToConfirmPasswordTextbox(userPassword);
        registerPageObjects.clickRegisterButton();
        loginPageObjects = homePageObjects.clickLoginLink();
        System.out.println(userEmailAddress);
    }

    @Test
    public void SwitchRole_01_UserLogin() {
        homePageObjects = loginPageObjects.userLogin(userEmailAddress, userPassword);
        Assert.assertTrue(homePageObjects.isMyAccountDisplay());

        customerInfoPageObjects = homePageObjects.clickMyAccountLink();
        homePageObjects = customerInfoPageObjects.userClickLogoutLink(driver);
    }

    @Test
    public void SwitchRole_02_AdminLogin() {
        homePageObjects.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);

        adminLoginPageObjects = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPageObjects =
                adminLoginPageObjects.adminLogin(adminEmailAddress, adminPassword);
        Assert.assertTrue(adminDashboardPageObjects.isHeaderDisplay());

        adminLoginPageObjects = adminDashboardPageObjects.adminClickLogoutLink(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
