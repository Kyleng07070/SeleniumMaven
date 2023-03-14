package actions.pageManager;

import actions.pageObjects.adminPages.AdminDashboardPageObjects;
import actions.pageObjects.adminPages.AdminLoginPageObjects;
import actions.pageObjects.userPages.HomePageObjects;
import actions.pageObjects.userPages.LoginPageObjects;
import actions.pageObjects.userPages.RegisterPageObjects;
import actions.pageObjects.userPages.myAccountPageObjects.*;

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

    @Contract("_ -> new")
    public static @NotNull OrdersPageObjects getOrdersPage(WebDriver driver) {
        return new OrdersPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull DownloadableProductsPageObjects getDownloadableProductsPage(
            WebDriver driver) {
        return new DownloadableProductsPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull AdminLoginPageObjects getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObjects(driver);
    }

    @Contract("_ -> new")
    public static @NotNull AdminDashboardPageObjects getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObjects(driver);
    }
}
