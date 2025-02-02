package com.migros.courier_tracking.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourierStoreEntryDTO {
    private Long id;
    private Long courierId;
    private Long storeId;
    private LocalDateTime entryTime;
}