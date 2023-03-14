package actions.commons;

import actions.pageManager.PageGeneratorManager;
import actions.pageObjects.adminPages.AdminLoginPageObjects;
import actions.pageObjects.userPages.HomePageObjects;

import interfaces.pageUIs.userPageUIs.BaseSwitchPagesUI;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

public class BasePage {
    private final long longTimeOut = 30;
    private final long shortTimeout = 5;

    @Contract(value = " -> new", pure = true)
    public static @NotNull BasePage getBasePage() {
        return new BasePage();
    }
    // protected: cac ham chi co the dc goi khi xai extends
    // test cases user_001 (1 & 2) examples cho viec ko goi dc
    // test case user_001 3 examples cho viec goi dc khi xai extends
    public void openPageUrl(@NotNull WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    protected String getTitle(@NotNull WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentUrl(@NotNull WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSourceCode(@NotNull WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPage(@NotNull WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(@NotNull WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage(@NotNull WebDriver driver) {
        driver.navigate().refresh();
    }

    protected Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        // call wait for alert to present
        waitForAlertPresence(driver).accept();
    }

    protected void cancelAlert(WebDriver driver) {
        // call wait for alert to present
        waitForAlertPresence(driver).dismiss();
    }

    protected String getAlertText(WebDriver driver) {
        // call wait for alert to present
        return waitForAlertPresence(driver).getText();
    }

    protected void sendKeyToAlert(WebDriver driver, String textToSend) {
        // call wait for alert to present
        waitForAlertPresence(driver).sendKeys(textToSend);
    }

    protected void switchWindowByID(@NotNull WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    protected void switchWindowByTitle(@NotNull WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWindow = driver.getTitle();
            if (currentWindow.equals(title)) {
                break;
            }
        }
    }

    protected void closeAllWindowsExceptParent(@NotNull WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    //    @Contract(value = "_ -> new", pure = true)
    //    private @NotNull By getByXpath(String xpathLocator) {
    //        return By.xpath(xpathLocator);
    //    }

    @Contract(value = "_ -> new", pure = true)
    private @NotNull By getByLocator(@NotNull String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=")
                || locatorType.startsWith("ID=")
                || locatorType.startsWith("Id=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("name=")
                || locatorType.startsWith("NAME=")
                || locatorType.startsWith("Name=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("class=")
                || locatorType.startsWith("CLASS=")
                || locatorType.startsWith("Class=")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("css=")
                || locatorType.startsWith("CSS=")
                || locatorType.startsWith("Css=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=")
                || locatorType.startsWith("XPATH=")
                || locatorType.startsWith("Xpath=")
                || locatorType.startsWith("XPath=")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new InputMismatchException(
                    String.format("Locator [%s] type is invalid!", locatorType));
        }
        return by;
    }

    public String getDynamicXpath(@NotNull String dynamicLocator, String... params) {
        if (dynamicLocator.startsWith("xpath=")
                || dynamicLocator.startsWith("XPATH=")
                || dynamicLocator.startsWith("Xpath=")
                || dynamicLocator.startsWith("XPath=")) {
            dynamicLocator = String.format(dynamicLocator, (Object[]) params);
        }
        return dynamicLocator;
    }

    private WebElement getWebElement(@NotNull WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    private List<WebElement> getListOfWebElements(@NotNull WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    protected void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    protected void clickToElement(WebDriver driver, String locatorType, String dynamicValues) {
        getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
    }

    protected void sendKeyToElement(WebDriver driver, String locatorType, String keysToSend) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected void sendKeyToElement(
            WebDriver driver, String locatorType, String keysToSend, String dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText();
    }

    protected String getElementText(WebDriver driver, String locatorType, String dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
    }

    protected String getElementAttribute(
            WebDriver driver, String locatorType, String attributeName) {
        return getWebElement(driver, locatorType).getAttribute(attributeName);
    }

    protected String getElementAttribute(
            WebDriver driver, String locatorType, String attributeName, String dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))
                .getAttribute(attributeName);
    }

    protected String getElementCssValue(WebDriver driver, String locatorType, String cssName) {
        return getWebElement(driver, locatorType).getAttribute(cssName);
    }

    protected String getElementCssValue(
            WebDriver driver, String locatorType, String cssName, String dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))
                .getAttribute(cssName);
    }

    protected int getElementSize(WebDriver driver, String locatorType) {
        return getListOfWebElements(driver, locatorType).size();
    }

    protected int getElementSize(WebDriver driver, String locatorType, String dynamicValues) {
        return getListOfWebElements(driver, getDynamicXpath(locatorType, dynamicValues)).size();
    }

    protected String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    protected void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Drop-down list
    protected void selectItemInDefaultDropdown(
            WebDriver driver, String locatorType, String itemName) {
        Select select = new Select(getWebElement(driver, locatorType));
        select.selectByValue(itemName);
    }

    protected void selectItemInDefaultDropdown(
            WebDriver driver, String locatorType, String itemName, String dynamicValues) {
        Select select =
                new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
        select.selectByValue(itemName);
    }

    protected String getSelectedItemInDefaultDropdown(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.isMultiple();
    }

    protected void selectItemInCustomDropdown(
            WebDriver driver, String parentLocator, String itemLocator, String expectedItem) {
        // Wait until this element to be click-able
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(parentLocator)));
        // Move to element to click to open the drop-down list
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, parentLocator));
        sleepInSecond(3);
        // Wait until all the options/items in drop-down list to be presented
        explicitWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(itemLocator)));
        // Store all options/items into a list of web-element
        List<WebElement> allItems = getListOfWebElements(driver, itemLocator);
        for (WebElement item : allItems) {
            if (item.getText()
                    .trim()
                    .equals(expectedItem)) { // trim() is used to remove space in the front/back of
                // text
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(2);
                item.click();
                sleepInSecond(2);
                break;
            }
        }
    }

    protected void selectItemInEditableDropdown(
            WebDriver driver, String editableLocator, String itemLocator, String expectedItem) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(editableLocator)));
        getWebElement(driver, editableLocator).clear();
        sleepInSecond(1);
        getWebElement(driver, editableLocator).sendKeys(expectedItem);
        List<WebElement> allItems = getListOfWebElements(driver, itemLocator);

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(2);

                explicitWait.until(ExpectedConditions.elementToBeClickable(item));
                jsExecutor.executeScript("arguments[0].click();", item);

                sleepInSecond(2);
                break;
            }
        }
    }

    protected void selectMultipleItemsInDropdown(
            WebDriver driver, String parentLocator, String itemLocator, String[] expectedItem) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(parentLocator)));
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, parentLocator));
        sleepInSecond(3);
        explicitWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(itemLocator)));
        List<WebElement> allItems = getListOfWebElements(driver, itemLocator);

        for (WebElement childItem : allItems) {
            String itemName = childItem.getText();
            for (String item : expectedItem) {
                if (itemName.trim().equals(item)) {
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childItem);
                    sleepInSecond(2);

                    jsExecutor.executeScript("arguments[0].click();", childItem);
                    sleepInSecond(2);

                    List<WebElement> selectedItem =
                            driver.findElements(By.xpath("//li[@class='selected']//input"));
                    if (expectedItem.length == selectedItem.size()) {
                        break;
                    }
                }
            }
        }
    }

    // Check-box - Radio
    protected void checkToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void checkToDefaultCheckBoxRadio(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckBox(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckBox(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isElementDisplay(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isDisplayed();
    }

    protected boolean isElementDisplay(WebDriver driver, String locatorType, String dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
    }

    protected boolean isElementEnable(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isEnabled();
    }

    protected boolean isElementEnable(WebDriver driver, String locatorType, String dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isSelected();
    }

    protected boolean isElementSelected(
            WebDriver driver, String locatorType, String dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
    }

    // Frame - iFrame
    protected void switchToFrameIframe(@NotNull WebDriver driver, String locatorType) {
        driver.switchTo().frame(getWebElement(driver, locatorType));
    }

    protected void switchToDefaultContent(@NotNull WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Mouse - keyboard
    protected void hoverMouseToElement(WebDriver driver, String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locatorType)).perform();
    }

    // Javascript executor
    protected void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void highlightElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locatorType);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
    }

    protected void clickToElementByJS(WebDriver driver, String locatorType, String dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "arguments[0].click();",
                getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
    }

    protected WebElement getShadowDOM(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (WebElement)
                jsExecutor.executeScript(
                        "return arguments[0].shadowRoot;", getWebElement(driver, locatorType));
    }

    protected void scrollToElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
    }

    protected void removeAttributeInDOM(
            WebDriver driver, String locatorType, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(driver, locatorType));
    }

    protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad =
                driver12 -> {
                    try {
                        return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                    } catch (Exception e) {
                        return true;
                    }
                };

        ExpectedCondition<Boolean> jsLoad =
                driver1 ->
                        jsExecutor
                                .executeScript("return document.readyState")
                                .toString()
                                .equals("complete");

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    protected String getElementValidationMessage(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String)
                jsExecutor.executeScript(
                        "return arguments[0].validationMessage;",
                        getWebElement(driver, locatorType));
    }

    protected boolean isImageLoaded(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status =
                (boolean)
                        jsExecutor.executeScript(
                                "return arguments[0].complete && typeof arguments[0].naturalWidth"
                                        + " != \"undefined\" && arguments[0].naturalWidth > 0",
                                getWebElement(driver, locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    // Wait
    protected void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    protected void waitForElementVisible(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    protected void waitForAllElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
    }

    protected void waitForAllElementVisible(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    protected void waitForElementInvisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
    }

    protected void waitForElementInvisible(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    protected void waitForAllElementInvisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.invisibilityOfAllElements(
                        getListOfWebElements(driver, locatorType)));
    }

    protected void waitForAllElementInvisible(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.invisibilityOfAllElements(
                        getListOfWebElements(driver, getDynamicXpath(locatorType, dynamicValues))));
    }

    protected void waitForElementClickAble(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    protected void waitForElementClickAble(
            WebDriver driver, String locatorType, String dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    public HomePageObjects userClickLogoutLink(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.USER_LOGOUT_LINK);
        clickToElement(driver, BaseSwitchPagesUI.USER_LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public AdminLoginPageObjects adminClickLogoutLink(WebDriver driver) {
        waitForElementVisible(driver, BaseSwitchPagesUI.ADMIN_LOGOUT_LINK);
        clickToElement(driver, BaseSwitchPagesUI.ADMIN_LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }
}
