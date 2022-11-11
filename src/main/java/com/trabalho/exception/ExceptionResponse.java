package com.trabalho.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ExceptionResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorValidationsResponse> erros;


    public ExceptionResponse(List<ErrorValidationsResponse> erros) {
        this.erros = erros;
    }
    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
