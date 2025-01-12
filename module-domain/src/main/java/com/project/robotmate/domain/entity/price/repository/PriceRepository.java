package com.project.robotmate.domain.entity.price.repository;

import com.project.robotmate.domain.entity.price.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAll();

    List<Price> findByIdIn(List<Long> ids);
}
