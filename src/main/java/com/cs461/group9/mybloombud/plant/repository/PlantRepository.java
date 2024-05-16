package com.cs461.group9.mybloombud.plant.repository;

import com.cs461.group9.mybloombud.plant.model.Plant;
import com.cs461.group9.mybloombud.plant.model.PlantView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Plant findPlantByPlantId(int plantId);

    Plant findFirstByName(@Param("name") String name);

}
