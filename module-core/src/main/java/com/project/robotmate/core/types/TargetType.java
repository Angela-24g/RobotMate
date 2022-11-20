package com.project.robotmate.core.types;

public enum TargetType {
    BBS("001001"),
    REQ("001002"),
    GALLERY("001003");

    private String code;

    TargetType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
