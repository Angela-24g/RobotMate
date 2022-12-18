package com.project.robotmate.admin.global.dto.response;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private int code;

    private String message;

    private int errorCode;

    private String errorMessage;

    private ErrorResponse(int code, String message, int errorCode, String errorMessage) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ErrorResponse error(int errorCode, String errorMessage) {
       return new ErrorResponse(-1, "Fail", errorCode, errorMessage);
    }
}

