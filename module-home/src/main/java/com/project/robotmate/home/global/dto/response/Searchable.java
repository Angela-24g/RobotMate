package com.project.robotmate.home.global.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
public class Searchable {

    private int page;
    private String type;

    private String year;

    @Builder
    public Searchable(int page, String type, String year) {
        this.page = page;
        this.type = type;
        this.year = getStringYear(year);
    }

    public String getType() {
        if (type == null) {
            return null;
        }
        return type.toUpperCase();
    }

    private String getStringYear(String year) {
        if (year == null) {
           return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
        }
        return year;
    }
}
