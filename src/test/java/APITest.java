import io.cloudbeat.junit.CbJunitExtension;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.HashMap;

@ExtendWith({CbJunitExtension.class})
public class APITest {

    private String baseUrl = "https://apiqa.jifiti.com/";



    @Test
    public void APIJIFITITryTTest() throws IOException {

        //ChromeDriver driver = new ChromeDriver("emepcp-e6fLGyeWwW8LG_P9rUwrS1EcNBxGqpKdRHxU", new ChromeOptions(), "JIFITIAllTests", "yyyy");





        //driver.report().step("test API start");

        RestAssured.config = ConfigFactory.getDefaultConfig();
        // Declare variables
        String url = "applications/v2/Prequal";

        HashMap<String, Object> map = new HashMap<>();

        HashMap<String, String> mapCust = new HashMap<>();
        mapCust.put("FirstName", "TestUser" );
        mapCust.put("LastName", "FullApproved" );
        mapCust.put("Email", "tzvig@jifiti.com" );
        mapCust.put("MobilePhoneNumber", "9712700448" );
        mapCust.put("DateOfBirth", "1980-05-05T00:00:00" );
        mapCust.put("CustomerGovernmentId", "560434890" );
        mapCust.put("Last4SSN", null );
        map.put("Customer", mapCust);


        HashMap<String, String> addressMap = new HashMap<>();
        addressMap.put("AddressLine1", "12 st." );
        addressMap.put("AddressLine2", "8000" );
        addressMap.put("City", "City" );
        addressMap.put("State", "MI" );
        addressMap.put("Country", "USA" );
        addressMap.put("PostalCode", "12345" );
        map.put("Address", addressMap);

        map.put("AnnualIncome", 200000);
        map.put("RequestedAmount", 2500);
        map.put("SourceChannel", 76);
        map.put("PartnerRequestId",null);
        map.put("RequestDateTime", "2021-05-03T12:48:11.7978112+03:00");
        map.put("ProductType", 1);
        map.put("MerchantId", "4829ab42856b44cca863291dcd8553ce");
        map.put("LenderId", "vxm8wxono74ewf9ulbltovn7swk5n4to");
        map.put("StoreId", "location 12");
        map.put("MerchantCountryCode", 840);

        HashMap<String, String> previousAddressMap = new HashMap<>();
        previousAddressMap.put("AddressLine1", "5734 NAXKM USQC AVE UNIT 102");
        previousAddressMap.put("AddressLine2", "Address");
        previousAddressMap.put("City", "LAS VEGAS");
        previousAddressMap.put("State", "NV");
        previousAddressMap.put("Country", "USA");
        previousAddressMap.put("PostalCode", "89149");
        map.put("PreviousAddress", previousAddressMap);

        HashMap<String, String> shippingAddressMap = new HashMap<>();
        previousAddressMap.put("AddressLine1", "12 st.");
        previousAddressMap.put("AddressLine2", "Address");
        previousAddressMap.put("City", "City");
        previousAddressMap.put("State", "MI");
        previousAddressMap.put("Country", "USA");
        previousAddressMap.put("PostalCode", "12345");
        map.put("ShippingAddress", shippingAddressMap);

        map.put("OfferCode", "123");
        map.put("NotificationAPIURL", "https://webhook.site/3f93a178-3fea-4b77-8dc7-4ea39469e872/Prequal-Arlington");
        map.put("CallbackURL", "https://www.arlingtonfinancial2.com/?prequal=GreenBuildingSupply");
        map.put("ResidentialStatus", 10);

        // Put request bade url
        RestAssured.baseURI = baseUrl;
        //ReportManager.getInstance().currentTest().log(Status.INFO, "test running on: "+baseUrl);
        // Create request
        RequestSpecification request = RestAssured.given();

        // Put headers
        request.header("Content-Type", "application/json");
        request.header("token", "b49d66246555479bb09109e8d06e02ef");

        // Put body
        request.body(map);

        // Send request as POST request
        Response res = request.request(Method.POST, url);

        JsonPath jsonBody = res.jsonPath();
        System.out.println("status code = " + String.valueOf(res.getStatusCode()) + " status value = " +  jsonBody.get("DecisionStatus"));


        //driver.report().step("status request is " +String.valueOf(res.getStatusCode()), res.getStatusCode() == 200);
        Assertions.assertEquals("the value is OK", jsonBody.get("DecisionStatus"), "Accepted");
    }
}
