package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataTypeNames dataTypeNames){
        switch(dataTypeNames){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case COUNTRY:
                return faker.address().country();
            case STATE:
                return faker.address().state();
            case CITY:
                return faker.address().city();
            case COMPANYNAME:
                return faker.company().name();
            case SLOGAN:
                return faker.company().catchPhrase();
            default:
                return "DataTypeNotValid";
        }
    }

    public static String getRandomNumber(int digits){
        return faker.number().digits(digits);
    }

    public static String getRandomNumberBetween(int min, int max){
        return String.valueOf(faker.number().numberBetween(min, max));
    }

    public static String getRandomAlphabetic(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomWebsiteName(int length){
        return "https://" + RandomDataGenerator.getRandomAlphabetic(10) + ".com";
    }


//    better to use enums instead of one method for each data type
//    public static String getRandomFirstName(){
//        return faker.name().firstName();
//    }
//
//    public static String getRandomLastName(){
//        return faker.name().lastName();
//    }
//
//    public static String getRandomFullName(){
//        return faker.name().fullName();
//    }
}
