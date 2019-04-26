package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.mapper.OrderLineMapper;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderFacadeImplTest {
    @InjectMocks
    private OrderFacadeImpl orderFacade;
    @Mock
    private OrderService orderService;
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private UserMapper userMapper;
    @Mock
    private OrderLineMapper orderLineMapper;

    @Test
    public void testShouldMockFacade() {
        assertThat(orderFacade).isNotNull();
    }

    @Test
    public void testShouldInvokeServiceSave() {
        OrderDto orderDto = new OrderDto();

        orderFacade.saveOrder(orderDto);

        verify(orderService, times(1)).save(any());
    }
}
