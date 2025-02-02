package com.migros.courier_tracking.repository;

import com.migros.courier_tracking.model.entity.CourierStoreEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierStoreEntryRepository extends JpaRepository<CourierStoreEntryEntity, Long> {
}