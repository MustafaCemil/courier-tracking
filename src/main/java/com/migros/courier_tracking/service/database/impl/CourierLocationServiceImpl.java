package com.migros.courier_tracking.service.database.impl;

import com.migros.courier_tracking.model.dto.CourierLocationDTO;
import com.migros.courier_tracking.model.entity.CourierLocationEntity;
import com.migros.courier_tracking.model.mapper.CourierLocationMapper;
import com.migros.courier_tracking.repository.CourierLocationRepository;
import com.migros.courier_tracking.service.database.CourierLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourierLocationServiceImpl implements CourierLocationService {
    private final CourierLocationRepository courierLocationRepository;

    @Transactional
    @Override
    public CourierLocationDTO createCourierLocation(CourierLocationDTO courierLocationDTO) {
        CourierLocationEntity courierLocationEntity = CourierLocationMapper.INSTANCE.toCourierLocationEntity(courierLocationDTO);
        courierLocationRepository.save(courierLocationEntity);
        return CourierLocationMapper.INSTANCE.toCourierLocationDTO(courierLocationEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CourierLocationDTO> getCourierLocationsByCourierId(Long courierId) {
        final List<CourierLocationEntity> courierLocationEntityList = courierLocationRepository.findByCourierId(courierId);
        return CourierLocationMapper.INSTANCE.toCourierLocationDTOList(courierLocationEntityList);
    }

}
