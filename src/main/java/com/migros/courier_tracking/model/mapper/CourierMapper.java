package com.migros.courier_tracking.model.mapper;

import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.entity.CourierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    CourierMapper INSTANCE = Mappers.getMapper(CourierMapper.class);

    CourierDTO toCourierDTO(CourierEntity source);

    CourierEntity toCourierEntity(CourierDTO source);
}