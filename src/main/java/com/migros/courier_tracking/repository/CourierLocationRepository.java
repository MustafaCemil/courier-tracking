package com.migros.courier_tracking.repository;

import com.migros.courier_tracking.model.entity.CourierLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierLocationRepository extends JpaRepository<CourierLocationEntity, Long> {

    List<CourierLocationEntity> findByCourierId(Long courierId);
}