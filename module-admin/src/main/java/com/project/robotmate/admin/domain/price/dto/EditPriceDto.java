package com.project.robotmate.admin.domain.price.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditPriceDto {

    private String teachingCourse;
    private Integer teachingExpenses;
    private String teachingHour;
    private String collectionUnit;
    private String mockTestCost;
    private String materialCost;
    private String clothesCost;
    private String lunchMoney;
    private String boardingExpenses;
    private String carCost;
    private String type;

}
