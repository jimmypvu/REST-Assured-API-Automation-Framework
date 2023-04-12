package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import restutils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    private static String baseURI = (String)BaseTest.jsonData.get("airlinesBaseUri");


    public Response createAirline(Object payload /*Map<String, Object> payload*/){
        String endpoint = baseURI + BaseTest.jsonData.get("createAirlinePath");

        Map<String, String> headers = new HashMap<>();

        return RestUtils.performPost(endpoint, payload, headers);
    }

}
