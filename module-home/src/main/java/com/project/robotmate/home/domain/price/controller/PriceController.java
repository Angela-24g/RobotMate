package com.project.robotmate.home.domain.price.controller;

import com.project.robotmate.home.domain.price.dto.PriceDto;
import com.project.robotmate.home.domain.price.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PriceController {

   private final PriceService priceService;
   // price 페이지 열기
   @RequestMapping(value = "/price", method = RequestMethod.GET)
   public String faq(Model model) {
      List<PriceDto> prices = priceService.getPrices();

      model.addAttribute("price",prices);
      return "price";
   }
}
