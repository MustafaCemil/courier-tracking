package com.migros.courier_tracking.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierLocationUpdateRequest {
    @NotNull(message = "Courier ID mandatory")
    private Long courierId;
    @NotNull(message = "Latitude mandatory")
    private Double latitude;
    @NotNull(message = "Longitude mandatory")
    private Double longitude;
}