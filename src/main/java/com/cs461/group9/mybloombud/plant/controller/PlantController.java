package com.cs461.group9.mybloombud.plant.controller;

import com.cs461.group9.mybloombud.plant.model.Plant;
import com.cs461.group9.mybloombud.plant.model.PlantDetails;
import com.cs461.group9.mybloombud.plant.model.PlantRecommendation;
import com.cs461.group9.mybloombud.plant.model.PlantView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public interface PlantController {
    ResponseEntity<ArrayList<PlantView>> getPlants(@RequestParam("name") String name);

    ResponseEntity<Plant>  getPlantByPlantId(Integer plantId);

    ResponseEntity<PlantRecommendation> createPlantAnalysis(PlantDetails plantDetails);
}
