package com.migros.courier_tracking.service.observer.impl;

import com.migros.courier_tracking.model.dto.CourierLocationDTO;
import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.service.database.CourierLocationService;
import com.migros.courier_tracking.service.observer.LocationObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CourierLocationObserver implements LocationObserver {
    private final CourierLocationService courierLocationService;

    @Transactional
    @Override
    public void update(CourierLocationUpdateRequest request) {
        final CourierLocationDTO courierLocationDTO = CourierLocationDTO.builder()
                .courierId(request.getCourierId())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .entryTime(LocalDateTime.now())
                .build();
        courierLocationService.createCourierLocation(courierLocationDTO);
    }
}
