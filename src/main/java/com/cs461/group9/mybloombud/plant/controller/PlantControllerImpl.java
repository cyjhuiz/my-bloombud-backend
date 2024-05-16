package com.cs461.group9.mybloombud.plant.controller;

import com.cs461.group9.mybloombud.plant.model.Plant;
import com.cs461.group9.mybloombud.plant.model.PlantDetails;
import com.cs461.group9.mybloombud.plant.model.PlantRecommendation;
import com.cs461.group9.mybloombud.plant.model.PlantView;
import com.cs461.group9.mybloombud.plant.service.PlantService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/plant")
public class PlantControllerImpl implements PlantController {
    private PlantService plantService;

    @Autowired
    public PlantControllerImpl(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<PlantView>> getPlants(@RequestParam(required = false) String name) {
        ArrayList<PlantView> plants = plantService.getPlants(name);

        return new ResponseEntity<>(
                plants,
                HttpStatus.OK
        );
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<Plant> getPlantByPlantId(@PathVariable Integer plantId) {
        Plant plant = plantService.getPlantByPlantId(plantId);

        return new ResponseEntity<>(
                plant,
                HttpStatus.OK
        );
    }

    @Override
    @PostMapping("/analysis")
    public ResponseEntity<PlantRecommendation> createPlantAnalysis(@RequestBody PlantDetails plantDetails) {
        PlantRecommendation plantRecommendation = plantService.createPlantAnalysis(plantDetails);

        return new ResponseEntity<>(
                plantRecommendation,
                HttpStatus.OK
        );
    }
}
