package com.cs461.group9.mybloombud.plant.service;

import com.cs461.group9.mybloombud.plant.model.Plant;
import com.cs461.group9.mybloombud.plant.model.PlantDetails;
import com.cs461.group9.mybloombud.plant.model.PlantRecommendation;
import com.cs461.group9.mybloombud.plant.model.PlantView;

import java.util.ArrayList;

public interface PlantService {
    ArrayList<PlantView> getPlants(String name);

    Plant getPlantByPlantId(Integer plantId);

    PlantRecommendation createPlantAnalysis(PlantDetails plantDetails);

    PlantRecommendation computePlantRecommendation(Plant plant, PlantDetails plantDetails);
}
