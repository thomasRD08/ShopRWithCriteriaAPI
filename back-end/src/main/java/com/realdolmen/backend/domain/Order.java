package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.listener.OrderListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "`order`")
@EntityListeners(OrderListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "time_stamp")
    private Date timeStamp;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines;
}
