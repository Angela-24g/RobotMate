package com.project.robotmate.home.domain.price.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditPriceDto {

    private long id;
    private String target;
    private String contents;
    private Integer w1;
    private Integer w2;
    private Integer w3;

}
