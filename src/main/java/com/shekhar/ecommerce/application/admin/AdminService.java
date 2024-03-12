package com.shekhar.ecommerce.application.admin;

import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.model.Seller;
import com.shekhar.ecommerce.application.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public List<User> findAllUsers();
    public List<OrderEntity> findAllActiveOrders();
    public List<Product> findAllProducts();
    public List<Seller> findAllSellers();

    public User makeAdmin(Long userId);
    public User removeAdmin(Long userId);
}
