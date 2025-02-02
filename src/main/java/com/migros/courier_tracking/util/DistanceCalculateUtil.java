package com.migros.courier_tracking.util;

import com.migros.courier_tracking.model.dto.LocationInfoDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DistanceCalculateUtil {

    public static double calculateDistance(LocationInfoDTO firstLocation, LocationInfoDTO secondLocation) {
        double latDistance = Math.toRadians(secondLocation.getLatitude() - firstLocation.getLatitude());
        double lonDistance = Math.toRadians(secondLocation.getLongitude() - firstLocation.getLongitude());
        double value = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(firstLocation.getLatitude())) * Math.cos(Math.toRadians(secondLocation.getLatitude()))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double multiplier = 2 * Math.atan2(Math.sqrt(value), Math.sqrt(1 - value));
        return Constants.RADIUS_OF_EARTH_KILOMETER * multiplier;
    }
}
