import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith({RunExtension.class})
public class SeleniumTest {
    @Test
    public void checkTitle1() throws Exception {
        DriverProvider.getWebDriver().get("https:\\www.google.com");

        new WebDriverWait(DriverProvider.getWebDriver(),10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("google");
            }
        });
    }

    @Test
    public void checkTitle2() throws Exception {
        DriverProvider.getWebDriver().get("https:\\www.google.com");

        new WebDriverWait(DriverProvider.getWebDriver(),10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.getTitle().toLowerCase().contains("yahoo");
            }
        });
    }

    @AfterAll
    private static void AfterAll() throws Exception {
        DriverProvider.getWebDriver().close();
    }
}
