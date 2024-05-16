package com.cs461.group9.mybloombud;

import com.cs461.group9.mybloombud.plant.model.*;
import com.cs461.group9.mybloombud.plant.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Configuration
@Transactional
public class DataSeeder {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    private final PlantRepository plantRepository;

    private final LifecycleInfoRepository lifecycleInfoRepository;

    private final LightInfoRepository lightInfoRepository;

    private final TemperatureInfoRepository temperatureInfoRepository;

    private final HumidityInfoRepository humidityInfoRepository;

    private final WaterInfoRepository waterInfoRepository;

    public DataSeeder(
            PlantRepository plantRepository,
            LifecycleInfoRepository lifecycleInfoRepository,
            LightInfoRepository lightInfoRepository,
            TemperatureInfoRepository temperatureInfoRepository,
            HumidityInfoRepository humidityInfoRepository,
            WaterInfoRepository waterInfoRepository) {

        this.plantRepository = plantRepository;
        this.lifecycleInfoRepository = lifecycleInfoRepository;
        this.lightInfoRepository = lightInfoRepository;
        this.temperatureInfoRepository = temperatureInfoRepository;
        this.humidityInfoRepository = humidityInfoRepository;
        this.waterInfoRepository = waterInfoRepository;

    }

    @Bean
    public CommandLineRunner demoData() {

        return args -> {
          Connection connection = DriverManager.getConnection(
                  dbUrl,
                  dbUsername,
                  dbPassword
          );

            try {
                //check if there is data in the database
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM plant");
                ResultSet resultSet = preparedStatement.executeQuery();

                // if there is no data in database, seed test data into database
                Boolean dbHasData = resultSet.next();
                if (dbHasData) {
                    System.out.println("Test data already exists");
                } else {
                    System.out.println("Test data does not exist. Creating test data");
                    // insert test data

                    // insert life cycle data for all plants
                    LifecycleInfo annualLifecycleInfo = new LifecycleInfo(
                            null,
                            "Annual",
                            "This is an annual plant, which typically lives for 1 year",
                            null
                    );
                    annualLifecycleInfo = lifecycleInfoRepository.save(annualLifecycleInfo);


                    LifecycleInfo perennialLifecycleInfo = new LifecycleInfo(
                            null,
                            "Perennial",
                            "This is a perennial plant, which typically lives for more than 2 years",
                            null
                    );
                    perennialLifecycleInfo = lifecycleInfoRepository.save(perennialLifecycleInfo);

                    // insert rose
                    Plant rose = new Plant(
                            null,
                            "Rose",
                            "Their stems are usually prickly and their glossy, green leaves have toothed edges.",
                            "Many roses are fragrant, and some produce berry-like fruits called hips.",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/rose.jpg",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/redrose.sfb",
                            perennialLifecycleInfo,
                            null,
                            null,
                            null,
                            null
                    );
                    rose = plantRepository.save(rose);

                    LightInfo roseLightInfo = new LightInfo(
                            null,
                            "Full sun",
                            "Part sun, part shade",
                            30000.0,
                            100000.0,
                            rose
                    );
                    rose.setLightInfo(roseLightInfo);
                    roseLightInfo = lightInfoRepository.save(roseLightInfo);

                    TemperatureInfo roseTemperatureInfo = new TemperatureInfo(
                            null,
                            28.0,
                            32.0,
                            rose
                            );
                    rose.setTemperatureInfo(roseTemperatureInfo);
                    roseTemperatureInfo = temperatureInfoRepository.save(roseTemperatureInfo);

                    HumidityInfo roseHumidityInfo = new HumidityInfo(
                            null,
                            "Normal humidity need",
                            6,
                            60.0,
                            70.0,
                            rose
                    );
                    rose.setHumidityInfo(roseHumidityInfo);
                    roseHumidityInfo = humidityInfoRepository.save(roseHumidityInfo);

                    WaterInfo roseWaterInfo = new WaterInfo(
                            null,
                            9,
                            "Top layer should by dry",
                            rose
                            );
                    rose.setWaterInfo(roseWaterInfo);
                    roseWaterInfo = waterInfoRepository.save(roseWaterInfo);

                    rose = plantRepository.save(rose);

                    // insert dandelion
                    Plant dandelion = new Plant(
                            null,
                            "Dandelion",
                            "Bright yellow discs of tightly packed florets above a rosette of jaggedly toothed leaves are followed by fluffy white seed heads.",
                            "The name is derived from it's jaggedly toothed leaves were thought to resemble the teeth in a lion’s jaw.",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/dandelion.jpg",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/dandelion.sfb",
                            perennialLifecycleInfo,
                            null,
                            null,
                            null,
                            null
                    );
                    dandelion = plantRepository.save(dandelion);

                    LightInfo dandelionLightInfo = new LightInfo(
                            null,
                            "Full sun",
                            "Part sun, part shade",
                            30000.0,
                            100000.0,
                            dandelion
                    );
                    dandelion.setLightInfo(dandelionLightInfo);
                    dandelionLightInfo = lightInfoRepository.save(dandelionLightInfo);

                    var dandelionTemperatureInfo = new TemperatureInfo(
                            null,
                            10.0,
                            21.0,
                            dandelion
                    );
                    dandelion.setTemperatureInfo(dandelionTemperatureInfo);
                    dandelionTemperatureInfo = temperatureInfoRepository.save(dandelionTemperatureInfo);

                    var dandelionHumidityInfo = new HumidityInfo(
                            null,
                            "Normal humidity need",
                            6,
                            30.0,
                            50.0,
                            dandelion
                    );
                    dandelion.setHumidityInfo(dandelionHumidityInfo);
                    dandelionHumidityInfo = humidityInfoRepository.save(dandelionHumidityInfo);

                    var dandelionWaterInfo = new WaterInfo(
                            null,
                            9,
                            "Top layer should by dry",
                            dandelion
                    );
                    dandelion.setWaterInfo(dandelionWaterInfo);
                    dandelionWaterInfo = waterInfoRepository.save(dandelionWaterInfo);

                    dandelion = plantRepository.save(dandelion);

                    // insert daisy
                    Plant daisy = new Plant(
                            null,
                            "Daisy",
                            "Each flower has a rosette of small, thin white petals surrounding a bright yellow centre.",
                            "It is a common wild flower found growing in our garden lawns.",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/daisy.jpg",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/daisy.sfb",
                            perennialLifecycleInfo,
                            null,
                            null,
                            null,
                            null
                    );
                    daisy = plantRepository.save(daisy);

                    var daisyLightInfo = new LightInfo(
                            null,
                            "Part sun, part shade",
                            "Full sun",
                            10000.0,
                            25000.0,
                            daisy
                    );
                    daisy.setLightInfo(daisyLightInfo);
                    daisyLightInfo = lightInfoRepository.save(daisyLightInfo);

                    TemperatureInfo daisyTemperatureInfo = new TemperatureInfo(
                            null,
                            21.0,
                            24.0,
                            daisy
                    );
                    daisy.setTemperatureInfo(daisyTemperatureInfo);
                    daisyTemperatureInfo = temperatureInfoRepository.save(daisyTemperatureInfo);

                    HumidityInfo daisyHumidityInfo = new HumidityInfo(
                            null,
                            "Normal humidity need",
                            2,
                            60.0,
                            65.0,
                            daisy
                    );
                    daisy.setHumidityInfo(daisyHumidityInfo);
                    daisyHumidityInfo = humidityInfoRepository.save(daisyHumidityInfo);

                    WaterInfo daisyWaterInfo = new WaterInfo(
                            null,
                            2,
                            "Keep soil moist",
                            daisy
                    );
                    daisy.setWaterInfo(daisyWaterInfo);
                    daisyWaterInfo = waterInfoRepository.save(daisyWaterInfo);

                    daisy = plantRepository.save(daisy);

                    // insert sunflower
                    Plant sunflower = new Plant(
                            null,
                            "Sunflower",
                            "Each flower has a green erect stem covered in coarse hairs, growing on average around 2m tall.",
                            "Many roses are fragrant, and some produce berry-like fruits called hips.",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/sunflower.jpg",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/sunflower.jpg",
                            annualLifecycleInfo,
                            null,
                            null,
                            null,
                            null

                    );
                    sunflower = plantRepository.save(sunflower);

                    LightInfo sunflowerLightInfo = new LightInfo(
                            null,
                            "Full sun",
                            null,
                            30000.0,
                            100000.0,
                            sunflower
                    );
                    sunflower.setLightInfo(sunflowerLightInfo);
                    sunflowerLightInfo = lightInfoRepository.save(sunflowerLightInfo);

                    TemperatureInfo sunflowerTemperatureInfo = new TemperatureInfo(
                            null,
                            18.0,
                            25.0,
                            sunflower
                    );
                    sunflower.setTemperatureInfo(sunflowerTemperatureInfo);
                    sunflowerTemperatureInfo = temperatureInfoRepository.save(sunflowerTemperatureInfo);

                    HumidityInfo sunflowerHumidityInfo = new HumidityInfo(
                            null,
                            "Normal humidity need",
                            6,
                            8.0,
                            10.0,
                            sunflower
                    );
                    sunflower.setHumidityInfo(sunflowerHumidityInfo);
                    sunflowerHumidityInfo = humidityInfoRepository.save(sunflowerHumidityInfo);

                    WaterInfo sunflowerWaterInfo = new WaterInfo(
                            null,
                            4,
                            "Keep soil moist",
                            sunflower
                    );
                    sunflower.setWaterInfo(sunflowerWaterInfo);
                    sunflowerWaterInfo = waterInfoRepository.save(sunflowerWaterInfo);

                    sunflower = plantRepository.save(sunflower);

                    // insert tulip
                    Plant tulip = new Plant(
                            null,
                            "Tulip",
                            "A tulip plant has two or three thick, bluish green leaves. These are attached at the bottom of the stem. In most types of tulip each stem grows a single flower.",
                            "Plants that bloom in early spring. The flowers are cup-shaped and very colorful.",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/tulip.jpg",
                            "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/tulip.sfb",
                            perennialLifecycleInfo,
                            null,
                            null,
                            null,
                            null
                    );
                    tulip = plantRepository.save(tulip);

                    LightInfo tulipLightInfo = new LightInfo(
                            null,
                            "Full sun",
                            "Part sun, part shade",
                            30000.0,
                            100000.0,
                            tulip
                    );
                    tulip.setLightInfo(tulipLightInfo);
                    tulipLightInfo = lightInfoRepository.save(tulipLightInfo);

                    var tulipTemperatureInfo = new TemperatureInfo(
                            null,
                            5.0,
                            30.0,
                            tulip
                    );
                    tulip.setTemperatureInfo(tulipTemperatureInfo);
                    tulipTemperatureInfo = temperatureInfoRepository.save(tulipTemperatureInfo);

                    HumidityInfo tulipHumidityInfo = new HumidityInfo(
                            null,
                            "Normal humidity need",
                            6,
                            50.0,
                            70.0,
                            tulip
                    );
                    tulip.setHumidityInfo(tulipHumidityInfo);
                    tulipHumidityInfo = humidityInfoRepository.save(tulipHumidityInfo);

                    WaterInfo tulipWaterInfo = new WaterInfo(
                            null,
                            9,
                            "Top layer should be dry",
                            tulip
                    );
                    tulip.setWaterInfo(tulipWaterInfo);
                    tulipWaterInfo = waterInfoRepository.save(tulipWaterInfo);

                    tulip = plantRepository.save(tulip);

                    System.out.println("Test data has finished creating");
                }
            } catch (Exception exception) {
              System.out.println("Exception occured: " + exception);
          }
        };
    }


}
