package airlines;

import io.restassured.response.Response;
import restutils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String, Object> payload){
        String endpoint = (String) BaseTest.jsonData.get("createAirlineEndpoint");

        Map<String, String> headers = new HashMap<>();

        return RestUtils.performPost(endpoint, payload, headers);
    }
}
