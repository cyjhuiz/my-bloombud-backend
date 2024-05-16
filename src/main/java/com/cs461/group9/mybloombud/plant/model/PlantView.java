package com.cs461.group9.mybloombud.plant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@Setter
@Table(name = "plant")
public class PlantView {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer plantId;
    String name;
    String description;
    String supportingText;
    String imageUrl;
}
