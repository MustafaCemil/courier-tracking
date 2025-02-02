package com.migros.courier_tracking.service.observer;

import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;

public interface LocationObserver {
    /**
     * Update courier location
     *
     * @param request request
     *
     */
    void update(CourierLocationUpdateRequest request);
}
