package com.migros.courier_tracking.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultType {
    SUCCESS(0L, "The operation was successfully completed.");

    private final Long resultCode;
    private final String resultMessage;
}
