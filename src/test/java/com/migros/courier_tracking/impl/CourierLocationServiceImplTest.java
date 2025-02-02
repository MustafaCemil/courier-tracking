package com.migros.courier_tracking.impl;

import com.migros.courier_tracking.model.dto.CourierLocationDTO;
import com.migros.courier_tracking.model.entity.CourierLocationEntity;
import com.migros.courier_tracking.repository.CourierLocationRepository;
import com.migros.courier_tracking.service.database.impl.CourierLocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourierLocationServiceImplTest {

    @InjectMocks
    private CourierLocationServiceImpl courierLocationService;
    @Mock
    private CourierLocationRepository courierLocationRepository;

    @Test
    void testCreateCourierLocation() {
        //given
        CourierLocationDTO courierLocationDTO = new CourierLocationDTO();
        CourierLocationEntity courierLocationEntity = new CourierLocationEntity();

        when(courierLocationRepository.save(any(CourierLocationEntity.class))).thenReturn(courierLocationEntity);

        //when
        CourierLocationDTO result = courierLocationService.createCourierLocation(courierLocationDTO);

        //then
        assertNotNull(result);
    }
}