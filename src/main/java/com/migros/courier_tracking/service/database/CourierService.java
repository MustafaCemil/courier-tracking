package com.migros.courier_tracking.service.database;

import com.migros.courier_tracking.model.dto.CourierDTO;

public interface CourierService {

    /**
     * Create a new courier.
     *
     * @param courierDTO courier create
     * @return CourierDTO
     */
    CourierDTO createCourier(CourierDTO courierDTO);

    /**
     * Get courier
     *
     * @param courierId the ID of the courier to find
     * @return CourierDTO
     */
    CourierDTO getCourier(Long courierId);
}
