package com.realdolmen.backend.controller;

import com.realdolmen.backend.advice.exception.NotFoundException;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.OrderRepository;
import com.realdolmen.backend.repository.ProductRepository;
import com.realdolmen.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @PostMapping
    public Order save(@RequestBody Order order) {
        User user = userRepository.findByUsername(order.getUser().getUsername())
                .orElseThrow(() -> new NotFoundException("No user found"));
        order.setUser(user);

        for (OrderLine orderLine : order.getOrderLines()) {
            Long id = orderLine.getProduct().getId();
            Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
            orderLine.getProduct().setVersion(product.getVersion());
            orderLine.getProduct().setType(product.getType());
        }

        return orderRepository.save(order);
    }
}
