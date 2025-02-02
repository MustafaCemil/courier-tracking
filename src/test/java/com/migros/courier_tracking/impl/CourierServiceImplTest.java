package com.migros.courier_tracking.impl;

import com.migros.courier_tracking.exception.OperationResultException;
import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.entity.CourierEntity;
import com.migros.courier_tracking.repository.CourierRepository;
import com.migros.courier_tracking.service.database.impl.CourierServiceImpl;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourierServiceImplTest {
    @InjectMocks
    private CourierServiceImpl courierService;
    @Mock
    private CourierRepository courierRepository;

    @Test
    void createCourier() {
        //given
        CourierDTO courierDTO = new CourierDTO();
        CourierEntity courierEntity = new CourierEntity();

        when(courierRepository.save(any(CourierEntity.class))).thenReturn(courierEntity);

        //when
        CourierDTO result = courierService.createCourier(courierDTO);

        //then
        assertNotNull(result);
    }

    @Test
    void getCourier() {
        //given
        Long courierId = 1L;
        CourierEntity courierEntity = new CourierEntity();

        when(courierRepository.findById(courierId)).thenReturn(Optional.of(courierEntity));

        //when
        CourierDTO result = courierService.getCourier(courierId);

        //then
        assertNotNull(result);
    }

    @Test
    void getCourierError() {
        //then
        assertThrows(OperationResultException.class, () -> courierService.getCourier(NumberUtils.LONG_ONE));
    }
}