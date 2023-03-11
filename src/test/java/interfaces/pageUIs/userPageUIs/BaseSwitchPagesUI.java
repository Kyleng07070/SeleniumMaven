package interfaces.pageUIs.userPageUIs;
// Only apply for pages that can be switched from both sides.
public class BaseSwitchPagesUI {
    public static final String ADDRESS_LINK =
            "//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
    public static final String MY_PRODUCT_REVIEW_LINK =
            "//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";
    public static final String REWARD_POINT_LINK =
            "//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";
    public static final String CUSTOMER_INFO_LINK =
            "//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";
    public static final String USER_LOGOUT_LINK = "//a[@class='ico-logout']";
    public static final String ADMIN_LOGOUT_LINK = "//a[text()='Logout']";
}
