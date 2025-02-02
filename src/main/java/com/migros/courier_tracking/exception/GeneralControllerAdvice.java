package com.migros.courier_tracking.exception;

import com.migros.courier_tracking.model.enums.ErrorMessageType;
import com.migros.courier_tracking.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GeneralControllerAdvice {

    @ExceptionHandler(OperationResultException.class)
    public ResponseEntity<ExceptionData> handleOperationResultException(OperationResultException operationResultException) {
        return new ResponseEntity<>(operationResultException.getExceptionData(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionData> handleValidationExceptions(MethodArgumentNotValidException ex) {
        final List<ValidationError> validationErrorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String fieldMessage = error.getDefaultMessage();
            final ValidationError validationError = ValidationError.builder()
                    .fieldName(fieldName)
                    .fieldMessage(fieldMessage)
                    .build();
            validationErrorList.add(validationError);
        });

        ExceptionData exceptionData = ExceptionData.builder()
                .errorCode(ErrorMessageType.M_102.getErrorCode())
                .errorMessage(ErrorMessageType.M_102.getErrorMessage())
                .validationErrorList(validationErrorList)
                .build();

        return new ResponseEntity<>(exceptionData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionData> handleException(Exception e) {
        final String errorLog = JsonUtil.exceptionToString(e);
        log.error(errorLog);

        ExceptionData exceptionData = ExceptionData.builder()
                .errorCode(ErrorMessageType.M_100.getErrorCode())
                .errorMessage(ErrorMessageType.M_100.getErrorMessage())
                .build();
        return new ResponseEntity<>(exceptionData, HttpStatus.BAD_REQUEST);
    }
}
 