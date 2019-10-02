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
        String browserName = System.getProperty("browserName");
        if ("chrome".equalsIgnoreCase(browserName)){
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
            return new ChromeDriver();
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
