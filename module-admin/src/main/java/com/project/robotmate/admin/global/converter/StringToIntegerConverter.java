package com.project.robotmate.admin.global.converter;

import org.springframework.core.convert.converter.Converter;

public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
