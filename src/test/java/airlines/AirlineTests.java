package airlines;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class AirlineTests {

    @Test
    public void createAirline(){

        String endpoint = "https://api.instantwebtools.net/v1/airlines";
        String reqBody = "{\n" +
                "    \"id\": 7651576,\n" +
                "    \"name\": \"Vuvu Airways\",\n" +
                "    \"country\": \"Dac Bietnam\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"Lemme get the xe lua!\",\n" +
                "    \"head_quaters\": \"Orange County, CA, United States\",\n" +
                "    \"website\": \"www.vuvuairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";
        Map<String, String> headers = new HashMap<>();

        Response res = RestUtils.performPost(endpoint, reqBody, headers);

        Assert.assertEquals(res.statusCode(), 200);
    }
}
