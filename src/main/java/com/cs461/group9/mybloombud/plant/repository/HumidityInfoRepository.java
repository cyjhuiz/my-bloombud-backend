package com.cs461.group9.mybloombud.plant.repository;

import com.cs461.group9.mybloombud.plant.model.HumidityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityInfoRepository extends JpaRepository<HumidityInfo, Integer> {
}
