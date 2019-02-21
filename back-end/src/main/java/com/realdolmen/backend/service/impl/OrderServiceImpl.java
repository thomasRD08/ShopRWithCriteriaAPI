package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.advice.exception.NotFoundException;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.OrderRepository;
import com.realdolmen.backend.repository.ProductRepository;
import com.realdolmen.backend.repository.UserRepository;
import com.realdolmen.backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public Order save(Order order) {
        User user = userRepository.findByUsername(order.getUser().getUsername())
                .orElseThrow(() -> new NotFoundException("User not found"));
        order.setUser(user);

        for (OrderLine orderLine : order.getOrderLines()) {
            Product product = productRepository.findById(orderLine.getProduct().getId())
                    .orElseThrow(() -> new NotFoundException("Product not found"));
            orderLine.getProduct().setVersion(product.getVersion());
            orderLine.getProduct().setType(product.getType());
            orderLine.setProduct(product);
        }

        return orderRepository.save(order);
    }
}
