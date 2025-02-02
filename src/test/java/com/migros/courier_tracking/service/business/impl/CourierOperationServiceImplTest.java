package com.migros.courier_tracking.service.business.impl;

import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.model.response.OperationResult;
import com.migros.courier_tracking.service.database.CourierService;
import com.migros.courier_tracking.service.observer.subject.CourierPositionTracker;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourierOperationServiceImplTest {
    @InjectMocks
    private CourierOperationServiceImpl courierOperationService;
    @Mock
    private CourierPositionTracker courierPositionTracker;
    @Mock
    private CourierService courierService;

    @Test
    void updateLocation() {
        //given
        final CourierLocationUpdateRequest request = new CourierLocationUpdateRequest();
        request.setCourierId(NumberUtils.LONG_ONE);
        request.setLatitude(41.056783);
        request.setLongitude(29.1002348);

        //when
        OperationResult operationResult = courierOperationService.updateLocation(request);

        //then
        assertNotNull(operationResult);
    }

    @Test
    void getTotalTravelDistance() {
        //given
        CourierDTO courierDTO = new CourierDTO();
        courierDTO.setTotalDistance(NumberUtils.DOUBLE_ZERO);

        when(courierService.getCourier(NumberUtils.LONG_ONE)).thenReturn(courierDTO);

        //when
        Double totalTravelDistance = courierOperationService.getTotalTravelDistance(NumberUtils.LONG_ONE);

        //then
        assertNotNull(totalTravelDistance);
    }
}