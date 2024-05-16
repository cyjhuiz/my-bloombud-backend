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
public class LightInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lightInfoId;

    private String preferredLight;

    private String secondaryLight;

    private Double minValue;

    private Double maxValue;

    private final String units = PlantConstants.LUX;

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plant_id")
    Plant plant;
}
