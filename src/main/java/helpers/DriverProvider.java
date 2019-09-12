package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getWebDriver() throws Exception {
        if(driver == null) {
            reload();
        }

        return driver;
    }

    private static WebDriver createWebDriver() throws Exception {
        String browserName = "chrome";
        if ("chrome".equalsIgnoreCase(browserName)){
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            return new ChromeDriver(options);
        } else if ("ie".equalsIgnoreCase(browserName)) {
            return new InternetExplorerDriver();
        } else {
            throw new Exception("Invalid browserName: " + browserName);
        }
    }

    public static void reload() throws Exception {
        driver = createWebDriver();
    }
}
