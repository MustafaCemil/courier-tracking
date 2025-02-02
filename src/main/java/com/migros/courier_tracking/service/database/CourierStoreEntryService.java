package com.migros.courier_tracking.service.database;

import com.migros.courier_tracking.model.dto.CourierStoreEntryDTO;

public interface CourierStoreEntryService {
    /**
     * Create courier store entry
     *
     * @param courierStoreEntryDTO courier store entry
     * @return CourierStoreEntryDTO
     */
    CourierStoreEntryDTO createCourierStoreEntry(CourierStoreEntryDTO courierStoreEntryDTO);
}
