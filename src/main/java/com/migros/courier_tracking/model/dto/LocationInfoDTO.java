package com.migros.courier_tracking.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationInfoDTO {
    private Double latitude;
    private Double longitude;
}
