package airlines;

import airlines.pojos.Airline;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.DataTypeEnum;

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
        payload.put("name", RandomDataGenerator.getRandomFor(DataTypeEnum.COMPANYNAME));
        payload.put("country", RandomDataGenerator.getRandomFor(DataTypeEnum.COUNTRY));
        payload.put("logo", RandomDataGenerator.getRandomAlphabetic(20) + ".png");
        payload.put("slogan", RandomDataGenerator.getRandomFor(DataTypeEnum.SLOGAN));
        payload.put("head_quaters", RandomDataGenerator.getRandomFor(DataTypeEnum.CITY));
        payload.put("website", RandomDataGenerator.getRandomWebsiteName(10));
        payload.put("established", RandomDataGenerator.getNumberBetween(1900, DateUtils.getCurrentYear()));

        return payload;
    }

    public static Airline getPayloadPojo_CreateAirline(){
        return Airline
                .builder()
                .id(Long.parseLong(RandomDataGenerator.getRandomNumber(10)))
                .name(RandomDataGenerator.getRandomFor(DataTypeEnum.COMPANYNAME))
                .country(RandomDataGenerator.getRandomFor(DataTypeEnum.COUNTRY))
                .logo(RandomDataGenerator.getRandomAlphabetic(20) + ".png")
                .slogan(RandomDataGenerator.getRandomFor(DataTypeEnum.SLOGAN))
                .head_quaters(RandomDataGenerator.getRandomFor(DataTypeEnum.CITY))
                .website(RandomDataGenerator.getRandomWebsiteName(10))
                .established(Integer.parseInt(RandomDataGenerator.getNumberBetween(1900, DateUtils.getCurrentYear())))
                .build();
    }

    public static Airline getPayloadPojo_CreateAirline(long id, String name, String country, String logo, String slogan, String headquarters, String website, int established){
        return Airline
                .builder()
                .id(id)
                .name(name)
                .country(country)
                .logo(logo)
                .slogan(slogan)
                .head_quaters(headquarters)
                .website(website)
                .established(established)
                .build();
    }
}
