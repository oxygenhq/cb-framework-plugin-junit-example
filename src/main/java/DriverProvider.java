import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getWebDriver() throws Exception {
        if(driver == null) {
            driver = CreateWebDriver();
        }

        return driver;
    }

    private static WebDriver CreateWebDriver() throws Exception {
        String browserName = System.getProperty("browserName");
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
}
