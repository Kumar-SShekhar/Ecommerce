package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.model.Seller;
import com.shekhar.ecommerce.application.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/new")
    public Seller addSeller(@RequestBody Seller seller){
        return sellerService.addSeller(seller);
    }
}
