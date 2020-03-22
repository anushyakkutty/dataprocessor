package com.data.content.publisher.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ContentPublisherExceptionHandler
        extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
        return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
    }

    @Data
    public class ErrorDetails {
        private HttpStatus status;
        private String message;
        private List<String> errors;

        public ErrorDetails(HttpStatus status, String message, List<String> errors) {
            super();
            this.status = status;
            this.message = message;
            this.errors = errors;
        }

        public ErrorDetails(HttpStatus status, String message, String error) {
            super();
            this.status = status;
            this.message = message;
            errors = Arrays.asList(error);
        }
    }
}
