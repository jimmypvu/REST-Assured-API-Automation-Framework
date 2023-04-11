package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class AirlineTests extends AirlineAPIs {

    @Test(description = "Test correct method: POST - Create airline data.")
    public void createAirline() {
        Map<String, Object> payload = Payloads.getPayloadMap_CreateAirline();

        Response res = createAirline(payload);

        Assert.assertEquals(res.statusCode(), 200);
    }
}
