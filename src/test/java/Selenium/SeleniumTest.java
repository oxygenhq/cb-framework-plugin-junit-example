package Selenium;

import io.cloudbeat.junit.CbExtension;
import io.cloudbeat.junit.CbJunit;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith({CbExtension.class})
public class SeleniumTest extends CbJunit {

    public SeleniumTest() throws Exception {
        System.out.println("Construct");
        WebDriver driver = createWebDriverBasedOnCbCapabilities();
        setWebDriver(driver);
    }

    @Test
    @Tag("success")
    public void successSeleniumTest(TestInfo testInfo) throws Exception {
        driver.get("https:\\www.google.com");
        startStep("123");
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("google"));
        endStep("123");
    }

    @Test
    @Tag("fail")
    public void failSeleniumTest() throws Exception {
        driver.get("https:\\www.google.com");
        Assertions.assertTrue(!driver.getTitle().toLowerCase().contains("google"));
    }
}
