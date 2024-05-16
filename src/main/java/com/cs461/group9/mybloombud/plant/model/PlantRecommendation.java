package com.cs461.group9.mybloombud.plant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantRecommendation {
    private Plant plant;
    private Recommendation lightRecommendation;
    private Recommendation temperatureRecommendation;
    private Recommendation humidityRecommendation;
}
