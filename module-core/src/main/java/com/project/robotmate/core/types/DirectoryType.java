package com.project.robotmate.core.types;

public enum DirectoryType {
    NOTICE("notice/"),
    GALLERY("gallery/"),
    REQ("req/");

    private String value;

    DirectoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
