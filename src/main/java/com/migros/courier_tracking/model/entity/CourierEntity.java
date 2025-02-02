package com.migros.courier_tracking.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COURIER")
public class CourierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LAST_LATITUDE")
    private Double lastLatitude;
    @Column(name = "LAST_LONGITUDE")
    private Double lastLongitude;
    @Column(name = "TOTAL_DISTANCE")
    private Double totalDistance;
}