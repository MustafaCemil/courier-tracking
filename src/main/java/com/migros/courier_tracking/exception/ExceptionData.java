package com.migros.courier_tracking.exception;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionData {
    private Long errorCode;
    private String errorMessage;
    private List<ValidationError> validationErrorList;
}
