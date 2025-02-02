package com.migros.courier_tracking.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "COURIER_STORE_ENTRY")
public class CourierStoreEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "COURIER_ID")
    private Long courierId;
    @Column(name = "STORE_ID")
    private Long storeId;
    @Column(name = "ENTRY_TIME")
    private LocalDateTime entryTime;
}