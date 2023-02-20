package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Trade {
    @Id
    private String tradeReference;
    private String productId;
    private Date tradeDate;
    private Long quantity;
    private Character buySell;
    private Double price;
}
