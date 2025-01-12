package com.project.robotmate.admin.domain.price.dto;

import com.project.robotmate.domain.entity.price.Price;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceDto {

    private long id;
    private String target;
    private String contents;
    private Integer w1;
    private Integer w2;
    private Integer w3;
    private Integer ordr;



    public PriceDto(Price price) {
        this.id = price.getId();
        this.target = price.getTarget();
        this.contents = price.getContents();
        this.w1 = price.getW1();
        this.w2 = price.getW2();
        this.w3 = price.getW3();
        this.ordr = price.getOrdr();

    }

    public int stringToInt(String value) {
       try {
           return Integer.parseInt(value);
       }catch (Exception e) {
           return 0;
       }
    }

}
