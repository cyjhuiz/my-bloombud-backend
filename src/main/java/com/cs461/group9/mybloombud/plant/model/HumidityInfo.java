package com.cs461.group9.mybloombud.plant.model;

import com.cs461.group9.mybloombud.plant.constant.PlantConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("plant")
public class HumidityInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer humidityInfoId;

    private String description;

    private Integer mistingFrequencyInDays;

    private Double minValue;

    private Double maxValue;

    private final String units = PlantConstants.PERCENT;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "plant_id")
    private Plant plant;
}
