package com.migros.courier_tracking.service.business;

import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.model.response.OperationResult;

public interface CourierOperationService {

    /**
     * Update courier location
     *
     * @param request request
     * @return OperationResult
     */
    OperationResult updateLocation(CourierLocationUpdateRequest request);

    /**
     * Get total distance for courier
     *
     * @param courierId courier id
     * @return Double
     */
    Double getTotalTravelDistance(Long courierId);
}
