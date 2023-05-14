package com.project.robotmate.admin.domain.price.service;

import com.project.robotmate.admin.domain.price.dto.EditPriceDto;
import com.project.robotmate.admin.domain.price.dto.PriceDto;

import java.util.List;

public interface PriceService {

    List<PriceDto> getPrices();

    PriceDto getPrice(Long id);

    void update(Long id, EditPriceDto request);
}
