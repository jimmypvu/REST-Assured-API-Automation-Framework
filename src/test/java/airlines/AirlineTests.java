package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class AirlineTests extends AirlineAPIs {

    @Test(description = "Test correct method: POST - Create airline data.")
    public void createAirline() {
        Map<String, Object> payload = Payloads.getPayloadMap_CreateAirline("984916890", "Vuvu Airways", "Dac Bietnam", "https://static.wikia.nocookie.net/onepunchman/images/d/d5/Mumen_Rider_Anime_Profile.png/revision/latest?cb=20191116234148", "Lemme get the xe lua!", "Little Saigon, CA, United States", "https://vuvuairwaysintl.com", "1990");

        Response res = createAirline(payload);

        Assert.assertEquals(res.statusCode(), 200);
    }
}
