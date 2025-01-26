package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static void setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            //setting chromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Open browser maximized
            options.addArguments("--incognito");      // Open browser in incognito mode
            options.addArguments("--disable-notifications"); // Disable notifications
            //options.addArguments("--headless");       // Run in headless mode (optional)
            options.addArguments("--disable-extensions");    // Disable extensions
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Disable automation message

            driver.set(new ChromeDriver(options));
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
    }


    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }


    /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser maximized
        options.addArguments("--incognito");      // Open browser in incognito mode
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--headless");       // Run in headless mode (optional)
        options.addArguments("--disable-extensions");    // Disable extensions
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Disable automation message
*/
}
