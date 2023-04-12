package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirlineTests extends AirlineAPIs {

    @Test(description = "Test correct method: POST - Create airline data")
    public void createAirline() {
//        Map<String, Object> payload = Payloads.getPayloadMap_CreateAirline();
//        Airline payload = Payloads.getPayloadPojo_CreateAirline();

        //new airline pojo with default values (no field values passed)
        Airline payload = new Airline();
        Response res = createAirline(payload);
        Assert.assertEquals(res.statusCode(), 200);
    }
}
