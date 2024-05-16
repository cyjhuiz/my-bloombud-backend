package com.cs461.group9.mybloombud.plant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("plant")
public class WaterInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer waterInfoId;

    private Integer wateringFrequencyInDays;

    private String wateringGuidelines;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "plant_id")
    private Plant plant;
}
