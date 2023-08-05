package com.project.robotmate.home.domain.price.controller;

import com.project.robotmate.home.domain.price.dto.EditPriceDto;
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

   // price 페이지 열기
   @RequestMapping(value = "/pricePage", method = RequestMethod.GET)
   public String faq() {
      return "price";
   }

   private final PriceService priceService;
//    @GetMapping(value = "/prices")
//    public String viewPrices(
//            @RequestParam(value = "page", defaultValue = "1") int page,
//            @RequestParam(value = "year", required = false) String year,
//            @RequestParam(value = "type", required = false) String type,
//            Model model
//    ){
//        List<PriceDto> prices = priceService.getPrices();
//
//        model.addAttribute("prices", prices);
//
//        return "price/list";
//    }
//
//    @GetMapping("/prices/edit/{id}")
//    public String viewEditPrice(
//            @PathVariable("id") Long id,
//            Model model
//    ) {
//        PriceDto price = priceService.getPrice(id);
//        model.addAttribute("price", price);
//
//        return "price/edit";
//    }
//
//    @PostMapping("/prices/edit/{id}")
//    public String editPrice(
//            @PathVariable("id") Long id,
//            @ModelAttribute("price") EditPriceDto request
//    ) {
//        priceService.update(id, request);
//        return "redirect:/prices/edit/" + id;
//    }


}
