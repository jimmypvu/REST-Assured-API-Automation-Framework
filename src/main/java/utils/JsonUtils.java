package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String path = System.getProperty("user.dir") + "/src/test/resources/";

    public static Map<String, String> getJsonDataAsMap(String jsonFileName) throws IOException {
        String jsonFilePath = path + jsonFileName;

        Map<String, String> data = objectMapper.readValue(new File(jsonFilePath), new TypeReference<>(){});

        return data;
    }
}
