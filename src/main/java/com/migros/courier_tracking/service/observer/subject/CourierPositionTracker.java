package com.migros.courier_tracking.service.observer.subject;

import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.service.observer.LocationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourierPositionTracker {
    private final List<LocationObserver> observers;

    @Autowired
    public CourierPositionTracker(List<LocationObserver> observers) {
        this.observers = observers;
    }

    public void notifyObservers(CourierLocationUpdateRequest location) {
        for (LocationObserver observer : observers) {
            observer.update(location);
        }
    }

    public void updateCourierLocation(CourierLocationUpdateRequest location) {
        this.notifyObservers(location);
    }
}