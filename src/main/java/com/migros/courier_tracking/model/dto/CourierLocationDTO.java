package com.migros.courier_tracking.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourierLocationDTO {
    private Long id;
    private Long courierId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime entryTime;
}