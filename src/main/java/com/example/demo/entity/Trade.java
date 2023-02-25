package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Trade {
    @Id
    @Column
    private String tradeRef;
//    @Column
//    private String productId;
//    @Column
//    private String brokerId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name="brokerId",
            referencedColumnName="brokerId"
    )
    private Broker broker;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name="productId",
            referencedColumnName="productId"
    )
    private Product product;
    @Column
    private Date tradeDate;
    @Column
    private Long quantity;
    @Column
    private Character buySell;
    @Column
    private Double price;
}
