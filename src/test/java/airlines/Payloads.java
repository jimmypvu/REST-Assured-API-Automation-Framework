package airlines;

import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getPayloadString_CreateAirline(String id, String name, String country, String logo, String slogan, String headquarters, String website, String established){

        String payload = "{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+headquarters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";

        return payload;
    }

    public static Map<String, Object> getPayloadMap_CreateAirline(String id, String name, String country, String logo, String slogan, String headquarters, String website, String established){

        Map<String, Object> payload = new HashMap<>();

        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", headquarters);
        payload.put("website", website);
        payload.put("established", established);

        return payload;
    }

    public static Map<String, Object> getPayloadMap_CreateAirline(){
        Map<String, Object> payload = new HashMap<>();

        payload.put("id", RandomDataGenerator.getRandomNumber(10));
        payload.put("name", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COMPANYNAME));
        payload.put("country", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY));
        payload.put("logo", RandomDataGenerator.getRandomAlphabetic(20) + ".png");
        payload.put("slogan", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.SLOGAN));
        payload.put("head_quaters", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITY));
        payload.put("website", RandomDataGenerator.getRandomWebsiteName(10));
        payload.put("established", RandomDataGenerator.getRandomNumberBetween(1900, DateUtils.getCurrentYear()));

        return payload;
    }
}
