package com.cs461.group9.mybloombud.plant.model;

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
public class Plant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer plantId;

    private String name;

    private String description;

    private String supportingText;

    private String imageUrl;

    private String arModeUrl;

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lifecycle_info_id")
    private LifecycleInfo lifecycleInfo;

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "light_info_id")
    private LightInfo lightInfo;

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "temperature_info_id")
    private TemperatureInfo temperatureInfo;

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "humidity_info_id")
    private HumidityInfo humidityInfo;

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "water_info_id")
    private WaterInfo waterInfo;
}
