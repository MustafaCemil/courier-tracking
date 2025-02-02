package com.migros.courier_tracking.service.database.impl;

import com.migros.courier_tracking.exception.ExceptionData;
import com.migros.courier_tracking.exception.OperationResultException;
import com.migros.courier_tracking.model.dto.CourierDTO;
import com.migros.courier_tracking.model.entity.CourierEntity;
import com.migros.courier_tracking.model.enums.ErrorMessageType;
import com.migros.courier_tracking.model.mapper.CourierMapper;
import com.migros.courier_tracking.repository.CourierRepository;
import com.migros.courier_tracking.service.database.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;

    @Transactional
    @Override
    public CourierDTO createCourier(CourierDTO courierDTO) {
        CourierEntity courierEntity = CourierMapper.INSTANCE.toCourierEntity(courierDTO);
        courierRepository.save(courierEntity);
        return CourierMapper.INSTANCE.toCourierDTO(courierEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public CourierDTO getCourier(Long courierId) {
        return courierRepository.findById(courierId)
                .map(CourierMapper.INSTANCE::toCourierDTO)
                .orElseThrow(() -> OperationResultException.builder()
                        .exceptionData(
                                ExceptionData.builder()
                                        .errorCode(ErrorMessageType.M_101.getErrorCode())
                                        .errorMessage(ErrorMessageType.M_101.getErrorMessage())
                                        .build()
                        )
                        .build());
    }
}
