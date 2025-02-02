package com.migros.courier_tracking.service.observer.impl;

import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.dto.LocationInfoDTO;
import com.migros.courier_tracking.model.mapper.LocationInfoMapper;
import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.service.database.CourierService;
import com.migros.courier_tracking.service.observer.LocationObserver;
import com.migros.courier_tracking.util.DistanceCalculateUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourierObserver implements LocationObserver {
    private final CourierService courierService;

    @Transactional
    @Override
    public void update(CourierLocationUpdateRequest request) {
        final CourierDTO courierDTO = courierService.getCourier(request.getCourierId());
        this.courierOperation(courierDTO, request);
    }

    private void courierOperation(CourierDTO courierDTO, CourierLocationUpdateRequest request) {
        final Double totalDistance = this.getTotalDistance(courierDTO, request);
        courierDTO.setTotalDistance(totalDistance);
        courierDTO.setLastLatitude(request.getLongitude());
        courierDTO.setLastLongitude(request.getLatitude());

        courierService.createCourier(courierDTO);
    }

    private Double getTotalDistance(CourierDTO courierDTO, CourierLocationUpdateRequest request) {
        final boolean nonNewCourier = this.isNonNewCourier(courierDTO);
        if (nonNewCourier) {
            final LocationInfoDTO lastCourierLocation = LocationInfoMapper.INSTANCE.toLocationInfoByCourier(courierDTO);
            final LocationInfoDTO currentCourierLocation = LocationInfoMapper.INSTANCE.toLocationInfoByLocationUpdate(request);
            final double newDistance = DistanceCalculateUtil.calculateDistance(lastCourierLocation, currentCourierLocation);
            return newDistance + courierDTO.getTotalDistance();
        }

        return NumberUtils.DOUBLE_ZERO;
    }

    private boolean isNonNewCourier(CourierDTO courierDTO) {
        return Optional.of(courierDTO)
                .filter(value -> Objects.nonNull(value.getTotalDistance()))
                .isPresent();
    }
}
