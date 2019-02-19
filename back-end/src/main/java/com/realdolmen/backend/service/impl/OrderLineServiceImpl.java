package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.repository.OrderLineRepository;
import com.realdolmen.backend.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderLineServiceImpl extends CrudServiceImpl<OrderLine, Long> implements OrderLineService {
    private final OrderLineRepository orderLineRepository;

    @Override
    protected JpaRepository<OrderLine, Long> getRepository() {
        return orderLineRepository;
    }
}
