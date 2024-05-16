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
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("plant")
public class LifecycleInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lifeCycleInfoId;

    private String title;

    private String description;

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "plant_id")
    Plant plant;
}
