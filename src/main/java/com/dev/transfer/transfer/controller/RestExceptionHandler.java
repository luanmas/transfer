package com.dev.transfer.transfer.controller;

import com.dev.transfer.transfer.exceptions.TransferException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TransferException.class)
    public ProblemDetail handleTransferException(TransferException ex) {
        return ex.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var fieldErrors = ex.getFieldErrors()
                .stream()
                .map(f -> new InvalidParams(f.getField(), f.getDefaultMessage()))
                .toList();
        var pb =  ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Sua requisição não está com os parâmetros válidos.");
        pb.setProperty("invalid-params", fieldErrors);

        return pb;
    }

    private record InvalidParams(String name, String reason) {}
}
