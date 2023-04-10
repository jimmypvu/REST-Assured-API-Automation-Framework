package airlines;

import org.testng.annotations.BeforeMethod;
import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class BaseTest {
    public static Map<String, Object> jsonData;

//    @BeforeMethod
//    public void setup() throws IOException {
//        String env = System.getProperty("env").equals("") || System.getProperty("env") == null ? "qa" : System.getProperty("env");
//        jsonData = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
//    }

    //static block automatically gets executed when class starts, can do it like this too instead of with annotations
    //awk but let's try it this way lol
    static{
        String env = System.getProperty("env").equals("") || System.getProperty("env") == null ? "qa" : System.getProperty("env");

        try {
            jsonData = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
