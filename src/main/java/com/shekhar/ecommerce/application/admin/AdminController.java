package com.shekhar.ecommerce.application.admin;

import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.model.Seller;
import com.shekhar.ecommerce.application.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/all-users")
    public List<User> getAllUsers(){
        return adminService.findAllUsers();
    }

    @GetMapping("/all-active-orders")
    public List<OrderEntity> getAllActiveOrders(){
        return adminService.findAllActiveOrders();
    }

    @GetMapping("/all-products")
    public List<Product> getAllProducts(){
        return adminService.findAllProducts();
    }

    @GetMapping("/all-sellers")
    public List<Seller> getAllSellers(){
        return adminService.findAllSellers();
    }
}
