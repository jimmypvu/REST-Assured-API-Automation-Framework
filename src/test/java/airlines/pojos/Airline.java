package airlines.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.DataTypeEnum;
import utils.DateUtils;
import utils.RandomDataGenerator;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Airline {
    @Builder.Default private CarrierType carrier_type = Arrays.stream(CarrierType.values()).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(new Random().nextInt(list.size()))));
    @Builder.Default private long id = Long.parseLong(RandomDataGenerator.getRandomNumber(10));
    @Builder.Default private String name = RandomDataGenerator.getRandomFor(DataTypeEnum.COMPANYNAME);
    @Builder.Default private String country = RandomDataGenerator.getRandomFor(DataTypeEnum.COUNTRY);
    @Builder.Default private String logo = RandomDataGenerator.getRandomAlphabetic(20) + ".png";
    @Builder.Default private String slogan = RandomDataGenerator.getRandomFor(DataTypeEnum.SLOGAN);
    @Builder.Default private String head_quaters = RandomDataGenerator.getRandomFor(DataTypeEnum.CITY);
    @Builder.Default private String website = RandomDataGenerator.getRandomWebsiteName(10);
    @Builder.Default private int established = Integer.parseInt(RandomDataGenerator.getNumberBetween(1900, DateUtils.getCurrentYear()));

//        new airline pojo with default values except name field is passed
//        Airline payload = new Airline().toBuilder().name("whoadereairways").build();
//        Airline payload = Airline.builder().name("airwayairlines").build();
}
