package com.migros.courier_tracking.model.mapper;

import com.migros.courier_tracking.model.dto.CourierStoreEntryDTO;
import com.migros.courier_tracking.model.entity.CourierStoreEntryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourierStoreEntryMapper {
    CourierStoreEntryMapper INSTANCE = Mappers.getMapper(CourierStoreEntryMapper.class);

    CourierStoreEntryDTO toCourierStoreEntryDTO(CourierStoreEntryEntity source);

    CourierStoreEntryEntity toCourierStoreEntryEntity(CourierStoreEntryDTO source);
}