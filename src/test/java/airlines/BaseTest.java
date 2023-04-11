package airlines;

import org.testng.annotations.BeforeTest;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static Map<String, Object> jsonData;

    //static block automatically gets executed when class starts, can do it like this too instead of with annotations like we usually do
    static{
        String env = System.getProperty("env").equals("") || System.getProperty("env") == null ? "qa" : System.getProperty("env");

        try {
            jsonData = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @BeforeTest
//    public void setup() throws IOException {
//        String env = System.getProperty("env").equals("") || System.getProperty("env") == null ? "qa" : System.getProperty("env");
//        jsonData = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
//    }
}
