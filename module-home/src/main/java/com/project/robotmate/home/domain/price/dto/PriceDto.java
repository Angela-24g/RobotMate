package com.project.robotmate.home.domain.price.dto;

import com.project.robotmate.domain.entity.price.Price;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Data
public class PriceDto {

    private long id;
    private String target;
    private String contents;
    private String w1;
    private String w2;
    private String w3;
    private Integer ordr;

    private String intW1;

    public PriceDto(Price price) {
        this.id = price.getId();
        this.target = price.getTarget();
        this.contents = price.getContents();
        this.w1 = String.format("%,d",price.getW1());
        this.w2 = String.format("%,d",price.getW2());
        this.w3 = String.format("%,d",price.getW3());
        this.ordr = price.getOrdr();
        this.intW1 = String.valueOf((price.getW1()/10000));
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

        return stringToInt(price.getTarget()) +
                stringToInt(price.getContents()) +
                price.getW1() +
                price.getW2() +
                price.getW3();
    }
}
