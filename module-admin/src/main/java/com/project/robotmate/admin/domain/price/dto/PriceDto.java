package com.project.robotmate.admin.domain.price.dto;

import com.project.robotmate.domain.entity.price.Price;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Data
public class PriceDto {

    private Long id;
    private String teachingCourse;
    private Integer teachingExpenses;
    private String teachingHour;
    private Integer collectionUnit;
    private Integer mockTestCost;
    private Integer materialCost;
    private Integer clothesCost;
    private Integer lunchMoney;
    private Integer boardingExpenses;
    private Integer carCost;
    private String type;
    private LocalDateTime modDate;

    private int totalCost;
    private String monthToMin;
    public PriceDto(Price price) {
        this.id = price.getId();
        this.teachingCourse = price.getTeachingCourse();
        this.teachingExpenses = stringToInt(price.getTeachingExpenses());
        this.teachingHour = price.getTeachingHour();
        this.collectionUnit = stringToInt(price.getCollectionUnit());
        this.mockTestCost = stringToInt(price.getMockTestCost());
        this.materialCost = stringToInt(price.getMaterialCost());
        this.clothesCost = stringToInt(price.getClothesCost());
        this.lunchMoney = stringToInt(price.getLunchMoney());
        this.boardingExpenses = stringToInt(price.getBoardingExpenses());
        this.carCost = stringToInt(price.getCarCost());
        this.type = price.getType();
        this.modDate = price.getModDate();
        this.totalCost = calcTotalCost(price);
        this.monthToMin = String.valueOf((int) Float.parseFloat(price.getTeachingHour()) * 60);
    }

    public int stringToInt(String value) {
       try {
           return Integer.parseInt(value);
       }catch (Exception e) {
           return 0;
       }
    }

    public int calcTotalCost(Price price) {
        if (ObjectUtils.isEmpty(price)) {
            return 0;
        }

        return stringToInt(price.getTeachingExpenses()) +
                stringToInt(price.getMockTestCost()) +
                stringToInt(price.getMaterialCost()) +
                stringToInt(price.getClothesCost()) +
                stringToInt(price.getLunchMoney()) +
                stringToInt(price.getBoardingExpenses()) +
                stringToInt(price.getCarCost());
    }
}
