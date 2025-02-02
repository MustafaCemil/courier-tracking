package com.migros.courier_tracking.impl;

import com.migros.courier_tracking.model.dto.CourierStoreEntryDTO;
import com.migros.courier_tracking.model.entity.CourierStoreEntryEntity;
import com.migros.courier_tracking.repository.CourierStoreEntryRepository;
import com.migros.courier_tracking.service.database.impl.CourierStoreEntryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourierStoreEntryServiceImplTest {

    @InjectMocks
    private CourierStoreEntryServiceImpl storeEntryService;
    @Mock
    private CourierStoreEntryRepository storeEntryRepository;

    @Test
    void createCourierStoreEntry() {
        CourierStoreEntryDTO courierStoreEntryDTO = new CourierStoreEntryDTO();
        CourierStoreEntryEntity courierStoreEntryEntity = new CourierStoreEntryEntity();

        when(storeEntryRepository.save(any(CourierStoreEntryEntity.class))).thenReturn(courierStoreEntryEntity);

        CourierStoreEntryDTO result = storeEntryService.createCourierStoreEntry(courierStoreEntryDTO);

        assertNotNull(result);
    }
}