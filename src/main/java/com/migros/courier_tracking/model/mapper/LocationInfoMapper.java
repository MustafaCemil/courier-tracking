package com.migros.courier_tracking.model.mapper;

import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.dto.LocationInfoDTO;
import com.migros.courier_tracking.model.dto.StoreDTO;
import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationInfoMapper {
    LocationInfoMapper INSTANCE = Mappers.getMapper(LocationInfoMapper.class);

    @Mapping(source = "lastLatitude", target = "latitude")
    @Mapping(source = "lastLongitude", target = "longitude")
    LocationInfoDTO toLocationInfoByCourier(CourierDTO source);

    LocationInfoDTO toLocationInfoByStore(StoreDTO source);

    LocationInfoDTO toLocationInfoByLocationUpdate(CourierLocationUpdateRequest source);
}