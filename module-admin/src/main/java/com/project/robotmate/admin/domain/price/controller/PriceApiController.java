package com.project.robotmate.admin.domain.price.controller;

import com.project.robotmate.admin.domain.price.service.PriceService;
import com.project.robotmate.admin.global.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PriceApiController {

    private final PriceService priceService;

    @DeleteMapping("/api/prices/{id}")
    public ResponseEntity<ApiResponse> deletePrice(
            @PathVariable(value = "id") Long id
    ) {
        priceService.remove(id);
        return ResponseEntity.ok(ApiResponse.ok());
    }

}
