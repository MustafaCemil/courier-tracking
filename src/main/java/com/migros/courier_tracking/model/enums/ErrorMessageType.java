package com.migros.courier_tracking.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageType {
    M_100(100L, "An unknown error occurred during the process."),
    M_101(101L, "No registered courier found."),
    M_102(102L, "Mandatory field validation errors.");

    private final Long errorCode;
    private final String errorMessage;
}
