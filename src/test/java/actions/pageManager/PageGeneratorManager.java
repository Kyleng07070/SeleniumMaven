package actions.pageManager;

import actions.pageObjects.HomePageObjects;
import actions.pageObjects.LoginPageObjects;
import actions.pageObjects.RegisterPageObjects;
import actions.pageObjects.myAccountPageObjects.AddressPageObjects;
import actions.pageObjects.myAccountPageObjects.CustomerInfoPageObjects;
import actions.pageObjects.myAccountPageObjects.MyProductReviewPageObjects;
import actions.pageObjects.myAccountPageObjects.RewardPointPageObjects;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    @Contract("_ -> new")
    public static @NotNull HomePageObjects getHomePage(WebDriver driver) {
        return new HomePageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull LoginPageObjects getLoginPage(WebDriver driver) {
        return new LoginPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull RegisterPageObjects getRegisterPage(WebDriver driver) {
        return new RegisterPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull CustomerInfoPageObjects getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull AddressPageObjects getAddressPage(WebDriver driver) {
        return new AddressPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull MyProductReviewPageObjects getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull RewardPointPageObjects getRewardPointPage(WebDriver driver) {
        return new RewardPointPageObjects(driver);
    }
}
