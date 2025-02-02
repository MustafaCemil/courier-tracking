package com.migros.courier_tracking.model.mapper;

import com.migros.courier_tracking.model.dto.CourierLocationDTO;
import com.migros.courier_tracking.model.entity.CourierLocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierLocationMapper {
    CourierLocationMapper INSTANCE = Mappers.getMapper(CourierLocationMapper.class);

    CourierLocationDTO toCourierLocationDTO(CourierLocationEntity source);

    CourierLocationEntity toCourierLocationEntity(CourierLocationDTO source);

    List<CourierLocationDTO> toCourierLocationDTOList(List<CourierLocationEntity> sourceList);

    List<CourierLocationEntity> toCourierLocationEntityList(List<CourierLocationDTO> sourceList);
}