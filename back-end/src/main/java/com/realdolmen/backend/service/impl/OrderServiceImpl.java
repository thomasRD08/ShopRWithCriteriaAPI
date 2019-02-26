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
                .orElseThrow(() -> new NotFoundException("No user found with username " + order.getUser().getUsername()));
        order.setUser(user);

        for (OrderLine orderLine : order.getOrderLines()) {
            Product product = productRepository.findById(orderLine.getProduct().getId())
                    .orElseThrow(() -> new NotFoundException("No product found with id " + orderLine.getProduct().getId()));
            orderLine.getProduct().setVersion(product.getVersion());
            orderLine.getProduct().setType(product.getType());
            orderLine.setProduct(product);
        }

        return orderRepository.save(order);
    }
}
