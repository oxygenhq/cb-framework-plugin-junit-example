package Selenium;

import io.cloudbeat.junit.CbJunitExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.hasProperty;

@ExtendWith({CbJunitExtension.class})
public class SeleniumTest {

    private String homeUrl = "http://automationpractice.com/index.php";
    private WebDriver driver;

    public SeleniumTest() {

    }

    @BeforeEach
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = CbJunitExtension.createWebDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.close();
            this.driver = null;
        }
    }

    @Test
    @Tag("success")
    public void successSeleniumTest() throws Exception {
        driver.get("https:\\www.google.com");
        CbJunitExtension.startStep("123");
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("google"));
        CbJunitExtension.endLastStep();
    }

    @Test
    @Tag("fail")
    public void failSeleniumTest() throws Exception {
        CbJunitExtension.step("Open Google homepage", () -> {
            driver.get("https:\\www.google.com");
            CbJunitExtension.step("Assert page title", () -> {
                Assertions.assertTrue(!driver.getTitle().toLowerCase().contains("google"));
            });
        });

    }
/*
    @Test
    @Tag("API")
    @Tag("Sanity")
    public void weatherApiTest() {
        given()
                .when()
                .get("https://api.weather.gov/points/39.7456,-97.0892")
                .then()
                .statusCode(200)
                .and()
                .body("geometry", hasProperty("type"));
        //body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }
*/
    @Test
    @Tag("success")
    @Tag("purchase")
    public void purchaseDress() {
        CbJunitExtension.startStep("Open the web site");
        driver.navigate().to(homeUrl);
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Dresses");
        driver.findElement(By.linkText("DRESSES")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Size");
        driver.findElement(By.id("layered_category_11")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Color");
        driver.findElement(By.linkText("Yellow (3)"));
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Range");
        driver.findElement(By.id("layered_id_attribute_group_16")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Open Specials");
        driver.findElement(By.xpath("//div[@id='special_block_right']/div/div/a/span")).click();
        CbJunitExtension.endLastStep();
    }

    @Test
    @Tag("success")
    @Tag("purchase")
    public void purchaseTShirt() {

        CbJunitExtension.startStep("Open the web site");
        driver.navigate().to(homeUrl);
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select T-SHIRTS");
        driver.findElement(By.linkText("T-SHIRTS")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Filter S");
        driver.findElement(By.id("layered_id_attribute_group_1")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Orange");
        driver.findElement(By.linkText("Orange (1)")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Cotton");
        driver.findElement(By.id("layered_id_attribute_group_13"));
        driver.findElement(By.id("layered_id_feature_5"));
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Open Specials");
        driver.findElement(By.xpath("//div[@id='special_block_right']/div/div/a/span")).click();
        CbJunitExtension.endLastStep();
    }

    @Test
    @Tag("fail")
    public void failPurchaseDress() {
        CbJunitExtension.startStep("Open the web site");
        driver.navigate().to(homeUrl);
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Dresses");
        driver.findElement(By.linkText("DRESSES")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Size");
        driver.findElement(By.id("layered_category_11")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Color");
        driver.findElement(By.linkText("Yellow (3)"));
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Range");
        driver.findElement(By.id("layered_id_attribute_group_116")).click();
        CbJunitExtension.endLastStep();
    }

    @Test
    @Tag("success")
    @Tag("purchase")
    public void purchaseWomenClothing() {
        CbJunitExtension.startStep("Open the web site");
        driver.navigate().to(homeUrl);
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Women clothing");
        driver.findElement(By.linkText("WOMEN")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Tops");
        driver.findElement(By.id("layered_category_4")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Black");
        driver.findElement(By.linkText("Black (2)")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Select Cotton");
        driver.findElement(By.id("layered_id_feature_5")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Open Specials");
        driver.findElement(By.xpath("//div[@id='special_block_right']/div/div/a/span")).click();
        CbJunitExtension.endLastStep();
    }

    @Test
    @Tag("success")
    public void addToCartAndCheckout() throws InterruptedException {
        CbJunitExtension.step("Open the web site", () ->{
            driver.navigate().to(homeUrl);
            // maximize browser window to omit screen resolution related issues
            driver.manage().window().maximize();
        });

        CbJunitExtension.startStep("Select a T-Shirt");

        CbJunitExtension.startStep("Click on T-SHIRTS menu");
        driver.findElement(By.linkText("T-SHIRTS")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Find and select a first t-shirt in the list");
        List<WebElement> tshirtsList = driver.findElements(By.cssSelector(".product-image-container > .product_img_link"));
        Assertions.assertTrue(tshirtsList.size() > 0, "T-Shirts list must not be empty");
        //driver.findElement(By.xpath("(//div[@id='center_column']/ul/li/div/div[2]/div[2]/a/span)[1]")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Click on the first t-shirt");
        tshirtsList.get(0).click();
        CbJunitExtension.endLastStep();

        // end Select a T-Shirt parent step
        CbJunitExtension.endLastStep();

        CbJunitExtension.step("Add to cart", () -> {
            driver.findElement(By.name("Submit")).click();
            //driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span")).click();
        });

        CbJunitExtension.step("Assert success message popup", () -> {
            WebElement addToCartSuccessMsgElm = driver.findElement(By.cssSelector(".layer_cart_product h2"));
            // wait for success popup to appear
            (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOf(addToCartSuccessMsgElm));
            // make sure the popup appeared after 60 sec max
            Assertions.assertTrue(addToCartSuccessMsgElm.isDisplayed(), "Popup with successfully added message must be displayed");
            Assertions.assertEquals(addToCartSuccessMsgElm.getText(), "Product successfully added to your shopping cart");
        });

        CbJunitExtension.step("Assert cart total is $18.51", () -> {
            // assert the current shopping cart sum
            WebElement currentTotalElm = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']"));
            Assertions.assertEquals(currentTotalElm.getText(), "$18.51");
        });

        CbJunitExtension.startStep("Click on Proceed to Checkout button");
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        CbJunitExtension.endLastStep();

        // by now, we suppose to be on Shopping Cart Summary page
        CbJunitExtension.step("Checkout process", () -> {
            CbJunitExtension.step("Assert that the current page is Shopping Cart Summary", () -> {
                WebElement cartTitleElm = driver.findElement(By.id("cart_title"));
                Assertions.assertTrue(cartTitleElm.getText().contains("SHOPPING-CART SUMMARY"), "Page title must contain 'SHOPPING-CART SUMMARY'");
            });

            // If we refer to "Proceed to checkout" button using its title, then we will get ElementNotInteractableException
            // as multiple elements on the page match this criteria. Thus, we will use more precise css name-based xpath instead.
            driver.findElement(By.xpath("//a[contains(@class, 'standard-checkout')]")).click();
            //driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

            CbJunitExtension.step("Login with pre-registered user", () -> {
                //driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
                driver.findElement(By.id("email")).sendKeys("erandd@yahoo.com");
                driver.findElement(By.id("passwd")).sendKeys("eran1234");
                driver.findElement(By.name("SubmitLogin")).click();
            });

            CbJunitExtension.step("Login with pre-registered user", () -> {
                CbJunitExtension.step("Verify shipping", () -> {
                    driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
                    driver.findElement(By.id("cgv")).click();
                    driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
                });

                CbJunitExtension.step("Verify payment", () -> {
                    driver.findElement(By.xpath("(//div[@id='HOOK_PAYMENT']/div/div/p/a/span)[1]")).click();
                    driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
                    Assertions.assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText(), "ORDER CONFIRMATION");
                });
            });
        });
    }

    @Test
    @Tag("fail")
    public void addToCartFail() throws InterruptedException {
        CbJunitExtension.startStep("Open web site");
        driver.navigate().to(homeUrl);
        CbJunitExtension.endLastStep();

        CbJunitExtension.step("Purchase T shirt", () -> {
            CbJunitExtension.startStep("Select T shirts");
            driver.findElement(By.linkText("T-SHIRTS")).click();
            CbJunitExtension.endLastStep();

            CbJunitExtension.startStep("Click on T shirt");
            driver.findElement(By.xpath("(//div[@id='center_column']/ul/li/div/div[2]/div[2]/a/span)[1]")).click();
            CbJunitExtension.endLastStep();
        });

        CbJunitExtension.startStep("Add to cart");
        driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Change quantity to 2");
        driver.findElement(By.xpath("//a[2]/span/i")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Verify price for 2 objects");
        synchronized (driver)
        {
            driver.wait(2000);
        }
        Assertions.assertEquals(driver.findElement(By.id("total_price")).getText(), "$36.02");
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Insert Personal details");
        driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
        driver.findElement(By.id("email")).sendKeys("erandd@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("eran1234");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Verify Shipping");
        driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
        CbJunitExtension.endLastStep();

        CbJunitExtension.startStep("Verify Payment");
        driver.findElement(By.xpath("(//div[@id='HOOK_PAYMENT']/div/div/p/a/span)[1]")).click();
        driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText(), "ORDER CONFIRMATION");
        CbJunitExtension.endLastStep();
    }
}
