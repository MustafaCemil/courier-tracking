package com.migros.courier_tracking.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourierDTO {
    private Long id;
    private Double lastLatitude;
    private Double lastLongitude;
    private Double totalDistance;
}