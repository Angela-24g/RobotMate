package com.project.robotmate.admin.domain.price.service;

import com.project.robotmate.admin.domain.price.dto.EditPriceDto;
import com.project.robotmate.admin.domain.price.dto.PriceDto;
import com.project.robotmate.domain.entity.price.Price;
import com.project.robotmate.domain.entity.price.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultPriceService implements PriceService{

    private final PriceRepository priceRepository;

    @Override
    public List<PriceDto> getPrices() {
        return priceRepository.findAll(Sort.by(Sort.Direction.ASC, "ordr")).stream()
                .map(PriceDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PriceDto getPrice(Long id) {
        return new PriceDto(findPrice(id));
    }

    @Override
    @Transactional
    public Long create(EditPriceDto request) {
        Price price = buildPrice(request);
        priceRepository.save(price);

        return price.getId();
    }

    @Override
    @Transactional
    public void update(Long id, EditPriceDto request) {
        Price price = findPrice(id);

        price.changeTarget(request.getTarget());
        price.changeContents(request.getContents());
        price.changeCost(
                request.getW1(),
                request.getW2(),
                request.getW3(),
                request.getOrdr()
        );
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Price price = findPrice(id);
        priceRepository.delete(price);
    }

    @Override
    @Transactional
    public void reorders(List<Long> ids) {
        List<Price> prices = priceRepository.findByIdIn(ids);
        prices.sort(Comparator.comparingLong(price -> ids.indexOf(price.getId())));
        for (int i = 0 ; i < prices.size(); i++) {
            Price price = prices.get(i);
            System.out.println(prices.get(i).getId());
            price.reoreder(i + 1);
            System.out.println(price.getOrdr());
        }

    }
    private Price findPrice(Long id) {
        return priceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 가격정보입니다."));
    }

    private String zeroToEmpty(String value) {
        if (value.equals("0") || ObjectUtils.isEmpty(value)) {
            return null;
        }

        return value;
    }

    private Price buildPrice(EditPriceDto request) {
        Price price = Price.builder()
                .target(request.getTarget())
                .contents(request.getContents())
                .w1(request.getW2())
                .w2(request.getW3())
                .w3(request.getW3())
                .ordr(request.getOrdr())
                .build();

        price.changeCost(
                (request.getW1()),
                (request.getW2()),
                (request.getW3()),
                (request.getOrdr())
        );

        return price;
    }
}
