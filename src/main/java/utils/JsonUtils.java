package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String path = System.getProperty("user.dir") + "/src/test/resources/";

    public static Map<String, Object> getJsonDataAsMap(String jsonFilepath) throws IOException {
        String fullJsonPath = path + jsonFilepath;
        Map<String, Object> data = objectMapper.readValue(new File(fullJsonPath), new TypeReference<>(){});

        return data;
    }
}
