package Selenium;

import helpers.DriverProvider;
import helpers.RunExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith({RunExtension.class})
public class SeleniumTest {
    @Test
    @Tag("success")
    public void successSeleniumTest() throws Exception {
        DriverProvider.getWebDriver().get("https:\\www.google.com");

        new WebDriverWait(DriverProvider.getWebDriver(),10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("google");
            }
        });
    }

    @Test
    @Tag("fail")
    public void failSeleniumTest() throws Exception {
        DriverProvider.getWebDriver().get("https:\\www.google.com");

        new WebDriverWait(DriverProvider.getWebDriver(),10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("yahoo");
            }
        });
    }

    @AfterAll
    private static void AfterAll() throws Exception {
        DriverProvider.getWebDriver().close();
    }
}
