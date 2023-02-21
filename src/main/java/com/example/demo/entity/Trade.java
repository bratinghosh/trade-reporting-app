package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class Trade {
    @Id
    @Column
    private String tradeReference;
    @Column
    private String productId;
    @Column
    private String brokerId;
    @Column
    private Date tradeDate;
    @Column
    private Long quantity;
    @Column
    private Character buySell;
    @Column
    private Double price;
}
