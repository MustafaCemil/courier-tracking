package com.migros.courier_tracking.exception;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {
    private String fieldName;
    private String fieldMessage;
}
