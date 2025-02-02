package com.migros.courier_tracking.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StoreDTO {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
}