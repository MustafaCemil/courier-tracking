package com.migros.courier_tracking.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationResult {
    private Long resultCode;
    private String resultMessage;
}
