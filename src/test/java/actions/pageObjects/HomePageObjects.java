package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObjects extends BasePage {
    private final WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void clickRegisterLink(){
        waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }
}
