package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.model.Seller;
import com.shekhar.ecommerce.application.repository.SellerRepository;
import com.shekhar.ecommerce.application.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
