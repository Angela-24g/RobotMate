package com.project.robotmate.admin.domain.price.service;

import com.project.robotmate.admin.domain.price.dto.EditPriceDto;
import com.project.robotmate.admin.domain.price.dto.PriceDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PriceService {

    List<PriceDto> getPrices();

    PriceDto getPrice(Long id);

    @Transactional
    Long create(EditPriceDto request);

    void update(Long id, EditPriceDto request);
    @Transactional
    void remove(Long id);

    void reorders(List<Long> ids);
}
