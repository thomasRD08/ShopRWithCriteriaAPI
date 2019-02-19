package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Date timeStamp;
    private User user;
    private List<OrderLine> orderLines;
}
