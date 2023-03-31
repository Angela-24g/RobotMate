package com.project.robotmate.global.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateUtil {

    public static List<String> getYears() {
        List<String> years = new ArrayList<>();

        for (int i = 0 ; i < 15 ; i++ ){
            years.add(String.valueOf(LocalDate.now().minusYears(i).getYear()));
        }

        return years;
    }
}
