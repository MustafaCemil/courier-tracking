package com.migros.courier_tracking.controller;

import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.model.response.OperationResult;
import com.migros.courier_tracking.service.business.CourierOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(path = "/courier-operation")
@RequiredArgsConstructor
@Tag(name = "Courier Operation Service", description = "Courier Operation Service")
public class CourierOperationController {

    private final CourierOperationService courierOperationService;

    @PostMapping("/courier-location")
    @Operation(summary = "Update Courier Location")
    public ResponseEntity<OperationResult> updateLocation(@Valid @RequestBody CourierLocationUpdateRequest request) {
        return ResponseEntity.ok(courierOperationService.updateLocation(request));
    }

    @GetMapping("/distance/{courierId}")
    @Operation(summary = "Get Courier Total Distance")
    public ResponseEntity<Double> getTotalTravelDistance(@PathVariable Long courierId) {
        return ResponseEntity.ok(courierOperationService.getTotalTravelDistance(courierId));
    }
}
