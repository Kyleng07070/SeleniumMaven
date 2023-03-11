package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    // private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver(String browserName) {
        WebDriver driverBaseTest;
        switch (browserName) {
            case "firefox":
                // System.setProperty("webdriver.gecko.driver", projectPath +
                // "/browserDrivers/geckodriver-1");
                WebDriverManager.firefoxdriver().setup();
                driverBaseTest = new FirefoxDriver();
                break;
            case "h_firefox":
                {
                    // System.setProperty("webdriver.gecko.driver", projectPath +
                    // "/browserDrivers/geckodriver-1");
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("-headless");
                    options.addArguments("window-size=1920x1080");
                    driverBaseTest = new FirefoxDriver(options);
                    break;
                }
            case "chrome":
                // System.setProperty("webdriver.chrome.driver", projectPath +
                // "/browserDrivers/chromedriver-7");
                WebDriverManager.chromedriver().setup();
                driverBaseTest = new ChromeDriver();
                break;
            case "h_chrome":
                {
                    // System.setProperty("webdriver.chrome.driver", projectPath +
                    // "/browserDrivers/chromedriver-7");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("-headless");
                    options.addArguments("window-size=1920x1080");
                    driverBaseTest = new ChromeDriver(options);
                    break;
                }
            case "coccoc":
                {
                    WebDriverManager.chromedriver().driverVersion("copy version name").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary("file location in laptop");
                    driverBaseTest = new ChromeDriver(options);
                    break;
                }
            default:
                throw new RuntimeException("browserName invalid");
        }

        driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driverBaseTest.manage().window().maximize();
        driverBaseTest.get(GlobalConstants.USER_PAGE_URL);
        return driverBaseTest;
    }

    protected int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }
}
