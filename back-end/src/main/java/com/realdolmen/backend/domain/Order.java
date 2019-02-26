package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.listener.OrderListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@EntityListeners(OrderListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time_stamp")
    private Date timeStamp;

    @NotNull(message = "User cannot be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @NotEmpty(message = "Order lines cannot be null or empty")
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines;
}
