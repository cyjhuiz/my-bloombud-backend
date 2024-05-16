package com.cs461.group9.mybloombud.plant.repository;

import com.cs461.group9.mybloombud.plant.model.Plant;
import com.cs461.group9.mybloombud.plant.model.PlantView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PlantViewRepository extends JpaRepository<PlantView, Integer> {
    ArrayList<PlantView> findAllByOrderByNameAsc();

    ArrayList<PlantView> findAllByNameContainingIgnoreCaseOrderByNameAsc(String name);
}
