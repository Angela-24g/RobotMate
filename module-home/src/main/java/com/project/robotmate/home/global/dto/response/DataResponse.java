package com.project.robotmate.home.global.dto.response;

import lombok.Getter;

@Getter
public class DataResponse<T> {

    private T data;

    public DataResponse(T data) {
        this.data = data;
    }
}
