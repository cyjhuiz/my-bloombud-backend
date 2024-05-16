package com.cs461.group9.mybloombud.plant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantDetails {
    private String name;

    private Double temperature;

    private Double light;

    private Double humidity;
}
