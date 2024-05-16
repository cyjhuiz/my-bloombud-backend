package com.cs461.group9.mybloombud.plant.service;

import com.cs461.group9.mybloombud.exception.NotFoundException;
import com.cs461.group9.mybloombud.plant.model.*;
import com.cs461.group9.mybloombud.plant.repository.PlantRepository;
import com.cs461.group9.mybloombud.plant.repository.PlantViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    private final PlantViewRepository plantViewRepository;

    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository, PlantViewRepository plantViewRepository) {
        this.plantRepository = plantRepository;
        this.plantViewRepository = plantViewRepository;
    }

    public ArrayList<PlantView> getPlants(String name) {
        ArrayList<PlantView> plants;
        if (name == null) {
            plants = plantViewRepository.findAllByOrderByNameAsc();
        } else {
            plants = plantViewRepository.findAllByNameContainingIgnoreCaseOrderByNameAsc(name);
        }

        return plants;
    }

    public Plant getPlantByPlantId(Integer plantId) {
        Plant plant = plantRepository.findPlantByPlantId(plantId);
        if (plant == null) {
            throw new NotFoundException("Plant with id " + plantId + " not found");
        }
        return plant;
    }

    public PlantRecommendation createPlantAnalysis(PlantDetails plantDetails) {
        Plant plant = plantRepository.findFirstByName(plantDetails.getName());

        return computePlantRecommendation(
                plant,
                plantDetails
        );
    }

    public PlantRecommendation computePlantRecommendation(Plant plant, PlantDetails plantDetails) {
        // light computation
        Recommendation lightRecommendation;
        if (plantDetails.getLight() < plant.getLightInfo().getMinValue()) {
            lightRecommendation = new Recommendation(
                    "Current lighting level is too dark.",
                    "Try readjusting the plant to a bright window under direct sunlight or use a grow light instead."
            );
        } else if (plantDetails.getLight() > plant.getLightInfo().getMaxValue()) {
            lightRecommendation = new Recommendation(
                    "Current lighting level is too bright.",
                    "Try placing the plant at a darker window under indirect sunlight, possibly behind another indoor plant or curtain."
            );
        } else {
            lightRecommendation = new Recommendation(
                    "Current lighting level is optimal.",
                    "No further adjustment is needed."
            );
        }

        // temperature computation here
        Recommendation temperatureRecommendation;
        if (plantDetails.getTemperature() < plant.getTemperatureInfo().getMinValue()) {
            temperatureRecommendation = new Recommendation(
                    "Current temperature is too cold.",
                    "Try keeping the plant outdoors or near an open window."
            );
        } else if (plantDetails.getTemperature() > plant.getTemperatureInfo().getMaxValue()) {
            temperatureRecommendation = new Recommendation(
                    "Current temperature is too hot.",
                    "Try placing the plant indoors or in a sheltered location."
            );
        } else {
            temperatureRecommendation = new Recommendation(
                    "Current temperature is optimal.",
                    "No further adjustment is needed."
            );
        }

        // humidity computation here
        Recommendation humidityRecommendation;
        if (plantDetails.getHumidity() < plant.getHumidityInfo().getMinValue()) {
            humidityRecommendation = new Recommendation(
                    "Current humidity level is too low.",
                    "Try keeping the humidity level higher by misting, using a humidifier or placing it in more humid area such as the kitchen."
            );
        } else if (plantDetails.getHumidity() > plant.getHumidityInfo().getMaxValue()) {
            humidityRecommendation = new Recommendation(
                    "Current humidity level is too high.",
                    "Try keeping the humidity level lower by placing the plant in a better ventilated area."
            );
        } else {
            humidityRecommendation = new Recommendation(
                    "Current humidity level is optimal.",
                    "No further adjustment is needed."
            );
        }

        return new PlantRecommendation(
                plant,
                lightRecommendation,
                temperatureRecommendation,
                humidityRecommendation
        );
    }
}
