package com.migros.courier_tracking.service.observer.impl;

import com.migros.courier_tracking.model.dto.CourierLocationDTO;
import com.migros.courier_tracking.model.dto.CourierStoreEntryDTO;
import com.migros.courier_tracking.model.dto.LocationInfoDTO;
import com.migros.courier_tracking.model.dto.StoreDTO;
import com.migros.courier_tracking.model.mapper.LocationInfoMapper;
import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.service.database.CourierLocationService;
import com.migros.courier_tracking.service.database.CourierStoreEntryService;
import com.migros.courier_tracking.service.loader.StoreService;
import com.migros.courier_tracking.service.observer.LocationObserver;
import com.migros.courier_tracking.util.Constants;
import com.migros.courier_tracking.util.DistanceCalculateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourierStoreEntryObserver implements LocationObserver {
    private final StoreService storeService;
    private final CourierStoreEntryService courierStoreEntryService;
    private final CourierLocationService courierLocationService;

    @Transactional
    @Override
    public void update(CourierLocationUpdateRequest request) {
        final List<StoreDTO> storeDTOList = storeService.getStoreList();
        storeDTOList.forEach(storeDTO -> {
            boolean withinRadius = this.isWithinRadius(request, storeDTO);
            if (withinRadius) {
                this.createCourierStoreEntryOperation(request.getCourierId(), storeDTO.getId());
            }
        });
    }

    private boolean isWithinRadius(CourierLocationUpdateRequest request, StoreDTO storeDTO) {
        final LocationInfoDTO storeLocation = LocationInfoMapper.INSTANCE.toLocationInfoByStore(storeDTO);
        final LocationInfoDTO currentLocation = LocationInfoMapper.INSTANCE.toLocationInfoByLocationUpdate(request);
        double calculatedDistance = DistanceCalculateUtil.calculateDistance(currentLocation, storeLocation);
        return calculatedDistance <= Constants.DISTANCE_TO_STORE_CONDITION_KM;
    }

    private void createCourierStoreEntryOperation(Long courierId, Long storeId) {
        final LocalDateTime lastDate = this.getLastDate(courierId);
        final long secondDiff = Duration.between(LocalDateTime.now(), lastDate).toSeconds();
        if (secondDiff > Constants.TIME_TO_STORE_CONDITION_SECOND) {
            final CourierStoreEntryDTO courierStoreEntryDTO = CourierStoreEntryDTO.builder()
                    .courierId(courierId)
                    .storeId(storeId)
                    .entryTime(LocalDateTime.now())
                    .build();
            courierStoreEntryService.createCourierStoreEntry(courierStoreEntryDTO);
        }
    }

    private LocalDateTime getLastDate(Long courierId) {
        final List<CourierLocationDTO> courierLocationDTOList = courierLocationService.getCourierLocationsByCourierId(courierId);
        return courierLocationDTOList.stream()
                .filter(value -> value.getEntryTime() != null)
                .max(Comparator.comparing(CourierLocationDTO::getEntryTime))
                .map(CourierLocationDTO::getEntryTime)
                .orElse(LocalDateTime.now());
    }
}
