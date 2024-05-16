package com.cs461.group9.mybloombud.plant.repository;

import com.cs461.group9.mybloombud.plant.model.TemperatureInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureInfoRepository extends JpaRepository<TemperatureInfo, Integer> {
}
