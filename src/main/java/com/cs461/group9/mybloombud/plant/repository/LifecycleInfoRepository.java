package com.cs461.group9.mybloombud.plant.repository;

import com.cs461.group9.mybloombud.plant.model.LifecycleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LifecycleInfoRepository extends JpaRepository<LifecycleInfo, Integer> {
}
