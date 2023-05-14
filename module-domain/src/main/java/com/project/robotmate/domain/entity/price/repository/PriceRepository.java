package com.project.robotmate.domain.entity.price.repository;

import com.project.robotmate.domain.entity.price.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
