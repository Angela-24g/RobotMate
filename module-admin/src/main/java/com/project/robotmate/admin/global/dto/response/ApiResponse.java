package com.project.robotmate.admin.global.dto.response;

import lombok.Getter;

@Getter
public class ApiResponse {

    private int code;
    private String message;


    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiResponse ok() {
        return new ApiResponse(0, "Success");
    }
}
