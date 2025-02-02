package com.migros.courier_tracking.service.business.impl;

import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.enums.ResultType;
import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.model.response.OperationResult;
import com.migros.courier_tracking.service.business.CourierOperationService;
import com.migros.courier_tracking.service.database.CourierService;
import com.migros.courier_tracking.service.observer.subject.CourierPositionTracker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CourierOperationServiceImpl implements CourierOperationService {
    private final CourierPositionTracker courierPositionTracker;
    private final CourierService courierService;

    @Transactional
    @Override
    public OperationResult updateLocation(CourierLocationUpdateRequest request) {
        courierPositionTracker.updateCourierLocation(request);
        return OperationResult.builder()
                .resultCode(ResultType.SUCCESS.getResultCode())
                .resultMessage(ResultType.SUCCESS.getResultMessage())
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public Double getTotalTravelDistance(Long courierId) {
        final CourierDTO courierDTO = courierService.getCourier(courierId);
        return courierDTO.getTotalDistance();
    }

}
