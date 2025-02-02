package com.migros.courier_tracking.service.database.impl;

import com.migros.courier_tracking.model.dto.CourierStoreEntryDTO;
import com.migros.courier_tracking.model.entity.CourierStoreEntryEntity;
import com.migros.courier_tracking.model.mapper.CourierStoreEntryMapper;
import com.migros.courier_tracking.repository.CourierStoreEntryRepository;
import com.migros.courier_tracking.service.database.CourierStoreEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourierStoreEntryServiceImpl implements CourierStoreEntryService {

    private final CourierStoreEntryRepository storeEntryRepository;

    @Override
    public CourierStoreEntryDTO createCourierStoreEntry(CourierStoreEntryDTO courierStoreEntryDTO) {
        CourierStoreEntryEntity courierStoreEntryEntity = CourierStoreEntryMapper.INSTANCE.toCourierStoreEntryEntity(courierStoreEntryDTO);
        storeEntryRepository.save(courierStoreEntryEntity);
        return CourierStoreEntryMapper.INSTANCE.toCourierStoreEntryDTO(courierStoreEntryEntity);
    }
}
