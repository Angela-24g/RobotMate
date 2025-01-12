package com.project.robotmate.admin.domain.price.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditPriceDto {

    private String target;
    private String contents;
    private Integer w1;
    private Integer w2;
    private Integer w3;

    private Integer ordr;
}
