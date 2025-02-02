package com.migros.courier_tracking.service.database;

import com.migros.courier_tracking.model.dto.CourierLocationDTO;

import java.util.List;

public interface CourierLocationService {
    /**
     * Create courier location
     *
     * @param courierLocationDTO courier location to save
     * @return CourierLocationDTO
     */
    CourierLocationDTO createCourierLocation(CourierLocationDTO courierLocationDTO);

    /**
     * Get courier location list by courier id
     *
     * @param courierId courier id
     * @return CourierLocationDTO
     */
    List<CourierLocationDTO> getCourierLocationsByCourierId(Long courierId);
}
