package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restutils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AirlineTests {

    @Test
    public void createAirline() throws IOException {

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");

        Map<String, String > data = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        String endpoint = data.get("createAirlineEndpoint");

        Map<String, Object> payload = Payloads.getPayloadMap_CreateAirline("98491671", "Vuvu Airways", "Dac Bietnam", "https://static.wikia.nocookie.net/onepunchman/images/d/d5/Mumen_Rider_Anime_Profile.png/revision/latest?cb=20191116234148", "Lemme get the xe lua!", "Little Saigon, CA, United States", "https://google.com", "1990");

        Map<String, String> headers = new HashMap<>();

        Response res = RestUtils.performPost(endpoint, payload, headers);

        Assert.assertEquals(res.statusCode(), 200);
    }
}
