package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.model.Seller;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    public Seller addSeller(Seller seller);
}
