package com.migros.courier_tracking.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OperationResultException extends RuntimeException {
    private final ExceptionData exceptionData;
}
