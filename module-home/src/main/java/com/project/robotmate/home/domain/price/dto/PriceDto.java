package com.project.robotmate.home.domain.price.dto;

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
    private String collectionUnit;
    private String mockTestCost;
    private String materialCost;
    private String clothesCost;
    private String lunchMoney;
    private String boardingExpenses;
    private String carCost;
    private String type;
    private LocalDateTime modDate;

    private int totalCost;
    private String monthToMin;
    public PriceDto(Price price) {
        this.id = price.getId();
        this.teachingCourse = price.getTeachingCourse();
        this.teachingExpenses = Integer.parseInt(price.getTeachingExpenses());
        this.teachingHour = price.getTeachingHour();
        this.collectionUnit = price.getCollectionUnit();
        this.mockTestCost = price.getMockTestCost();
        this.materialCost = price.getMaterialCost();
        this.clothesCost = price.getClothesCost();
        this.lunchMoney = price.getLunchMoney();
        this.boardingExpenses = price.getBoardingExpenses();
        this.carCost = price.getCarCost();
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
